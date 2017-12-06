package es.saladillo.alejandro.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        final SharedPreferences preferencias = getSharedPreferences("pref_apl", Context.MODE_PRIVATE);

        final TextView lblPuntosYo = (TextView) findViewById(R.id.lblPuntosYo);
        final TextView lblPuntosOtro = (TextView) findViewById(R.id.lblPuntosOtro);

        Button btnYo = (Button) findViewById(R.id.btnYo);
        Button btnOtro = (Button) findViewById(R.id.btnOtro);

        lblPuntosYo.setText(String.valueOf(preferencias.getInt("yo", 0)));
        lblPuntosOtro.setText(String.valueOf(preferencias.getInt("otro", 0)));


        btnYo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = Integer.parseInt(lblPuntosYo.getText().toString()) + 1;
                lblPuntosYo.setText(String.valueOf(i));
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putInt("yo", i);
                editor.apply();
            }
        });

        btnOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = Integer.parseInt(lblPuntosOtro.getText().toString()) + 1;
                lblPuntosOtro.setText(String.valueOf(i));
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putInt("otro", i);
                editor.apply();
            }
        });
    }
}
