package es.iessaladillo.iessaladillo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import es.iessaladillo.iessaladillo.models.Hardware;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatosHardwareActivity extends AppCompatActivity {

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.txtCodBarras)
    TextInputEditText txtCodBarras;
    @BindView(R.id.txtDescripcion)
    TextInputEditText txtDescripcion;
    @BindView(R.id.txtUnidadesTotales)
    TextInputEditText txtUnidadesTotales;
    @BindView(R.id.unidadesDisponibles)
    View unidadesDisponibles;
    @BindView(R.id.txtUnidadesDisponibles)
    TextInputEditText txtUnidadesDisponibles;
    @BindView(R.id.btnVerMateriales)
    Button btnVerMateriales;

    private Hardware mHardware;
    private boolean nuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_hardware);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        txtDescripcion.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        txtDescripcion.setRawInputType(InputType.TYPE_CLASS_TEXT);

        if (getIntent().getExtras() != null) {
            mHardware = getIntent().getExtras().getParcelable(GlobalValues.ARG_INVENTARIO);
            if (mHardware != null) {
                mostrarHardware();
                nuevo = false;
            }
        } else {
            mHardware = new Hardware();
            nuevo = true;
            btnVerMateriales.setVisibility(View.INVISIBLE);
        }
    }

    private void mostrarHardware() {
        txtCodBarras.setText(mHardware.getCodBarras());
        txtCodBarras.setFocusable(false);
        txtDescripcion.setText(mHardware.getDescripcion());
        txtUnidadesTotales.setText(String.valueOf(mHardware.getUnidadesTotales()));
        txtUnidadesDisponibles.setText(String.valueOf(mHardware.getUnidadesTotales() - mHardware.getUnidadesEnUso()));
        unidadesDisponibles.setVisibility(View.VISIBLE);
    }

    private boolean datosHardwareValidos() {
        boolean valido = true;
        int codBarras = txtCodBarras.length();
        int descripcion = txtDescripcion.length();
        int unidadesTotales = txtUnidadesTotales.length();

        if (codBarras == 0 || codBarras > GlobalValues.MAX_LONGITUD_COD_BARRAS) {
            txtCodBarras.setError(getString(R.string.error_cod_barras));
            valido = false;
        }

        if (descripcion == 0 || descripcion > GlobalValues.MAX_LONGITUD_DESCRIPCION) {
            txtDescripcion.setError(getString(R.string.error_descripcion));
            valido = false;
        }

        if (unidadesTotales == 0) {
            txtUnidadesTotales.setError(getString(R.string.error_unidades));
            valido = false;
        }

        if (!nuevo && Short.parseShort(txtUnidadesTotales.getText().toString()) < mHardware.getUnidadesEnUso()) {
            txtUnidadesTotales.setError(getString(R.string.error_act_unidades));
            valido = false;
        }

        return valido;
    }

    @OnClick(R.id.btnVerMateriales)
    void verMateriales() {
        Intent intent = new Intent(this, MaterialesActivity.class);
        intent.putExtra(GlobalValues.ARG_HARDWARE, mHardware);
        startActivityForResult(intent, GlobalValues.RC_MATERIAL);
    }

    @OnClick(R.id.fab)
    void guardar() {
        if (datosHardwareValidos())
            enviarDatos();
    }

    @OnEditorAction(R.id.txtUnidadesTotales)
    boolean guardarEnter() {
        if (datosHardwareValidos())
            enviarDatos();
        return true;
    }

    private void enviarDatos() {
        fab.setEnabled(false);

        mHardware.setCodBarras(txtCodBarras.getText().toString());
        mHardware.setDescripcion(txtDescripcion.getText().toString());
        mHardware.setUnidadesTotales(Short.valueOf(txtUnidadesTotales.getText().toString()));

        Call<Void> peticion;
        if (!nuevo) {
            peticion = Api.getApiInterface()
                    .actualizarHardware(mHardware.getCodBarras(), mHardware, GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
        } else {
            peticion = Api.getApiInterface().crearHardware(GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken(), mHardware);
        }
        peticion.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                // Si la respuesta es correcta.
                if (response != null && response.isSuccessful()) {
                    if (nuevo)
                        Toast.makeText(DatosHardwareActivity.this, "Componente añadido", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DatosHardwareActivity.this, "Componente actualizado", Toast.LENGTH_SHORT).show();

                    //Se cierra la actividad y se vuelve al inventario.
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(DatosHardwareActivity.this, R.string.error_cod_barras_repetido, Toast.LENGTH_LONG).show();
                    fab.setEnabled(true);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(DatosHardwareActivity.this, "Error, no hay conexión a Internet", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Hardware hardware;
        if (requestCode == GlobalValues.RC_MATERIAL && resultCode == RESULT_OK) {
            if (data != null) {
                if (data.getExtras() != null) {
                    hardware = data.getExtras().getParcelable(GlobalValues.ARG_HARDWARE_VUELTA);
                    if (hardware != null) {
                        mHardware.setUnidadesEnUso(hardware.getUnidadesEnUso());
                        short unidadesDisponibles = (short) (mHardware.getUnidadesTotales() - mHardware.getUnidadesEnUso());
                        txtUnidadesDisponibles.setText(String.valueOf(unidadesDisponibles));
                    }
                }
            }
        }
    }
}
