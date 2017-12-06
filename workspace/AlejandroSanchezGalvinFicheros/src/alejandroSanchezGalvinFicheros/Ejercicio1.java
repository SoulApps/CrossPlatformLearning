package alejandroSanchezGalvinFicheros;

import com.thoughtworks.xstream.XStream;

import java.io.*;

/**
 * Created by Alejandro on 17/11/2016.
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        final File xml = new File("./src/alejandroSanchezGalvinFicheros/Xml.xml");
        final ListaEmpleados lista = new ListaEmpleados();

        //Añado los empleados.
        lista.addEmpleado(new Empleado("RJ1", "Rafael Jiménez Pérez", 40, 1789.45f));
        lista.addEmpleado(new Empleado("PM2", "Paco Márquez Romero", 38, 1900.34f));
        lista.addEmpleado(new Empleado("AG3", "Ana González Martín", 45, 1467.23f));
        lista.addEmpleado(new Empleado("TV4", "Tomás Vera Gutiérrez", 39, 1780.36f));

        //Paso a XML.
        binarioXml(xml, lista);
    }

    //Función que pasa a XML.
    public static void binarioXml(File xml, ListaEmpleados lista) {
        XStream xStream;

        try {
            xStream = new XStream();
            xStream.alias("listaempleados", ListaEmpleados.class);
            xStream.alias("empleado", Empleado.class);
            xStream.addImplicitCollection(ListaEmpleados.class, "lista");
            xStream.toXML(lista, new FileOutputStream(xml));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
