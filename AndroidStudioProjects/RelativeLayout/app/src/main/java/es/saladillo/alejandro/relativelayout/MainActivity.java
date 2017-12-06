package es.saladillo.alejandro.relativelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCancelar;
    private Button btnAceptar;
    private EditText txtNombre;
    private EditText txtClave;
    private int txtVacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtClave = (EditText) findViewById(R.id.txtClave);
        txtVacio = R.string.txtVacio;

        btnCancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                txtNombre.setText(txtVacio);
                txtClave.setText(txtVacio);
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!txtNombre.getText().toString().equals(getString(txtVacio)) && !txtClave.getText().toString().equals(getString(txtVacio)))
                    mostrarMensajeToast(String.format(getString(R.string.toastAceptar), txtNombre.getText().toString()));
                else
                    mostrarMensajeToast(getString(R.string.error));
            }
        });
    }

    private void mostrarMensajeToast(String mensaje) {
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
    }

}
