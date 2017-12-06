package ejercicio04;

import teclado.Teclado;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Alejandro on 05/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        String s, extension;
        File f;

        s = Teclado.next("¿En qué carpeta quieres mirar?");
        extension = Teclado.next("¿Qué extension quieres comprobar?", "\\.[a-z]+");
        f = new File(s);

        if (f.isDirectory()) {
            FilenameFilter filtro = (dir, name) -> {
                if (name.endsWith(extension))
                    return true;
                else
                    return false;
            };

            for (i = 0; i < f.list(filtro).length; i++)
                System.out.println(f.list(filtro)[i]);
        }
        else
            System.out.println("Error eso no es una carpeta");
    }
}
