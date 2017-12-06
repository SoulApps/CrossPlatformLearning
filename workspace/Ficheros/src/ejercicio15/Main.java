package ejercicio15;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Alejandro on 10/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        File origen = new File("./src/ejercicio15/Json.json");
        File destino = new File("./src/ejercicio15/Destino.txt");
        String s = formatearJson(origen);
        System.out.println(s);
        try (FileWriter writer = new FileWriter(destino)) {
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String formatearJson(File f) {
        final String ORNAMENT = "*******************************************************************************\n";
        final String INICIO_AGENDA = String.format("%s\t\t\t\t\t\t\tAGENDA TELEFONICA\n", ORNAMENT);
        final String FIN_AGENDA = String.format("%1$s\t\t\t\t\t\t\tFIN DE LA AGENDA TELEFONICA\n%1$s", ORNAMENT);
        String resultado = null;
        ArrayList<Agenda> lista;
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(f)) {
            lista = gson.fromJson(reader, new TypeToken<ArrayList<Agenda>>() {
            }.getType());

            resultado = INICIO_AGENDA;

            for (int i = 0; i < lista.size(); i++)
                resultado += String.format("%s%s%n", ORNAMENT, lista.get(i));

            resultado += FIN_AGENDA;

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}
