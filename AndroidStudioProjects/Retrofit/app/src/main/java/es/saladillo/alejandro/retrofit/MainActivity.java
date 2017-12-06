package es.saladillo.alejandro.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import es.saladillo.alejandro.retrofit.models.Alumno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView lstAlumnos;
    private Adaptador adaptador;
    private Api.ApiInterface mApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        mApiClient = Api.getApiInterface(this);

        lstAlumnos = (ListView) findViewById(R.id.lstAlumnos);
        adaptador = new Adaptador(this, new ArrayList<Alumno>());
        lstAlumnos.setAdapter(adaptador);
        obtenerDatos();
    }

    private void obtenerDatos() {
        Call<ArrayList<Alumno>> peticion = mApiClient.getAlumnos();
        peticion.enqueue(new Callback<ArrayList<Alumno>>() {

            @Override
            public void onResponse(Call<ArrayList<Alumno>> call, Response<ArrayList<Alumno>> response) {
                // Si la respuesta es correcta.
                if (response != null && response.isSuccessful()) {
                    adaptador.setAlumnos(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Alumno>> call, Throwable t) {

            }
        });
    }
}
