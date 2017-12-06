package ejercicio13;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Alejandro on 27/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        String xsl = "./src/ejercicio13/PlantillaAgenda.xsl";
        String xml = "./src/ejercicio13/Xml.xml";
        File html = new File("./src/ejercicio13/Html.html");
        //FileOutputStream out;
        Source estilos = new StreamSource(xsl);
        Source datos = new StreamSource(xml);
        Result result;
        Transformer optimusPrime;

        try(FileOutputStream out = new FileOutputStream(html)) {
            //out = new FileOutputStream(html);
            result = new StreamResult(out);
            optimusPrime = TransformerFactory.newInstance().newTransformer(estilos);
            optimusPrime.transform(datos, result);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Kaboom");
        } catch (TransformerConfigurationException e) {
            System.out.println("ASDFasdfasdfdsfaf");
        } catch (TransformerException e) {
            System.out.println("Meh");
        } catch (IOException e) {
            System.out.println("O-oooooooooo AAAAE-A-A-I-A-U- JO-oooooooooooo AAE-O-A-A-U-U-A- E-eee-ee-eee AAAAE-A-E-I-E-A- JO-ooo-oo-oo-oo EEEEO-A-AAA-AAAA");
        }
    }
}
