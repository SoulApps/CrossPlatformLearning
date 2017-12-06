package com.example.alejandro.pr_prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblSauludo;
    private CheckBox chkInsultar;
    private EditText txtNombre;
    private TextView txtMensaje;
    private Button btnSaludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        lblSauludo = (TextView) findViewById(R.id.lblSaludo);
        chkInsultar = (CheckBox) findViewById(R.id.chkInsultar);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtMensaje = (TextView) findViewById(R.id.txtMensaje);
        btnSaludar = (Button) findViewById(R.id.btnSaludar);

        btnSaludar.setOnClickListener(v -> btnSaludarOnClick(v));
        //btnSaludar.setOnClickListener(this::btnSaludarOnClick);
    }

    public void btnSaludarOnClick(View view) {
        if (!TextUtils.isEmpty(txtNombre.getText())) {
            if (chkInsultar.isChecked())
                txtMensaje.setText(getString(R.string.me_acuerdo, txtNombre.getText().toString()));
            else
                txtMensaje.setText(getString(R.string.hola, txtNombre.getText().toString()));
        }
    }



    /*public void btnInsultarOnClick(View view) {
        //Cambio el texto del TextView
        lblSauludo.setText(R.string.me_acuerdo);
    }

    public void btnPiropearOnClick(View view) {
        //Cambio el texto del TextView
        lblSauludo.setText(R.string.guapo);
    }*/
}
