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
import es.iessaladillo.iessaladillo.adapters.InventarioAdapter;
import es.iessaladillo.iessaladillo.models.Hardware;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class InventarioFragment extends Fragment
        implements SwipeRefreshLayout.OnRefreshListener, OnFabClickInterface {

    @BindView(R.id.lstInventario)
    ListView lstInventario;
    @BindView(R.id.lblEmptyView)
    TextView lblEmptyView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.btnReintentar)
    Button btnReintentar;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private InventarioAdapter mAdapter;
    private boolean cargado;

    public InventarioFragment() {
        // Required empty public constructor
    }

    public static InventarioFragment newInstance() {
        return new InventarioFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        cargado = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventario, container, false);
        ButterKnife.bind(this, view);

        refresh.setOnRefreshListener(this);


        //Si es la primera que se crea, se crea el adapador.
        if (!cargado)
            mAdapter = new InventarioAdapter(getContext());
        lstInventario.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        cargarInventario(); //Se carga el inventario.
        //cargado = true; //El estado se cambiará cuando se hayan cargado las incidencias.
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_actualizar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

       if (id == R.id.actualizar) {
            cargarInventario();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btnReintentar)
    void cargarInventario() {
        btnReintentar.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        Call<ArrayList<Hardware>> peticion = Api.getApiInterface().verInventario(GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
        peticion.enqueue(new Callback<ArrayList<Hardware>>() {
            @Override
            public void onResponse(Call<ArrayList<Hardware>> call, Response<ArrayList<Hardware>> response) {
                progressBar.setVisibility(View.INVISIBLE);
                if (response != null && response.isSuccessful()) {
                    if (response.body().isEmpty())
                        lblEmptyView.setVisibility(View.VISIBLE);
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
            public void onFailure(Call<ArrayList<Hardware>> call, Throwable t) {
                Toast.makeText(getContext(), R.string.error_internet, Toast.LENGTH_LONG).show();
                mAdapter.clear();
                progressBar.setVisibility(View.INVISIBLE);
                btnReintentar.setVisibility(View.VISIBLE);
            }
        });
    }

    @OnItemClick(R.id.lstInventario)
    void verHardware(int position) {
        Intent intent = new Intent(getContext(), DatosHardwareActivity.class);
        intent.putExtra(GlobalValues.ARG_INVENTARIO, mAdapter.getItem(position));
        startActivityForResult(intent, GlobalValues.RC_ACTUALIZAR_INVENTARIO);
    }

    @Override
    public void onRefresh() {
        refresh.setRefreshing(false); //No quiero que se use la progressbar por defecto.
        cargarInventario();
    }

    @Override
    public void onFabClick() {
        startActivityForResult(new Intent(getContext(), DatosHardwareActivity.class), GlobalValues.RC_ACTUALIZAR_INVENTARIO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == GlobalValues.RC_ACTUALIZAR_INVENTARIO) {
            cargarInventario();
        }
    }
}
