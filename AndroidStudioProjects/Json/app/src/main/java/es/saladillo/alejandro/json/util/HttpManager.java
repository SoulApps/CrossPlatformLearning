package es.saladillo.alejandro.json.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

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
        HttpURLConnection conexion = null;

        try {
            // Se obtiene el objeto URL.
            String s = sUrl;
            for (String param : params)
                s += URLEncoder.encode(param, "UTF-8");
            URL url = new URL(s);

            // Se abre la conexión.
            conexion = (HttpURLConnection) url.openConnection();
            // Se establece un tiempo máximo de lectura y de intento de conexión.
            conexion.setReadTimeout(10000); // milisegundos.
            conexion.setConnectTimeout(15000);
            // Se establece el método de conexión.
            conexion.setRequestMethod("GET");

            // Google exige identificar el user agent.
            //conexion.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");


            // Se indica que pretendemos leer del flujo de entrada.
            conexion.setDoInput(true);
            // Se realiza la conexión.
            conexion.connect();
            // Si el código de respuesta es correcto.
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Se crea un lector que lee del flujo de entrada de la conexión.
                BufferedReader lector = new BufferedReader(new
                        InputStreamReader(conexion.getInputStream()));
                // Se lee línea a línea y se agrega a la cadena contenido.
                String linea = lector.readLine();
                while (linea != null) {
                    contenido += linea;
                    linea = lector.readLine();
                }
                lector.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Tanto si se produce una excepción como si no.
            if (conexion != null) {
                // Se cierra la conexión.
                conexion.disconnect();
            }
        }

        // Se retorna el contenido.
        return contenido;
    }

    public static String post(String sUrl, Map<String, String> parametros) {
        String contenido = "", s=sUrl;
        HttpURLConnection conexion = null;

        try {
            // Se obtiene el objeto URL.
            URL url = new URL(sUrl);
            // Se abre la conexión.
            conexion = (HttpURLConnection) url.openConnection();
            // Se establece un tiempo máximo de lectura y de intento de conexión.
            conexion.setReadTimeout(10000); // milisegundos.
            conexion.setConnectTimeout(15000);
            // Se establece el método de conexión.
            conexion.setRequestMethod("POST");
            // Se indica que pretendemos escribir en el flujo de salida.
            conexion.setDoOutput(true);
            // Se indica que pretendemos leer del flujo de entrada.
            conexion.setDoInput(true);
            // Se crea un escritor que escriba en el flujo de salida de la conexión.
            PrintWriter escritor = new PrintWriter (conexion.getOutputStream());
            // Se escriben los parámetros en el flujo de salida.
            if (parametros != null) {
                boolean agregar = false;
                for (Map.Entry<String, String> p : parametros.entrySet()) {
                    if (agregar) {
                        escritor.write("&");
                        s+="&";
                    }
                    else {
                        agregar = true;
                    }
                    escritor.write(URLEncoder.encode(p.getKey() + "=" + p.getValue()));
                    s += p.getKey() + "=" + p.getValue();
                }
            }
            Log.d("bbb", s);
            // Se envían lo datos.
            escritor.flush();
            // Se cierra el flujo de salida.
            escritor.close();
            // Si el código de respuesta es correcto.
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Se crea un lector que lee del flujo de entrada de la conexión.
                BufferedReader lector = new BufferedReader(new
                        InputStreamReader(conexion.getInputStream()));
                // Se lee línea a línea y se agrega a la cadena contenido.
                String linea = lector.readLine();
                while (linea != null) {
                    contenido += linea;
                    linea = lector.readLine();
                }
                lector.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Tanto si se produce una excepción como si no.
            if (conexion != null) {
                // Se cierra la conexión.
                conexion.disconnect();
            }
        }

        // Se retorna el contenido.
        return contenido;
    }
}
