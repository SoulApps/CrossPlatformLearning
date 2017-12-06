package ejercicio10;

import com.thoughtworks.xstream.XStream;
import ejercicio08.Agenda;

import java.io.*;

/**
 * Created by Alejandro on 24/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        File origen = new File(".\\src\\ejercicio08\\FicheroCon.dat");
        File destino = new File(".\\src\\ejercicio10\\Xml.xml");
        binarioXml(origen, destino);
    }

    public static void binarioXml(File origen, File destino) {
        ListaPersonas lista = new ListaPersonas();
        Agenda a;
        ObjectInputStream in = null;
        XStream xStream;

        try {
            in = new ObjectInputStream(new FileInputStream(origen));
            while (true) {
                a = (Agenda) in.readObject();
                System.out.println(a);
                lista.addPersona(a);
            }
        } catch (EOFException e) {
            try {
                in.close();
            } catch (IOException e1) {

            }
        } catch (ClassNotFoundException e) {

        } catch (IOException e) {

        }

        try {
            xStream = new XStream();
            xStream.alias("agenda", ListaPersonas.class);
            xStream.alias("contacto", Agenda.class);
            xStream.addImplicitCollection(ListaPersonas.class, "lista");
            xStream.toXML(lista, new FileOutputStream(destino));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
