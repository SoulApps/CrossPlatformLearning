package es.saladillo.alejandro.incrementar3;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import icepick.Icepick;
import icepick.State;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private TextView textView;
    private Button button;

    @State
    int numero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero = 0;
        Icepick.restoreInstanceState(this, savedInstanceState);
        initVistas();
    }

    private void initVistas() {
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        textView.setText(String.valueOf(numero));
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(++numero));
                mostrarSnackbar("Se ha incrementado");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    private void mostrarSnackbar(String mensaje) {
        Snackbar.make(relativeLayout, mensaje, Snackbar.LENGTH_LONG)
                .setAction("Decrementar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textView.setText(String.valueOf(--numero));
                    }
                })
                .show();
    }
}
