package ejercicio12;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;

/**
 * Created by Alejandro on 27/10/2016.
 */
public class Sax extends DefaultHandler {

    private File destino;
    private FileWriter out;

    public Sax() {
        super();
        destino = new File(".\\src\\ejercicio12\\Destino.txt");
    }

    @Override
    public void startDocument() throws SAXException {
        try {
            out = new FileWriter(destino);
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
        if (attributes.getValue(0) != null) {
            try {
                out.write(String.format("%s ", attributes.getValue(0)));
                System.out.printf("%s ", attributes.getValue(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("deuda")) {
            try {
                out.write("\n");
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void characters(char[] ch, int inicio, int longitud) {
        String car = new String(ch, inicio, longitud);
        car = car.replaceAll("[\t\n]", "");

        car = car.trim();

        if (!car.equals(""))
            car += " ";

        System.out.print(car);

        try {
            out.write(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
