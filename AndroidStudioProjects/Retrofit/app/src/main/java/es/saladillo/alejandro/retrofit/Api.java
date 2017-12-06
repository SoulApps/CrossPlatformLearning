package es.saladillo.alejandro.retrofit;

import android.content.Context;

import java.util.ArrayList;

import es.saladillo.alejandro.retrofit.models.Alumno;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Alejandro on 08/02/2017.
 */

public class Api {
    //https://dl.dropboxusercontent.com/u/67422/Android/json/datos.json

    // Constantes.
    public static final String BASE_URL = "https://dl.dropboxusercontent.com/";

    // Interfaz de trabajo de Retrofit contra la API.
    public interface ApiInterface {
        @GET("u/67422/Android/json/datos.json")
        Call<ArrayList<Alumno>> getAlumnos();

    }

    // Constructor privado para que NO pueda instanciarse.
    private Api() {
    }

    private static ApiInterface mApiInterface;


    // Retorna la interfaz de acceso a la API.
    public static ApiInterface getApiInterface(Context context) {
        if (mApiInterface == null)
            createInstance(context);
        return mApiInterface;
    }

    // Crea la instancia del cliente.
    private static void createInstance(Context context) {
        if (mApiInterface == null) {
            synchronized (Api.class) {
                if (mApiInterface == null) {
                    mApiInterface = buildApiClient(context);
                }
            }
        }
    }

    // Construye y retorna el cliente de acceso a la API a través de Retrofit.
    private static ApiInterface buildApiClient(Context context) {
        // Se construye el objeto Retrofit y a partir de él se retorna el
        // servicio de acceso a la API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }

}
