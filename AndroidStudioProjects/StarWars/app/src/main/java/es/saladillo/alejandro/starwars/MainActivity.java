package es.saladillo.alejandro.starwars;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import es.saladillo.alejandro.starwars.models.Film;
import es.saladillo.alejandro.starwars.models.Peliculas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v4.app.NotificationCompat.DEFAULT_ALL;
import static android.support.v4.app.NotificationCompat.DEFAULT_LIGHTS;
import static android.support.v4.app.NotificationCompat.DEFAULT_SOUND;

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
        adaptador = new Adaptador(this, null);
        lstAlumnos.setAdapter(adaptador);
        obtenerDatos();
    }

    private void obtenerDatos() {
        Call<Peliculas> peticion = mApiClient.getPeliculas();
        peticion.enqueue(new Callback<Peliculas>() {

            @Override
            public void onResponse(Call<Peliculas> call, Response<Peliculas> response) {
                // Si la respuesta es correcta.
                if (response != null && response.isSuccessful()) {
                    adaptador.setPeliculas((ArrayList<Film>) response.body().getResults());
                    notificar();
                }
            }

            @Override
            public void onFailure(Call<Peliculas> call, Throwable t) {

            }
        });
    }

    private void notificar() {
        /*
        Vibrar: <uses-permission android:name="android.permission.VIBRATE" />
         */

        NotificationManager mGestor = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Se crea el constructor de notificaciones.
        NotificationCompat.Builder b = new NotificationCompat.Builder(this);
        // Se configuran los elementos básicos de la notificación.
        b.setSmallIcon(R.mipmap.ic_launcher); // Icono pequeño.
        b.setLargeIcon(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap()); // Icono grande.
        b.setContentTitle("Eh"); // Título (1ª línea).
        b.setContentText("Información descargada"); // Texto (2º línea).
        //b.setContentInfo("3"); // Info adicional (nº total tareas pendientes).
        b.setTicker("Eo");  // Ticker.

        //OnClick.
        b.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.iessaladillo.es")), 0));

        //Sonido y LED.
        b.setDefaults(DEFAULT_SOUND | DEFAULT_LIGHTS);//b.setDefaults(DEFAULT_ALL);

        // Se construye y muestra la notificación, asignándole un código de notificación entero.
        mGestor.notify(0, b.build());
    }
}
