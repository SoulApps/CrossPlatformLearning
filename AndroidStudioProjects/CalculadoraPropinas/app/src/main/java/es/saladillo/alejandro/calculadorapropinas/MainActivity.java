package es.saladillo.alejandro.calculadorapropinas;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private final float DEFAULT_CUENTA = 0f;
    private final int DEFAULT_PORCENTAJE_PROPINA = 5;
    private final int DEFAULT_COMENSALES = 1;

    private TextView lblCuenta;
    private TextView lblPorcentajePropina;
    private TextView lblComensales;
    private EditText txtCuenta;
    private EditText txtPorcentajePropina;
    private EditText txtComensales;
    private EditText txtPropina;
    private EditText txtTotal;
    private EditText txtPorComensal;
    private Button btnRedondear1;
    private Button btnRedondear2;
    private Button btnLimpiar1;
    private Button btnLimpiar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        lblCuenta = (TextView) findViewById(R.id.lblCuenta);
        lblPorcentajePropina = (TextView) findViewById(R.id.lblPorcentajePropina);
        lblComensales = (TextView) findViewById(R.id.lblComensales);
        txtCuenta = (EditText) findViewById(R.id.txtCuenta);
        txtPorcentajePropina = (EditText) findViewById(R.id.txtPorcentajePropina);
        txtPropina = (EditText) findViewById(R.id.txtPropina);
        txtTotal = (EditText) findViewById(R.id.txtTotal);
        txtPorComensal = (EditText) findViewById(R.id.txtPorComensal);
        txtComensales = (EditText) findViewById(R.id.txtComensales);
        btnRedondear1 = (Button) findViewById(R.id.btnRedondear1);
        btnRedondear2 = (Button) findViewById(R.id.btnRedondear2);
        btnLimpiar1 = (Button) findViewById(R.id.btnLimpiar1);
        btnLimpiar2 = (Button) findViewById(R.id.btnLimpiar2);

        //Poner valores por defecto
        txtCuenta.setText(formatoDecimal(String.format("%.2f", DEFAULT_CUENTA)));
        txtPorcentajePropina.setText(String.format("%d", DEFAULT_PORCENTAJE_PROPINA));
        txtComensales.setText(String.format("%d", DEFAULT_COMENSALES));
        calcularTotal();

        //Focus
        txtCuenta.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    tintar(lblCuenta);
                else {
                    desTintar(lblCuenta);
                    String st;
                    if (TextUtils.isEmpty(txtCuenta.getText().toString()))
                        txtCuenta.setText(formatoDecimal(String.format("%.2f", DEFAULT_CUENTA)));
                    else {
                        st = String.format("%.2f", Float.parseFloat(formatoDecimal(txtCuenta.getText().toString())));
                        if (!st.equals(txtCuenta.getText().toString()))
                            txtCuenta.setText(st);
                    }
                    calcularTotal();
                }
            }
        });

        txtPorcentajePropina.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    tintar(lblPorcentajePropina);
                else {
                    desTintar(lblPorcentajePropina);
                }
            }
        });

        txtComensales.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    tintar(lblComensales);
                else
                    desTintar(lblComensales);
            }
        });

        txtCuenta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calcularTotal();
            }
        });

        txtPorcentajePropina.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calcularTotal();
            }
        });

        txtComensales.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(txtComensales.getText().toString()) || Integer.parseInt(txtComensales.getText().toString()) == 0)
                    txtComensales.setText(String.format("%d", DEFAULT_COMENSALES));
                calcularComensales();
            }
        });


        btnLimpiar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarTotal();
            }
        });

        btnLimpiar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarComensales();
            }
        });

        btnRedondear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redondearTotal();
            }
        });

        btnRedondear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redondearComensales();
            }
        });
    }


    //Métodos de utilidad
    private void redondearTotal() {
        float total = Float.parseFloat(formatoDecimal(txtTotal.getText().toString()));
        int i = (int) total;

        if (total > i)
            txtTotal.setText(formatoDecimal(String.format("%.2f", (float) i + 1)));

        calcularComensales();
    }

    private void redondearComensales() {
        float porComensal = Float.parseFloat(formatoDecimal(txtPorComensal.getText().toString()));
        int i = (int) porComensal;

        if (porComensal > i)
            txtPorComensal.setText(formatoDecimal(String.format("%.2f", (float) i + 1)));
    }

    private void limpiarTotal() {
        txtCuenta.setText(formatoDecimal(String.format("%.2f", DEFAULT_CUENTA)));
        txtPorcentajePropina.setText(String.format("%d", DEFAULT_PORCENTAJE_PROPINA));
    }

    private void limpiarComensales() {
        txtComensales.setText(String.format("%d", DEFAULT_COMENSALES));
    }


    private void tintar(TextView lbl) {
        lbl.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
    }

    private void desTintar(TextView lbl) {
        lbl.setTextColor(ContextCompat.getColor(this, R.color.defecto));
    }

    private void calcularTotal() {
        float cuenta, propina, total;
        int porcentajePropina;
        porcentajePropina = Integer.parseInt(txtPorcentajePropina.getText().toString());
        cuenta = Float.parseFloat(formatoDecimal(txtCuenta.getText().toString()));
        propina = cuenta * porcentajePropina / 100;
        txtPropina.setText(formatoDecimal(String.format("%.2f", propina)));
        total = cuenta + propina;
        txtTotal.setText(formatoDecimal(String.format("%.2f", total)));
        calcularComensales();
    }

    private void calcularComensales() {
        float porComensal, total;
        int comensales;
        comensales = Integer.parseInt(txtComensales.getText().toString());
        total = Float.parseFloat(formatoDecimal(txtTotal.getText().toString()));
        porComensal = total / comensales;
        txtPorComensal.setText(formatoDecimal(String.format("%.2f", porComensal)));
    }

    private String formatoDecimal(String s) {
        return s.replace(',', '.');
    }
}
