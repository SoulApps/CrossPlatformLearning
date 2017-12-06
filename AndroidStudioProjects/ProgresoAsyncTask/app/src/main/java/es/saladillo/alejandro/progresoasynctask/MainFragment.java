package es.saladillo.alejandro.progresoasynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Alejandro on 17/01/2017.
 */

public class MainFragment extends Fragment {

    private int progreso = 0;

    private View view;
    private TextView lblMensaje;
    private Button btnIniciar;
    private ProgressBar pgHorizontal;
    private ProgressBar pgCirculo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initVistas();
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // El fragmento no será destruido si se cambia la orientación.
        setRetainInstance(true);
    }

    @Override
    public void onStop() {
        super.onStop();
        progreso = pgHorizontal.getProgress();
    }

    private void initVistas() {
        view = getView();
        lblMensaje = (TextView) view.findViewById(R.id.lblMensaje);
        btnIniciar = (Button) view.findViewById(R.id.btnIniciar);
        pgHorizontal = (ProgressBar) view.findViewById(R.id.pgHorizontal);
        pgCirculo = (ProgressBar) view.findViewById(R.id.pgCirculo);

        if (progreso > 0)
            mostrarBarras();

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar();
                btnIniciar.setEnabled(false);
            }
        });
    }

    private void iniciar() {
        new Tarea().execute(10);
    }

    private void mostrarBarras() {
        pgHorizontal.setProgress(progreso);
        lblMensaje.setVisibility(View.VISIBLE);
        lblMensaje.setText(getString(R.string.num_tarea, progreso));
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

    private class Tarea extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            mostrarBarras();
        }


        @Override
        protected Integer doInBackground(Integer... params) {
            int i;

            for (i = 0; i < params[0]; i++) {
                trabajar();
                publishProgress(i);
            }

            return i;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            actualizarBarras(values[0]);

        }

        // Se llama en vez de onPostExecute si ha sido cancelada.
        @Override
        protected void onCancelled() {

        }


        @Override
        protected void onPostExecute(Integer result) {
            finalizar();
        }


        private void trabajar() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
