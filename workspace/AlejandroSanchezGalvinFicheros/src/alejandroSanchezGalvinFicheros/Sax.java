package alejandroSanchezGalvinFicheros;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;

/**
 * Created by Alejandro on 27/10/2016.
 */
public class Sax extends DefaultHandler {

    private File binario;
    private ObjectOutput out;
    private String s;

    //Variables de utilidad para crear un objeto Empleado.
    private String codigo, nombre;
    private int edad;
    private float salario;

    public Sax() {
        super();
        binario = new File("./src/alejandroSanchezGalvinFicheros/Binario.dat");
    }

    @Override
    public void startDocument() throws SAXException {
        try {
            out = new ObjectOutputStream(new FileOutputStream(binario));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endDocument() throws SAXException {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //Voy comprobando el elemento que ha leído y le asigno la cadena que modifico en characters(...), haciendo un parse si es necesario.

        if (qName.equals("codigo"))
            codigo = s;
        else if (qName.equals("nombre"))
            nombre = s;
        else if (qName.equals("edad"))
            edad = Integer.parseInt(s);
        else if (qName.equals("salario")) {
            salario = Float.parseFloat(s);

            //Cuando llego a salario, que es el último atributo del objeto, lo escribo en el fichero binario.
            try {
                out.writeObject(new Empleado(codigo, nombre, edad, salario));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void characters(char[] ch, int inicio, int longitud) {
        s = new String(ch, inicio, longitud);
    }
}
