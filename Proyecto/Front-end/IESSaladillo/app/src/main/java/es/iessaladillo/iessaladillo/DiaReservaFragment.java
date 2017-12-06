package es.iessaladillo.iessaladillo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import es.iessaladillo.iessaladillo.adapters.AulasAdapter;
import es.iessaladillo.iessaladillo.adapters.TramosHorariosReservaAdapter;
import es.iessaladillo.iessaladillo.models.Aula;
import es.iessaladillo.iessaladillo.models.TramoHorarioReserva;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiaReservaFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.lblDia)
    TextView lblDia;
    @BindView(R.id.spnAulas)
    Spinner spnAulas;
    @BindView(R.id.lstHoras)
    ListView lstHoras;
    @BindView(R.id.btnReintentar)
    Button btnReintentar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private TramosHorariosReservaAdapter mTramosHorariosReservaAdapter;
    private AulasAdapter mAulasAdapter;

    private String mDia;
    private Aula mAula;
    private boolean cargado;

    public DiaReservaFragment() {
        // Required empty public constructor
    }

    public static DiaReservaFragment newInstance(String dia) {
        DiaReservaFragment fragment = new DiaReservaFragment();
        Bundle args = new Bundle();
        args.putString(GlobalValues.ARG_DIA, dia);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true); //El fragmento se retiene.
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mDia = getArguments().getString(GlobalValues.ARG_DIA);
        }
        cargado = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dia_reserva, container, false);
        ButterKnife.bind(this, view);
        refresh.setOnRefreshListener(this);

        lblDia.setText(toLongString(mDia));

        //Si es la primera que se crea, se crean los adaptadores y se cargan las aulas.
        if (!cargado) {
            mAulasAdapter = new AulasAdapter(getContext());
            mTramosHorariosReservaAdapter = new TramosHorariosReservaAdapter(getContext(), mDia);
            cargarAulas(); //Se cargan las aulas.
            //cargado = true; //El estado se cambiará cuando se hayan cargado los tramos horarios.
        } else {
            spnAulas.setVisibility(View.VISIBLE); //Si no, hago visible el Spinner.
        }
        spnAulas.setAdapter(mAulasAdapter);
        lstHoras.setAdapter(mTramosHorariosReservaAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_actualizar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actualizar) {
            cargarReservas();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //El OnClick solo se puede ejecutar cuando no se tienen las aulas.
    @OnClick(R.id.btnReintentar)
    void cargarAulas() {
        progressBar.setVisibility(View.VISIBLE);
        btnReintentar.setVisibility(View.INVISIBLE);

        Call<ArrayList<Aula>> peticion = Api.getApiInterface().verAulas(GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
        peticion.enqueue(new Callback<ArrayList<Aula>>() {
            @Override
            public void onResponse(Call<ArrayList<Aula>> call, Response<ArrayList<Aula>> response) {
                // Si la respuesta es correcta.
                if (response != null && response.isSuccessful()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    ((DiaReservaActivity) getActivity()).getSupportActionBar().setTitle(R.string.reservar);
                    mAulasAdapter.actualizar(response.body());
                } else
                    btnReintentar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<ArrayList<Aula>> call, Throwable t) {
                Toast.makeText(getContext(), R.string.error_internet, Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
                btnReintentar.setVisibility(View.VISIBLE);
            }
        });
    }


    @OnItemSelected(R.id.spnAulas)
    void seleccionarAula(int position) {
        Aula aula = (Aula) spnAulas.getItemAtPosition(position);

        /*Evito que se cargue cuando se gira la pantalla; ya que cuando se le asigna el adaptador
        al Spinner, se selecciona el primer elemento y entra aquí.*/
        if (mAula == null || !mAula.getNombre().equals(aula.getNombre())) { //Es nulo cuando se muestra la pantalla.
            mAula = aula;
            cargarReservas();
        }
    }

    //El OnClick solo se puede ejecutar si se han buscado las aulas previamente.
    @OnClick(R.id.btnReintentar)
    void cargarReservas() {
        if (mAula != null) {
            lstHoras.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            btnReintentar.setVisibility(View.INVISIBLE);

            Call<ArrayList<TramoHorarioReserva>> peticion = Api.getApiInterface()
                    .verReservas(mAula.getPlanta(), mAula.getCodAula(), mDia, GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
            peticion.enqueue(new Callback<ArrayList<TramoHorarioReserva>>() {
                @Override
                public void onResponse(Call<ArrayList<TramoHorarioReserva>> call, Response<ArrayList<TramoHorarioReserva>> response) {
                    progressBar.setVisibility(View.INVISIBLE);
                    // Si la respuesta es correcta.
                    if (response != null && response.isSuccessful()) {
                        lstHoras.setVisibility(View.VISIBLE);
                        mTramosHorariosReservaAdapter.actualizar(mAula, response.body());
                        spnAulas.setVisibility(View.VISIBLE);
                        cargado = true;

                    } else
                        btnReintentar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailure(Call<ArrayList<TramoHorarioReserva>> call, Throwable t) {
                    Toast.makeText(getContext(), R.string.error_internet, Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    btnReintentar.setVisibility(View.VISIBLE);
                    refresh.setRefreshing(false);
                }
            });
        }
    }

    @Override
    public void onRefresh() {
        refresh.setRefreshing(false); //No quiero que se use la progressbar por defecto.
        cargarReservas();
    }

    //Formatea una cadena que representa una fecha a otra forma.
    private static String toLongString(String fecha) {
        final SimpleDateFormat FORMATO = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy", Locale.getDefault());
        String resultado = null;
        try {
            resultado = FORMATO.format(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(fecha));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultado.replace(String.valueOf(resultado.charAt(0)), String.valueOf(resultado.charAt(0)).toUpperCase()); //Primera letra mayúscula.
    }
}
