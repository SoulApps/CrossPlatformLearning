package es.saladillo.alejandro.vistasbasicas3;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAceptar;
    private CheckBox chkCasado;
    private TextView lblPareja;
    private EditText txtPareja;
    private EditText txtEdad;
    private TextView lblEdad;
    private EditText txtEmail;
    private TextView lblEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        chkCasado = (CheckBox) findViewById(R.id.chkCasado);
        lblPareja = (TextView) findViewById(R.id.lblPareja);
        txtPareja = (EditText) findViewById(R.id.txtPareja);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        lblEdad = (TextView) findViewById(R.id.lblEdad);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        lblEmail = (TextView) findViewById(R.id.lblEmail);


        chkCasado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton check, boolean isChecked) {
                if (check.isChecked()) {
                    lblPareja.setVisibility(View.VISIBLE);
                    txtPareja.setVisibility(View.VISIBLE);
                    txtPareja.requestFocus();
                }
                else {
                    lblPareja.setVisibility(View.INVISIBLE);
                    txtPareja.setVisibility(View.INVISIBLE);
                }
            }
        }
        );


        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.aceptado, Toast.LENGTH_LONG).show();
            }
        });




        txtEmail.addTextChangedListener(new TextWatcher() {
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

        txtEdad.addTextChangedListener(new TextWatcher() {
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


        txtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    tintar(lblEmail);
                else
                    desTintar(lblEmail);
            }
        });

        txtEdad.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    tintar(lblEdad);
                else
                    desTintar(lblEdad);
            }
        });

        txtPareja.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    tintar(lblPareja);
                else
                    desTintar(lblPareja);
            }
        });


        comprobarBtnAceptar();
    }


    public void comprobarBtnAceptar() {
        if (txtEdad.getText().toString().equals("") || !txtEmail.getText().toString().matches("[a-z0-9-_\\.]+@[a-z]+\\.(es|com)"))
            btnAceptar.setEnabled(false);
        else
            btnAceptar.setEnabled(true);
    }

    public void tintar(TextView lbl) {
        lbl.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
    }

    public void desTintar(TextView lbl) {
        lbl.setTextColor(ContextCompat.getColor(this, android.R.color.black));
    }
}
