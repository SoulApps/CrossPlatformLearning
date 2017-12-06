package es.saladillo.alejandro.progreso;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private final int NUM_TAREAS = 10;

    private static final int onPreExecute = 0;
    private static final int onProgressUpdate = 1;
    private static final int onPostExecute = 2;

    private Manejador manejador;

    private TextView lblMensaje;
    private Button btnIniciar;
    private ProgressBar pgHorizontal;
    private ProgressBar pgCirculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        pgHorizontal = (ProgressBar) findViewById(R.id.pgHorizontal);
        pgCirculo = (ProgressBar) findViewById(R.id.pgCirculo);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar();
            }
        });
    }

    private void iniciar() {
        btnIniciar.setEnabled(false);

        manejador = new Manejador(this);

        Tarea tarea = new Tarea();
        Thread hiloSecundario = new Thread(tarea);
        hiloSecundario.start();
    }

    private void mostrarBarras() {
        lblMensaje.setVisibility(View.VISIBLE);
        pgHorizontal.setVisibility(View.VISIBLE);
        pgCirculo.setVisibility(View.VISIBLE);
    }

    private void actualizarBarras(int progreso) {
        pgHorizontal.setProgress(progreso);
        lblMensaje.setText(getString(R.string.num_tarea, progreso));
    }

    private void finalizar() {
        pgHorizontal.setVisibility(View.INVISIBLE);
        pgHorizontal.setProgress(0);
        pgCirculo.setVisibility(View.INVISIBLE);
        pgCirculo.setProgress(0);

        lblMensaje.setText(R.string.terminado);
        btnIniciar.setEnabled(true);
    }

    private class Tarea implements Runnable {

        @Override
        public void run() {
            Message mensajeInicio = new Message();
            mensajeInicio.what = onPreExecute;
            manejador.sendMessage(mensajeInicio);

            for (int i = 0; i < NUM_TAREAS; i++) {
                trabajar();
                Message mensajeProgreso = new Message();
                mensajeProgreso.what = onProgressUpdate;
                mensajeProgreso.arg1 = i + 1;
                manejador.sendMessage(mensajeProgreso);
            }

            Message mensajeFinal = new Message();
            mensajeFinal.what = onPostExecute;
            mensajeFinal.arg1 = NUM_TAREAS;
            manejador.sendMessage(mensajeFinal);
        }

        private void trabajar() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static class Manejador extends Handler {

        private final WeakReference<MainActivity> mainActivityWeakReference;

        public Manejador(MainActivity activity) {
            mainActivityWeakReference = new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mainActivityWeakReference.get();

            if (activity != null) {
                switch (msg.what) {
                    case onPreExecute:
                        activity.mostrarBarras();
                        break;

                    case onProgressUpdate:
                        int progreso = msg.arg1;
                        activity.actualizarBarras(progreso);
                        break;

                    case onPostExecute:
                        activity.finalizar();
                        break;
                }
            }
        }

    }
}
