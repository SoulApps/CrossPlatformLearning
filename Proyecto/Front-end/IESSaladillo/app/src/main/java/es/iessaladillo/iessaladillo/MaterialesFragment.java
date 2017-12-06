package es.iessaladillo.iessaladillo;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.iessaladillo.iessaladillo.adapters.MaterialesAdapter;
import es.iessaladillo.iessaladillo.dialogs.MaterialNuevoDialog;
import es.iessaladillo.iessaladillo.models.Hardware;
import es.iessaladillo.iessaladillo.models.Material;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MaterialesFragment extends Fragment implements OnFabClickInterface {

    @BindView(R.id.pantalla)
    View pantalla;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.btnReintentar)
    Button btnReintentar;
    @BindView(R.id.lstMateriales)
    RecyclerView lstMateriales;
    @BindView(R.id.lblListaVacia)
    TextView lblListaVacia;

    private MaterialesAdapter mAdapter;
    private Hardware mHardware;

    private Material eliminado;
    private int position;

    boolean deshecho = false;

    public MaterialesFragment() {
        // Required empty public constructor
    }

    public static MaterialesFragment newInstance(Hardware hardware) {
        MaterialesFragment fragment = new MaterialesFragment();
        Bundle args = new Bundle();
        args.putParcelable(GlobalValues.ARG_HARDWARE, hardware);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true); //El fragmento se retiene.
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            mHardware = getArguments().getParcelable(GlobalValues.ARG_HARDWARE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_materiales, container, false);

        ButterKnife.bind(this, view);

        mAdapter = new MaterialesAdapter();
        lstMateriales.setAdapter(mAdapter);
        lstMateriales.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        lstMateriales.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }

                    // Cuando se detecta un gesto swipe to dismiss.
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        position = viewHolder.getAdapterPosition();
                        eliminado = mAdapter.remove(position);
                        mHardware.setUnidadesEnUso((short) (mHardware.getUnidadesEnUso() - 1));
                        Snackbar snackbar = Snackbar.make(pantalla, R.string.elemento_eliminado, Snackbar.LENGTH_LONG)
                                .setAction(R.string.deshacer, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mAdapter.add(eliminado, position);
                                        mHardware.setUnidadesEnUso((short) (mHardware.getUnidadesEnUso() + 1));
                                        deshecho = true;
                                    }
                                });

                        //El material se borra cuando desaparece la Snackbar.
                        snackbar.addCallback(new Snackbar.Callback() {
                            @Override
                            public void onDismissed(Snackbar snackbar, int event) {
                                if (!deshecho)
                                    borrarMaterial(eliminado.getCodMaterial());
                            }
                        });
                        snackbar.show();
                    }
                });
        itemTouchHelper.attachToRecyclerView(lstMateriales);
        lstMateriales.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        //Se añaden los materiales.
        cargarMateriales();

        return view;
    }

    @Override
    //Para comunicar a la actividad que se le ha pulsado atrás.
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    getActivity().finish();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    //Abre un diálogo para añadir un material.
    public void onFabClick() {
        MaterialNuevoDialog.newInstance(mHardware)
                .show(getActivity().getSupportFragmentManager(), "Añadir material");
        lblListaVacia.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.btnReintentar)
    void cargarMateriales() {
        Call<ArrayList<Material>> peticion = Api.getApiInterface()
                .verMaterialesPorCodBarras( mHardware.getCodBarras(), GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
        peticion.enqueue(new Callback<ArrayList<Material>>() {
            @Override
            public void onResponse(Call<ArrayList<Material>> call, Response<ArrayList<Material>> response) {
                progressBar.setVisibility(View.INVISIBLE);
                // Si la respuesta es correcta.
                if (response != null && response.isSuccessful()) {
                    mAdapter.addAll(response.body());
                    if (mAdapter.isEmpty())
                        lblListaVacia.setVisibility(View.VISIBLE);
                } else
                    btnReintentar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<ArrayList<Material>> call, Throwable t) {
                Toast.makeText(getContext(), R.string.error_internet, Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
                btnReintentar.setVisibility(View.VISIBLE);
            }
        });
    }

    public void onMaterialAnhadido(Material material) {
        mAdapter.add(material, mAdapter.getItemCount());
        //Se aumenta en 1 las unidades en uso.
        mHardware.setUnidadesEnUso((short) (mHardware.getUnidadesEnUso() + 1));
    }

    private void borrarMaterial(int codMaterial) {
        Call<Void> peticion = Api.getApiInterface()
                .eliminarMaterial(codMaterial, GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
        peticion.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getContext(), R.string.error_internet, Toast.LENGTH_LONG).show();
                //Lo vuelve a añadir si falla.
                mHardware.setUnidadesEnUso((short) (mHardware.getUnidadesEnUso() + 1));
                mAdapter.add(eliminado, position);
            }
        });
    }

    Hardware getHardware() {
        return mHardware;
    }
}
