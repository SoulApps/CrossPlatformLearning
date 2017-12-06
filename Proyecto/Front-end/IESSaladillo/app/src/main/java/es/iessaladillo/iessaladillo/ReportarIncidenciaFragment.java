package es.iessaladillo.iessaladillo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnItemSelected;
import es.iessaladillo.iessaladillo.adapters.AulasAdapter;
import es.iessaladillo.iessaladillo.adapters.MaterialesSpinnerAdapter;
import es.iessaladillo.iessaladillo.models.Aula;
import es.iessaladillo.iessaladillo.models.Incidencia;
import es.iessaladillo.iessaladillo.models.Material;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ReportarIncidenciaFragment extends Fragment implements OnFabClickInterface {

    @BindView(R.id.spnAulas)
    Spinner spnAulas;
    @BindView(R.id.spnMateriales)
    Spinner spnMateriales;
    @BindView(R.id.tilDescripcion)
    TextInputLayout tilDescripcion;
    @BindView(R.id.txtDescripcion)
    TextInputEditText txtDescripcion;
    @BindView(R.id.btnReintentar)
    Button btnReintentar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.pantalla)
    View pantalla;

    private Aula mAula;
    private Material mMaterial;

    private AulasAdapter mAulasAdapter;
    private MaterialesSpinnerAdapter mMaterialesSpinnerAdapter;

    private boolean cargado;

    public ReportarIncidenciaFragment() {
        // Required empty public constructor
    }

    public static ReportarIncidenciaFragment newInstance() {
        return new ReportarIncidenciaFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
        cargado = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reportar_incidencia, container, false);
        ButterKnife.bind(this, view);

        //Si es la primera que se crea, se crean los adaptadores y se cargan las aulas.
        if (!cargado) {
            mAulasAdapter = new AulasAdapter(getContext());
            mMaterialesSpinnerAdapter = new MaterialesSpinnerAdapter(getContext());
            cargarAulas(); //Se cargan las aulas.
            //cargado = true; //El estado se cambiará cuando se hayan cargado los tramos horarios.
        } else {
            spnAulas.setVisibility(View.VISIBLE); //Si no, hago visible el Spinner.
        }
        spnAulas.setAdapter(mAulasAdapter);
        spnMateriales.setAdapter(mMaterialesSpinnerAdapter);

        txtDescripcion.setImeOptions(EditorInfo.IME_ACTION_DONE);
        txtDescripcion.setRawInputType(InputType.TYPE_CLASS_TEXT);

        return view;
    }

    //El OnClick solo se puede ejecutar cuando no se tienen las aulas.
    @OnClick(R.id.btnReintentar)
    void cargarAulas() {
        if (mAula == null) {
            pantalla.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            btnReintentar.setVisibility(View.INVISIBLE);
            tilDescripcion.setVisibility(View.INVISIBLE);

            Call<ArrayList<Aula>> peticion = Api.getApiInterface().verAulas(GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
            peticion.enqueue(new Callback<ArrayList<Aula>>() {
                @Override
                public void onResponse(Call<ArrayList<Aula>> call, Response<ArrayList<Aula>> response) {
                    // Si la respuesta es correcta.
                    if (response != null && response.isSuccessful()) {
                        mAulasAdapter.actualizar(response.body());
                        tilDescripcion.setVisibility(View.VISIBLE);
                        pantalla.setVisibility(View.VISIBLE);
                    } else {
                        progressBar.setVisibility(View.INVISIBLE);
                        btnReintentar.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Aula>> call, Throwable t) {
                    Toast.makeText(getContext(), R.string.error_internet, Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    btnReintentar.setVisibility(View.VISIBLE);
                    pantalla.setVisibility(View.INVISIBLE);
                }
            });
        }
    }


    @OnItemSelected(R.id.spnAulas)
    void seleccionarAula(int position) {
        Aula aula = (Aula) spnAulas.getItemAtPosition(position);

        /*Evito que se cargue cuando se gira la pantalla; ya que cuando se le asigna el adaptador
        al Spinner, se selecciona el primer elemento y entra aquí.*/
        if (mAula == null || !mAula.getNombre().equals(aula.getNombre())) //Es nulo cuando se muestra la pantalla.
            mAula = aula;

        cargarMateriales();
    }

    @OnClick(R.id.btnReintentar)
    //Se ejecutará si las aulas ya han sido cargadas.
    void cargarMateriales() {
        if (mAula != null) {
            pantalla.setVisibility(View.VISIBLE);
            spnMateriales.setVisibility(View.INVISIBLE);
            tilDescripcion.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            btnReintentar.setVisibility(View.INVISIBLE);

            Call<ArrayList<Material>> peticion = Api.getApiInterface()
                    .verMaterialesPorAula(mAula.getPlanta(), mAula.getCodAula(), GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
            peticion.enqueue(new Callback<ArrayList<Material>>() {
                @Override
                public void onResponse(Call<ArrayList<Material>> call, Response<ArrayList<Material>> response) {
                    progressBar.setVisibility(View.INVISIBLE);
                    // Si la respuesta es correcta.
                    if (response != null && response.isSuccessful()) {
                        if (!response.body().isEmpty()) {
                            mMaterialesSpinnerAdapter.actualizar(response.body());
                            spnMateriales.setVisibility(View.VISIBLE);
                            tilDescripcion.setVisibility(View.VISIBLE);
                            txtDescripcion.setEnabled(true);
                            cargado = true;
                        }
                    } else
                        btnReintentar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailure(Call<ArrayList<Material>> call, Throwable t) {
                    Toast.makeText(getContext(), R.string.error_internet, Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    btnReintentar.setVisibility(View.VISIBLE);
                    pantalla.setVisibility(View.INVISIBLE);
                }
            });
        }
    }

    @OnItemSelected(R.id.spnMateriales)
    void seleccionarMaterial(int position) {
        Material material = (Material) spnMateriales.getItemAtPosition(position);

        /*Evito que se cargue cuando se gira la pantalla; ya que cuando se le asigna el adaptador
        al Spinner, se selecciona el primer elemento y entra aquí.*/
        if (mMaterial == null || !mMaterial.getCodMaterial().equals(material.getCodMaterial())) //Es nulo cuando se muestra la pantalla.
            mMaterial = material;
    }

    private boolean datosIncidenciaValidos() {
        boolean valido = true;
        int len = txtDescripcion.length();

        if (len == 0 || len > GlobalValues.MAX_LONGITUD_DESCRIPCION) {
            txtDescripcion.setError(getString(R.string.error_descripcion));
            valido = false;
        }

        return valido;
    }

    private void enviarDatos() {
        if (datosIncidenciaValidos()) {
            progressBar.setVisibility(View.VISIBLE);
            Incidencia incidencia = new Incidencia(GlobalValues.profesor.getCodProf(), mMaterial.getCodMaterial(), txtDescripcion.getText().toString());

            Call<Void> peticion = Api.getApiInterface().reportarIncidencia(GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken(), incidencia);
            peticion.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    progressBar.setVisibility(View.INVISIBLE);
                    // Si la respuesta es correcta.
                    if (response != null && response.isSuccessful()) {
                        txtDescripcion.setText("");
                        Toast.makeText(getContext(), R.string.incidencia_reportada, Toast.LENGTH_SHORT).show();
                    }
                    ((MainActivity) getActivity()).setFabEnabled(true);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    progressBar.setVisibility(View.INVISIBLE);
                    ((MainActivity) getActivity()).setFabEnabled(true);
                    Toast.makeText(getContext(), R.string.error_internet, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public void onFabClick() {
        ((MainActivity) getActivity()).setFabEnabled(false);
        enviarDatos();
    }

    @OnEditorAction(R.id.txtDescripcion)
    boolean txtDescripcionEnter() {
        ((MainActivity) getActivity()).setFabEnabled(false);
        enviarDatos();
        return true;
    }
}
