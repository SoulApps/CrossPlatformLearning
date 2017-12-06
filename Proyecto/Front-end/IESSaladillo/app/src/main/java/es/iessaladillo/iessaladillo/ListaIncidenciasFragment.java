package es.iessaladillo.iessaladillo;


import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import es.iessaladillo.iessaladillo.adapters.IncidenciasAdapter;
import es.iessaladillo.iessaladillo.models.Incidencia;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class ListaIncidenciasFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.lstIncidencias)
    ListView lstIncidencias;
    @BindView(R.id.lblEmptyView)
    TextView lblEmptyView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.btnReintentar)
    Button btnReintentar;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private IncidenciasAdapter mAdapter;

    private boolean cargado, verSolucinadas, verAntiguos;

    public ListaIncidenciasFragment() {
        // Required empty public constructor
    }

    public static ListaIncidenciasFragment newInstance() {
        return new ListaIncidenciasFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        cargado = false;
        verSolucinadas = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_incidencias, container, false);
        ButterKnife.bind(this, view);

        refresh.setOnRefreshListener(this);

        //Si es la primera que se crea, se crean los adaptadores y se cargan las incidencias.
        if (!cargado) {
            mAdapter = new IncidenciasAdapter(getContext());
            cargarIncidencias(); //Se cargan las incidencias que no están solucionadas.
            //cargado = true; //El estado se cambiará cuando se hayan cargado las incidencias.
        }

        lstIncidencias.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_lista_incidencias, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.chkCompletadas) {
            boolean checked = item.isChecked();
            verSolucinadas = !checked; //Por alguna razón va al revés.
            item.setChecked(!checked);
            cargarIncidencias();
            return true;
        } else if (id == R.id.chkAntiguas) {
            boolean checked = item.isChecked();
            verAntiguos = !checked; //Por alguna razón va al revés.
            item.setChecked(!checked);
            cargarIncidencias();
            return true;
        }else if (id == R.id.actualizar) {
            cargarIncidencias();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btnReintentar)
    void cargarIncidencias() {
        btnReintentar.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        Call<ArrayList<Incidencia>> peticion = Api.getApiInterface().verIncidencias(GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken(), verSolucinadas, verAntiguos);
        peticion.enqueue(new Callback<ArrayList<Incidencia>>() {
            @Override
            public void onResponse(Call<ArrayList<Incidencia>> call, Response<ArrayList<Incidencia>> response) {
                progressBar.setVisibility(View.INVISIBLE);
                if (response != null && response.isSuccessful()) {
                    if (response.body().isEmpty()) {
                        lblEmptyView.setVisibility(View.VISIBLE);
                        mAdapter.clear();
                    }
                    else {
                        lblEmptyView.setVisibility(View.INVISIBLE);
                        mAdapter.actualizar(response.body());
                        cargado = true;
                    }
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    btnReintentar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Incidencia>> call, Throwable t) {
                Toast.makeText(getContext(), R.string.error_internet, Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
                btnReintentar.setVisibility(View.VISIBLE);
            }
        });
    }

    @OnItemClick(R.id.lstIncidencias)
    void verIncidencia(int position) {
        Intent intent = new Intent(getContext(), SolucionarIncidenciaActivity.class);
        intent.putExtra(GlobalValues.ARG_INCIDENCIA, mAdapter.getItem(position));
        startActivityForResult(intent, GlobalValues.RC_SOLUCIONAR_INCIDENCIA);
    }

    @Override
    public void onRefresh() {
        refresh.setRefreshing(false); //No quiero que se use la progressbar por defecto.
        cargarIncidencias();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == GlobalValues.RC_SOLUCIONAR_INCIDENCIA)
            cargarIncidencias();
    }
}
