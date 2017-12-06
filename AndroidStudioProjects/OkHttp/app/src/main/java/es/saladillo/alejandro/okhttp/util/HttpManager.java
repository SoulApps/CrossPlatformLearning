package es.saladillo.alejandro.okhttp.util;

import android.util.Log;

import com.facebook.stetho.inspector.database.ContentProviderSchema;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Alejandro on 01/02/2017.
 */

public class HttpManager {


    //Permisos
    /*
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    <application
        ...
     */

    public static String get(String sUrl, String... params) {
        String contenido = "";
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build();
        Call mOkHttpCall;

        try {
            // Se obtiene el objeto URL.
            String s = sUrl;
            for (String param : params)
                s += URLEncoder.encode(param, "UTF-8");
            URL url = new URL(s);

            Request request = new Request.Builder().url(url)
                    .header("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5" + ".1)")
                    .build();

            mOkHttpCall = mOkHttpClient.newCall(request);
            Response response = mOkHttpCall.execute();

            if (response.isSuccessful())
                contenido = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Se retorna el contenido.
        return contenido;
    }

    public static String post(String sUrl, Map<String, String> parametros) {
        final String KEY_NOMBRE = "nombre";
        final String KEY_FECHA = "fecha";

        String resultado = "";
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build();
        Call mOkHttpCall;

        try {
            // Se obtiene el objeto URL.
            URL url = new URL(sUrl);

            FormBody.Builder builder = new FormBody.Builder();

            // Se abre la conexión.
            // Se escriben los parámetros en el flujo de salida.
            if (parametros != null) {
                boolean agregar = false;
                for (Map.Entry<String, String> p : parametros.entrySet()) {
                    builder.addEncoded(p.getKey(), p.getValue());
                }
            }

            RequestBody formBody = builder.build();

            Request request = new Request.Builder().url(url).post(formBody).build();
            mOkHttpCall = mOkHttpClient.newCall(request);
            Response response = mOkHttpCall.execute();
            if (response.isSuccessful())
                resultado = response.body().string().trim();


        } catch (IOException e) {
            e.printStackTrace();
        }

        // Se retorna el contenido.
        return resultado;
    }
}
