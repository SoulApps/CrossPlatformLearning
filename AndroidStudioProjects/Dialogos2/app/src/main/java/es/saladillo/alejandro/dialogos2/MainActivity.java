package es.saladillo.alejandro.dialogos2;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NombreDialog.NombreDialogListener, DatePickerDialog.OnDateSetListener {

    private EditText txtNombre;
    private EditText txtFnac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtFnac = (EditText) findViewById(R.id.txtFnac);

        txtNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NombreDialog().show(MainActivity.this.getSupportFragmentManager(), "Nombre");
            }
        });

        txtFnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FnacDialog().show(MainActivity.this.getSupportFragmentManager(), "Fnac");
            }
        });
    }


    @Override
    public void onAceptar(String nombre) {
        txtNombre.setText(nombre);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        txtFnac.setText(String.format(Locale.getDefault(), "%d/%d/%d", dayOfMonth, month + 1, year));
    }
}
