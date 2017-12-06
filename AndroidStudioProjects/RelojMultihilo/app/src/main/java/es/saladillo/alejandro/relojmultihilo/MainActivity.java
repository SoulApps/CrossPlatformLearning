package es.saladillo.alejandro.relojmultihilo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView lblTiempo;
    private Button btnIniciarParar;

    private Thread hiloSecundario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        lblTiempo = (TextView) findViewById(R.id.lblTiempo);
        btnIniciarParar = (Button) findViewById(R.id.btnIniciarParar);

        btnIniciarParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnIniciarParar.getText().toString().equals(getString(R.string.iniciar)))
                    iniciar();
                else
                    parar();
            }
        });
    }

    private void iniciar() {
        hiloSecundario = new Thread(new Reloj());
        hiloSecundario.start();
        btnIniciarParar.setText(R.string.parar);
    }

    private void parar() {
        hiloSecundario.interrupt();
        btnIniciarParar.setText(R.string.iniciar);
    }

    private class Reloj implements Runnable {

        private final SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

        @Override
        public void run() {
            while (true) {
                final String CADENA = formato.format(new Date());

                lblTiempo.post(new Runnable() {
                    @Override
                    public void run() {
                        lblTiempo.setText(CADENA);
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return; //Para finalizar el hilo
                }
            }
        }
    }
}
