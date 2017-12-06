package ejercicio05;

import java.io.*;

/**
 * Created by Alejandro on 06/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        boolean b = true;
        String linea;
        File origen, destino, archivoDestino;
        BufferedReader leerOrigenLinea;
        BufferedWriter escribirDestinoLinea = null;

        try {
            origen = new File(".\\src/ejercicio05\\Origen.dat");
            destino = new File(".\\src\\ejercicio05\\Carpeta");
            archivoDestino = new File(destino, ".\\Destino.txt");
            leerOrigenLinea = new BufferedReader(new FileReader(origen));


            if (origen.exists()) {
                if (destino.isDirectory() && destino.exists()) {
                    archivoDestino.createNewFile();
                    escribirDestinoLinea = new BufferedWriter(new FileWriter(archivoDestino));
                    while ((linea = leerOrigenLinea.readLine()) != null)
                        escribirDestinoLinea.write(linea + "\n");
                } else if (destino.isFile() && destino.exists()) {
                    if (b) {
                        escribirDestinoLinea = new BufferedWriter(new FileWriter(destino));
                        while ((linea = leerOrigenLinea.readLine()) != null)
                            escribirDestinoLinea.write(linea + "\n");
                    } else throw new Exception("TOMA EXCEPCIÓN");
                }
            } else
                System.out.println("No hay origen");

            escribirDestinoLinea.close();
            leerOrigenLinea.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
