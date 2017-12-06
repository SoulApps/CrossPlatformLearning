package ejercicio12;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Alejandro on 27/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        XMLReader xmlReader;
        Sax sax;
        InputSource xml;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            sax = new Sax();
            xmlReader.setContentHandler(sax);
            xml = new InputSource(".\\src\\ejercicio12\\Xml.xml");
            xmlReader.parse(xml);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
