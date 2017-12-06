package es.saladillo.alejandro.textinputlayout;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAceptar;
    TextInputLayout tilEmail;
    TextInputLayout tilTelefono;
    TextInputEditText txtNombre;
    TextInputEditText txtTelefono;
    TextInputEditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        txtNombre = (TextInputEditText) findViewById(R.id.txtNombre);
        txtTelefono = (TextInputEditText) findViewById(R.id.txtTelefono);
        txtEmail = (TextInputEditText) findViewById(R.id.txtEmail);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        tilTelefono = (TextInputLayout) findViewById(R.id.tilTelefono);

        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                comprobarBtnAceptar();
            }
        });

        comprobarTelefono();
        comprobarEmail();
        btnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.aceptado, Toast.LENGTH_LONG).show();
            }
        });

        comprobarBtnAceptar();
    }

    public void comprobarBtnAceptar() {
        if (txtNombre.getText().toString().equals("") || !comprobarTelefonoValido(txtTelefono.getText().toString()) || !comprobarEmailValido(txtEmail))
            btnAceptar.setEnabled(false);
        else
            btnAceptar.setEnabled(true);
    }


    private void comprobarEmail() {
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(txtEmail.getText().toString())) {
                    if (!comprobarEmailValido(txtEmail))
                        tilEmail.setError("Eso no es un email");

                    else
                        tilEmail.setErrorEnabled(false);
                } else
                    tilEmail.setErrorEnabled(false);

                comprobarBtnAceptar();
            }
        });
    }


    public void comprobarTelefono() {
        txtTelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(txtTelefono.getText().toString())) {
                    if (!comprobarTelefonoValido(txtTelefono.getText().toString())) {
                        tilTelefono.setError("No es un número de teléfono válido");
                    } else
                        tilTelefono.setErrorEnabled(false);
                } else
                    tilTelefono.setErrorEnabled(false);

                comprobarBtnAceptar();
            }
        });
    }


    public boolean comprobarTelefonoValido(String telefono) {
        if (telefono.length() != 9)
            return false;
        if (!telefono.startsWith("6") && !telefono.startsWith("7") && !telefono.startsWith("8") && !telefono.startsWith("9"))
            return false;
        return true;
    }

    public boolean comprobarEmailValido(TextInputEditText txtEmail) {
        if (Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString()).matches())
            return true;
        else
            return false;
    }
}
