package ejercicio07;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Alejandro on 06/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        String clave = "Ana";
        File origen = new File(".\\src\\ejercicio07\\Origen.dat");
        File destinoEncriptado = new File(".\\src\\ejercicio07\\DestinoEncriptado.txt");
        File destinoDesencriptado = new File(".\\src\\ejercicio07\\DestinoDesencriptado.txt");


        try {
            encriptar(clave, origen, destinoEncriptado, true);
            encriptar(clave, destinoEncriptado, destinoDesencriptado, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void encriptar(String clave, File origen, File destino, boolean encriptar) throws IOException {
        int i, j = 0;
        FileReader leer = new FileReader(origen);
        FileWriter escribir = new FileWriter(destino);

        while ((i = leer.read()) != -1) {
            if (j == clave.length())
                j = 0;

            if (encriptar)
                escribir.append((char) (i + clave.charAt(j)));
            else
                escribir.append((char) (i - clave.charAt(j)));

            j++;
        }

        leer.close();
        escribir.close();
    }
}
