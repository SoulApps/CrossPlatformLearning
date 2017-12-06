package alejandroSanchezGalvinFicheros;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;

/**
 * Created by Alejandro on 17/11/2016.
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        File binario = new File("./src/alejandroSanchezGalvinFicheros/Binario.dat");
        XMLReader xmlReader;
        Sax sax;
        InputSource xml;

        //XML a binario.
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            sax = new Sax();
            xmlReader.setContentHandler(sax);
            xml = new InputSource("./src/alejandroSanchezGalvinFicheros/Xml.xml");
            xmlReader.parse(xml);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        //Leo el binario.
        try {
            leerBinarioSerializable(binario);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Método que lee el binario.
    public static void leerBinarioSerializable(File f) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));

        try {
            while (true)
                System.out.println(in.readObject());
        } catch (EOFException e) {
            in.close();
        }
    }
}
