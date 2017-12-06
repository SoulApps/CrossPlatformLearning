package es.iessaladillo.iessaladillo.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import es.iessaladillo.iessaladillo.MaterialesActivity;
import es.iessaladillo.iessaladillo.R;
import es.iessaladillo.iessaladillo.adapters.AulasAdapter;
import es.iessaladillo.iessaladillo.models.Aula;
import es.iessaladillo.iessaladillo.models.Hardware;
import es.iessaladillo.iessaladillo.models.Material;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alejandro on 25/05/2017.
 */

public class MaterialNuevoDialog extends DialogFragment {

    private static final String ARG_HARDWARE_MATERIAL = "arg_hardware_material";
    private AlertDialog dialog = null;

    private View view;
    private ProgressBar progressBar;
    private Button btnReintentar;
    private Spinner spnAulas;
    private TextInputEditText txtCodMaterial;

    private AulasAdapter mAulasAdapter;
    private Hardware mHardware;

    public static MaterialNuevoDialog newInstance(Hardware hardware) {
        MaterialNuevoDialog dialog = new MaterialNuevoDialog();

        Bundle args = new Bundle();

        args.putParcelable(ARG_HARDWARE_MATERIAL, hardware);
        dialog.setArguments(args);

        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHardware = getArguments().getParcelable(ARG_HARDWARE_MATERIAL);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        final int codMaterial;
        final Aula aula;

        view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_material_nuevo, null);
        b.setView(view);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        btnReintentar = (Button) view.findViewById(R.id.btnReintentar);
        txtCodMaterial = (TextInputEditText) view.findViewById(R.id.txtCodMaterial);
        spnAulas = (Spinner) view.findViewById(R.id.spnAulas);
        mAulasAdapter = new AulasAdapter(getContext());
        spnAulas.setAdapter(mAulasAdapter);

        b.setTitle(R.string.mesanje_asignar);
        b.setPositiveButton(R.string.listo, null);

        b.setNegativeButton(R.string.cancelar, null);

        dialog = b.create();
        cargarAulas(dialog);

        txtCodMaterial.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    anhadir(dialog, mHardware.getCodBarras(), Integer.parseInt(txtCodMaterial.getText().toString()), view);
                    return true;
                }
                return false;
            }
        });

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (txtCodMaterial.getText().length() > 0 && txtCodMaterial.getText().length() <= 10) {
                            anhadir(dialog, mHardware.getCodBarras(), Integer.parseInt(txtCodMaterial.getText().toString()), view);
                        } else {
                            txtCodMaterial.setError(getString(R.string.error_codigo));
                        }
                    }
                });

                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        return dialog;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setVisibility(View.INVISIBLE);
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setVisibility(View.INVISIBLE);
    }

    private void cargarAulas(final AlertDialog dialog) {
        Call<ArrayList<Aula>> peticion = Api.getApiInterface().verAulas(GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
        peticion.enqueue(new Callback<ArrayList<Aula>>() {
            @Override
            public void onResponse(Call<ArrayList<Aula>> call, Response<ArrayList<Aula>> response) {
                // Si la respuesta es correcta.
                if (response != null && response.isSuccessful()) {
                    mAulasAdapter.actualizar(response.body());
                    view.setVisibility(View.VISIBLE);
                    dialog.getButton(DialogInterface.BUTTON_POSITIVE).setVisibility(View.VISIBLE);
                    dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setVisibility(View.VISIBLE);
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
                view.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void anhadir(final AlertDialog dialog, final String codBarras, int codMaterial, final View btnOk) {
        final Aula aula = (Aula) spnAulas.getSelectedItem();
        final Material material = new Material();

        material.setCodBarras(codBarras);
        material.setCodMaterial(codMaterial);
        material.setPlanta(aula.getPlanta());
        material.setCodAula(aula.getCodAula());

        btnOk.setEnabled(false);

        Call<String> peticion = Api.getApiInterface()
                .anhadirMaterial(GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken(), material);
        peticion.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                // Si la respuesta es correcta.
                if (response != null && response.isSuccessful()) {
                    if (response.body().equals("0")) {
                        Toast.makeText(getContext(), R.string.asignacion_ok, Toast.LENGTH_SHORT).show();
                        material.setNombre((((Aula) spnAulas.getSelectedItem()).getNombre()));
                        ((MaterialesActivity) getActivity()).onMaterialAnhadido(material);
                        dialog.dismiss();
                    } else if (response.body().equals("1")) {
                        txtCodMaterial.setError(getString(R.string.codigo_repetido));
                        btnOk.setEnabled(true);
                    } else {
                        txtCodMaterial.setError(getString(R.string.no_unidades_disponibles));
                        btnOk.setEnabled(true);
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getContext(), R.string.error_internet, Toast.LENGTH_LONG).show();
                btnOk.setEnabled(true);
            }
        });
    }
}
