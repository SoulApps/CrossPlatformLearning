package ejercicio14;

import com.google.gson.*;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by Alejandro on 09/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        File destino  = new File("./src/ejercicio14/Json.json");
        File xml = new File("./src/ejercicio14/Xml.xml");

        xmlToJson(destino, xml);
    }

    public static void xmlToJson(File destino, File xml) {
        final Gson gson = new Gson();
        ListaPersonas listaPersonas;
        String stringJson;
        XStream xStream = new XStream();

        xStream.alias("agenda", ListaPersonas.class);
        xStream.alias("contacto", Agenda.class);
        xStream.addImplicitCollection(ListaPersonas.class, "lista");

        listaPersonas = (ListaPersonas) xStream.fromXML(xml);

        stringJson = gson.toJson(listaPersonas.getAgenda());

        System.out.println(stringJson);

        try (FileWriter writer = new FileWriter(destino)) {
            writer.write(stringJson);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
