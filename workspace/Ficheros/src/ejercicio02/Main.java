package ejercicio02;

import java.io.File;
import java.io.IOException;

/**
 * Created by Alejandro on 05/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        File carpeta1, carpeta2, archivo1, archivo2, archivo3, archivo4;

        carpeta1 = new File("Carpeta 1");
        carpeta2 = new File(carpeta1, "Carpeta 2");
        archivo1 = new File(carpeta1, "Archivo 1");
        archivo2 = new File(carpeta1, "Archivo 2");
        archivo3 = new File(carpeta1, "Archivo 3");
        archivo4 = new File(carpeta2, "Archivo 4");

        System.out.println(carpeta1.mkdir()?"La carpeta se ha creado correctamente":"Error al crear la carpeta");
        System.out.println(carpeta2.mkdir()?"La carpeta se ha creado correctamente":"Error al crear la carpeta");
        try {
            System.out.println(archivo1.createNewFile()?"Archivo creado correctamente":"Error al crear correctamente");
            System.out.println(archivo2.createNewFile()?"Archivo creado correctamente":"Error al crear correctamente");
            System.out.println(archivo3.createNewFile()?"Archivo creado correctamente":"Error al crear correctamente");
            System.out.println(archivo4.createNewFile()?"Archivo creado correctamente":"Error al crear correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(archivo2.delete()?"Archivo borrado":"Error al borrar el archivo");
        System.out.println(archivo3.renameTo(new File(carpeta1, "Archivo 2"))?"Archivo renombrado":"Error al renombrar el archivo");

        System.out.printf("%n%s%n%s%n", carpeta1.getAbsolutePath(), carpeta2.getAbsolutePath());
        for (i = 0; i < carpeta1.listFiles().length; i++) {
            System.out.println(carpeta1.listFiles()[i].getAbsolutePath());
            if (i <= carpeta2.listFiles().length - 1)
                System.out.println(carpeta2.listFiles()[i].getAbsolutePath());
        }

    }
}
