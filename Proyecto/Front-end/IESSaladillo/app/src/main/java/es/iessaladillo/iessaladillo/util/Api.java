package es.iessaladillo.iessaladillo.util;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import es.iessaladillo.iessaladillo.models.Aula;
import es.iessaladillo.iessaladillo.models.Hardware;
import es.iessaladillo.iessaladillo.models.Incidencia;
import es.iessaladillo.iessaladillo.models.Material;
import es.iessaladillo.iessaladillo.models.Profesor;
import es.iessaladillo.iessaladillo.models.TramoHorarioReserva;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Alejandro on 01/03/2017.
 */

public class Api {

    private static final String BASE_URL = "http://asgproyecto.esy.es/";

    // Interfaz de trabajo de Retrofit contra la API.
    public interface ApiInterface {
        //Profesor
        @FormUrlEncoded
        @POST("profesor")
        Call<ArrayList<Profesor>> login(@Field("email") String email);
        @FormUrlEncoded
        @POST("profesor/{codProf}")
        Call<Void> logout(@Path("codProf") int codProf, @Field("token") String token);

        //Aula
        @GET("aula")
        Call<ArrayList<Aula>> verAulas(@Query("codProf") int codProf,  @Query("token") String token);

        //TramoHorarioReserva
        @GET("reserva/{planta}/{codAula}/{fecha}")
        Call<ArrayList<TramoHorarioReserva>> verReservas(@Path("planta") byte planta, @Path("codAula") short codAula, @Path("fecha") String fecha, @Query("codProf") int codProf,  @Query("token") String token);
        @FormUrlEncoded
        @POST("reserva")
        Call<ArrayList<TramoHorarioReserva>> reservar(@Query("codProf") int codProf,  @Query("token") String token, @Field("fecha") String fecha, @Field("planta") byte planta, @Field("codAula") short aula, @Field("codTramo") byte codTramo);
        @DELETE("reserva/{planta}/{codAula}/{fecha}/{codTramo}")
        Call<Void> cancelarReserva(@Path("planta") byte planta, @Path("codAula") short aula, @Path("fecha") String fecha, @Path("codTramo") byte codTramo, @Query("codProf") int codProf,  @Query("token") String token);

        //Material
        @GET("material/{planta}/{codAula}")
        Call<ArrayList<Material>> verMaterialesPorAula(@Path("planta") byte planta, @Path("codAula") short codAula, @Query("codProf") int codProf,  @Query("token") String token);
        @GET("material/{codBarras}")
        Call<ArrayList<Material>> verMaterialesPorCodBarras(@Path("codBarras") String codBarras, @Query("codProf") int codProf,  @Query("token") String token);
        @POST("material")
        Call<String> anhadirMaterial(@Query("codProf") int codProf,  @Query("token") String token, @Body Material material);
        @DELETE("material/{codMaterial}")
        Call<Void> eliminarMaterial(@Path("codMaterial") int codMaterial, @Query("codProf") int codProf,  @Query("token") String token);

        //Incidencia
        @GET("incidencia")
        Call<ArrayList<Incidencia>> verIncidencias(@Query("codProf") int codProf,  @Query("token") String token, @Query("solucionado") boolean solucionado, @Query("antiguos") boolean antiguos);
        @POST("incidencia")
        Call<Void> reportarIncidencia(@Query("codProf") int codProf,  @Query("token") String token, @Body Incidencia incidencia);
        @PUT("incidencia/{codIncidencia}")
        Call<Void> actualizarIncidencia(@Path("codIncidencia") int codIncidencia, @Body Incidencia incidencia, @Query("codProf") int codProf,  @Query("token") String token);

        //Inventario Hardware
        @GET("hardware")
        Call<ArrayList<Hardware>> verInventario(@Query("codProf") int codProf,  @Query("token") String token);
        @POST("hardware")
        Call<Void> crearHardware(@Query("codProf") int codProf,  @Query("token") String token, @Body Hardware hardware);
        @PUT("hardware/{codBarras}")
        Call<Void> actualizarHardware(@Path("codBarras") String codBarras, @Body Hardware hardware, @Query("codProf") int codProf,  @Query("token") String token);
    }

    // Constructor privado para que NO pueda instanciarse.
    private Api() {
    }

    private static ApiInterface mApiInterface;


    // Retorna la interfaz de acceso a la API.
    public static ApiInterface getApiInterface() {
        if (mApiInterface == null)
            createInstance();
        return mApiInterface;
    }

    // Crea la instancia del cliente.
    private static void createInstance() {
        if (mApiInterface == null) {
            synchronized (Api.class) {
                if (mApiInterface == null) {
                    mApiInterface = buildApiClient();
                }
            }
        }
    }

    // Construye y retorna el cliente de acceso a la API a través de Retrofit.
    private static ApiInterface buildApiClient() {
        // Se construye el objeto Retrofit y a partir de él se retorna el
        // servicio de acceso a la API.
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd HH:mm").create())) //Custom GSON.
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
