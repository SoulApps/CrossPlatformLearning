package alejandroSanchezGalvinFicheros;

import java.io.*;

/**
 * Created by Alejandro on 17/11/2016.
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        File binario = new File("./src/alejandroSanchezGalvinFicheros/Binario.dat");
        MiObjectOutputStream out;

        try {
            out = new MiObjectOutputStream(new FileOutputStream(binario, true));

            //Escribo los nuevos empleados.
            out.writeObject(new Empleado("AD5", "Angela Domínguez Macías", 52, 2138.89f));
            out.writeObject(new Empleado("EC6", "Esteban Cabrera Rico", 34, 1333.90f));
            out.close();

            //Leo el fichero usando la funión de la clase Ejercicio2.
            Ejercicio2.leerBinarioSerializable(binario);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

