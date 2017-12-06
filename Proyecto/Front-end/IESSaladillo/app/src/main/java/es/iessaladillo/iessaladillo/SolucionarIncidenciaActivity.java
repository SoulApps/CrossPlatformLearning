package es.iessaladillo.iessaladillo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import es.iessaladillo.iessaladillo.dialogs.IncidenciaSolucionadaDialog;
import es.iessaladillo.iessaladillo.models.EstadoIncidencia;
import es.iessaladillo.iessaladillo.models.Incidencia;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SolucionarIncidenciaActivity extends AppCompatActivity implements IncidenciaSolucionadaDialog.IncidenciaSolucionadaListener {

    @BindView(R.id.lblMaterial)
    TextView lblMaterial;
    @BindView(R.id.lblProfesor)
    TextView lblProfesor;
    @BindView(R.id.lblFecha)
    TextView lblFecha;
    @BindView(R.id.lblDescripcion)
    TextView lblDescripcion;
    @BindView(R.id.txtHistorial)
    TextInputEditText txtHistorial;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private Incidencia mIncidencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solucionar_incidencia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        mostrarDatosIncidencia();
    }

    private void mostrarDatosIncidencia() {
        mIncidencia = getIntent().getExtras().getParcelable(GlobalValues.ARG_INCIDENCIA);
        lblMaterial.setText(String.format("%s.%s.%s",
                mIncidencia.getPlanta(), mIncidencia.getCodAula(), mIncidencia.getCodMaterial()));
        lblProfesor.setText(String.format("%s %s",
                mIncidencia.getNombre(), mIncidencia.getApellido1()));
        lblFecha.setText(GlobalValues.FORMATO_FECHA_INCIDENCIA.format(mIncidencia.getFecha()));
        lblFecha.setText(GlobalValues.FORMATO_FECHA_INCIDENCIA.format(mIncidencia.getFecha()));
        lblDescripcion.setText(mIncidencia.getDescripcion());
        txtHistorial.setText(mIncidencia.getHistorial());
        
        if (mIncidencia.getEstado() == EstadoIncidencia.SOLUCIONADO) {
            txtHistorial.setEnabled(false);
            fab.setVisibility(View.INVISIBLE);
        }
    }

    private boolean datosIncidenciaValidos() {
        boolean valido = true;
        int len = txtHistorial.length();

        if (len == 0 || len > GlobalValues.MAX_LONGITUD_DESCRIPCION) {
            txtHistorial.setError(getString(R.string.error_descripcion));
            valido = false;
        }

        return valido;
    }

    private void comprobarSolucionado() {
        if (datosIncidenciaValidos()) {
            new IncidenciaSolucionadaDialog().show(this.getSupportFragmentManager(), getString(R.string.incidencia_solucionada));
            mIncidencia.setHistorial(txtHistorial.getText().toString());
        }
    }
    
    @OnClick(R.id.fab)
    void comprobarSolucionadoFab() {
        comprobarSolucionado();
    }

    @OnEditorAction(R.id.txtHistorial)
    boolean comprobarSolucionadoEnter() {
        comprobarSolucionado();
        return true;
    }

    private void enviarDatos() {
        fab.setEnabled(false);

        Call<Void> peticion = Api.getApiInterface()
                .actualizarIncidencia(mIncidencia.getCodIncidencia(), mIncidencia, GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
        peticion.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                // Si la respuesta es correcta.
                if (response != null && response.isSuccessful()) {
                    Toast.makeText(SolucionarIncidenciaActivity.this, R.string.incidencia_actualizada, Toast.LENGTH_SHORT).show();

                    //Se cierra la actividad y se vuelve a la lista de incidencias.
                    setResult(RESULT_OK);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SolucionarIncidenciaActivity.this, R.string.error_internet, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onIncidenciaSolucionada() {
        mIncidencia.setEstado(EstadoIncidencia.SOLUCIONADO);
        enviarDatos();
    }

    @Override
    public void onIncidenciaNoSolucionada() {
        mIncidencia.setEstado(EstadoIncidencia.REVISADO);
        enviarDatos();
    }
}
