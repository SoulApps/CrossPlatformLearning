package ejercicio11;

import com.thoughtworks.xstream.XStream;
import ejercicio08.Agenda;
import ejercicio10.ListaPersonas;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alejandro on 27/10/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File origen = new File(".\\src\\ejercicio10\\Xml.xml");
        File destino = new File(".\\src\\ejercicio11\\Destino.dat");
        File original = new File(".\\src\\ejercicio08\\FicheroSin.dat");
        xmlBinario(origen, destino);
        System.out.println(compararBinarios(destino, original)?"Son iguales":"No son iguales");
    }

    public static void xmlBinario(File origen, File destino) {
        ArrayList<Agenda> personas;
        Iterator it;
        ListaPersonas lista;
        Agenda a;
        DataOutputStream out;
        XStream xStream;

        try {
            out = new DataOutputStream(new FileOutputStream(destino));
            xStream = new XStream();
            xStream.alias("agenda", ListaPersonas.class);
            xStream.alias("contacto", Agenda.class);
            xStream.addImplicitCollection(ListaPersonas.class, "lista");
            lista = (ListaPersonas) xStream.fromXML(new FileInputStream(origen));

            personas = lista.getAgenda();
            it = personas.iterator();

            while (it.hasNext()) {
                a = (Agenda) it.next();
                out.writeUTF(a.getNombre());
                out.writeUTF(a.getTelefono());
                out.writeUTF(a.getDireccion());
                out.writeInt(a.getCodigoPostal());
                out.writeUTF(a.getFechaNacimiento());
                out.writeBoolean(a.isLeDebo());
                out.writeFloat(a.getDeuda());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean compararBinarios(File f1, File f2) {
        boolean igual = true;
        int i1, i2;
        FileInputStream in1, in2;

        try {
            in1 = new FileInputStream(f1);
            in2 = new FileInputStream(f2);

            while ((i1 = in1.read()) != -1 && (i2 = in2.read()) != -1)
                if (i1 != i2)
                    igual = false;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return igual;
    }
}
