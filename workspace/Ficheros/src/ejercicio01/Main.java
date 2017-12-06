package ejercicio01;

import teclado.Teclado;

import java.io.File;

/**
 * Created by Alejandro on 05/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        File f;
        String s;

        s = Teclado.next("Introduce una ruta de archivo o carpeta");
        f = new File(s);

        if (f.exists()) {
            System.out.printf("¿Es ejecutable?: %s%n", f.canExecute() ? "Sí" : "No");
            System.out.printf("¿Está oculto?: %s%n", f.isHidden() ? "Sí" : "No");
            System.out.printf("Ruta relativa: %s%n", f.getPath());
            System.out.printf("Ruta absoluta: %s%n", f.getAbsolutePath());
            System.out.printf("Tamaño: %d%n", f.length());
        }
        else
            System.out.println("El archivo no existe");

        Teclado.close();
    }
}
