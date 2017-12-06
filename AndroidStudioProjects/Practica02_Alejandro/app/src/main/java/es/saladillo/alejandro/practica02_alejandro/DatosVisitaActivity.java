package es.saladillo.alejandro.practica02_alejandro;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.saladillo.alejandro.practica02_alejandro.bd.DAO;
import es.saladillo.alejandro.practica02_alejandro.dialogs.DatePickerDialogFragment;
import es.saladillo.alejandro.practica02_alejandro.dialogs.TimePickerDialogFragment;
import es.saladillo.alejandro.practica02_alejandro.models.Alumno;
import es.saladillo.alejandro.practica02_alejandro.models.Visita;

public class DatosVisitaActivity extends AppCompatActivity implements OnGuardarClick, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
    private final SimpleDateFormat FORMATO_HORA = new SimpleDateFormat("HH:mm", Locale.getDefault());

    @BindView(R.id.txtDia)
    EditText txtDia;
    @BindView(R.id.txtHoraInicio)
    EditText txtHoraInicio;
    @BindView(R.id.txtHoraFin)
    EditText txtHoraFin;
    @BindView(R.id.txtResumen)
    EditText txtResumen;

    private Alumno mAlumno;
    private Visita mVisita;

    private long fecha = 0;
    private String horaInicio, horaFin;

    private boolean horaInicioSelec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_visita);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAlumno = getIntent().getExtras().getParcelable("alumno");
        mVisita = getIntent().getExtras().getParcelable("visita");
        ButterKnife.bind(this);

        if (mVisita != null)
            cargarDatos();
    }

    private void cargarDatos() {
        fecha = mVisita.getFecha();
        horaInicio = mVisita.getHoraInicio();
        horaFin = mVisita.getHoraFin();

        txtDia.setText(FORMATO_FECHA.format(new Date(fecha)));
        txtHoraInicio.setText(horaInicio);
        txtHoraFin.setText(horaFin);
        txtResumen.setText(mVisita.getResumen());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.guardar) {
            guardar();
            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void guardar() {
        if (fecha == 0) { //Fecha vacía.
            Toast.makeText(this, "Error introduce el día", Toast.LENGTH_LONG).show();
        } else {
            DAO dao = DAO.getInstance(this);
            long idAlumno = mAlumno != null ? mAlumno.getId() : mVisita.getIdAlumno();
            Visita visita = new Visita(idAlumno,
                    fecha,
                    horaInicio,
                    horaFin,
                    txtResumen.getText().toString()
            );
            if (mVisita == null) {
                dao.createVisita(visita);
            } else {
                visita.setId(mVisita.getId());
                dao.updateVisita(visita);
            }

            //Oculto el teclado
            View view = getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            if (mAlumno != null)
                ListaTutoriasFragment.actualizar();
            else
                ListaProximasVisitasFragment.actualizar();
            //Vuelve hacia atrás
            onBackPressed();
        }
    }


    @OnClick(R.id.txtDia)
    public void elegirDia() {
        (new DatePickerDialogFragment()).show(getSupportFragmentManager(), "DatePickerDialogFragment");
    }

    @OnClick(R.id.txtHoraInicio)
    public void elegirHoraInicio() {
        TimePickerDialogFragment timePickerDialogFragment = new TimePickerDialogFragment();
        timePickerDialogFragment.show(getSupportFragmentManager(), "TimePickerDialogFragmentHoraInicio");
        horaInicioSelec = true;
    }

    @OnClick(R.id.txtHoraFin)
    public void elegirHoraFin() {
        TimePickerDialogFragment timePickerDialogFragment = new TimePickerDialogFragment();
        timePickerDialogFragment.show(getSupportFragmentManager(), "TimePickerDialogFragmentHoraFin");
        horaInicioSelec = false;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        try {
            fecha = FORMATO_FECHA.parse(String.format(Locale.getDefault(), "%d/%d/%d", i2, i1 + 1, i)).getTime(); //Le sumo 1 al mes porque empieza en 0
            txtDia.setText(String.format(Locale.getDefault(), "%d/%d/%d", i2, i1 + 1, i));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        try {
            String hora = FORMATO_HORA.format(FORMATO_HORA.parse(String.format(Locale.getDefault(), "%d:%d", i, i1)).getTime());

            if (horaInicioSelec) {
                horaInicio = hora;
                txtHoraInicio.setText(hora);
            } else {
                horaFin = hora;
                txtHoraFin.setText(hora);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
