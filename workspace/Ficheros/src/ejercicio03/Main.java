package ejercicio03;

import teclado.Teclado;

import java.io.File;

/**
 * Created by Alejandro on 05/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        File f;
        String s = ".";

        //s = Teclado.next("Introduce la dirección de un archivo");
        f = new File(s);
        if (f.exists())
            System.out.println(mostrarDirectorios(f));
        else
            System.out.println("Esa carpeta no existe");

        //Teclado.close();
    }

    public static String mostrarDirectorios(File f) {
        String resultado = "";
        int i;
        for (i = 0; i < f.listFiles().length; i++) {
            resultado += f.listFiles()[i].getName() + "\n";
            if (f.listFiles()[i].isDirectory())
                resultado += mostrarDirectorios(f.listFiles()[i]);
        }
        return resultado;
    }
}
