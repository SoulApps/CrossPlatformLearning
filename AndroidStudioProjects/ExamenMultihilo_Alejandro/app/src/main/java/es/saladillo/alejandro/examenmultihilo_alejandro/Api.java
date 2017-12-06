package es.saladillo.alejandro.examenmultihilo_alejandro;

import android.content.Context;

import com.readystatesoftware.chuck.ChuckInterceptor;

import es.saladillo.alejandro.examenmultihilo_alejandro.models.ResultadoApi;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alejandro on 01/03/2017.
 */

public class Api {

    public static final String BASE_URL = "http://api.fixer.io/";

    // Interfaz de trabajo de Retrofit contra la API.
    public interface ApiInterface {
        @GET("latest")
        Call<ResultadoApi> getMoneda(@Query("base")String base, @Query("symbols")String symbols);
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
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ChuckInterceptor(context))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
