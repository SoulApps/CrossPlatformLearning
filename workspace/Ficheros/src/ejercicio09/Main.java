package ejercicio09;

import teclado.EnumLimite;
import teclado.EnumRango;
import teclado.Teclado;

import java.io.*;

/**
 * Created by Alejandro on 20/10/2016.
 */
public class Main {

    private static final int TAMAHNHO = 59;

    public static void main(String[] args) {
        //59 60
        boolean salir = false;
        int id;
        File ejercicio08 = new File(".\\src\\ejercicio08\\FicheroSin.dat");
        File f = new File(".\\src\\ejercicio09\\Origen.dat");

        leerBinarioSerializable(ejercicio08, f);

        do {
            switch (Teclado.nextInt("¿Qué quieres hacer?\n1. Consultar el fichero completo\n2. Consultar contacto\n3. Añadir contacto por el final\n4. Añadir contacto en la primera posición libre\n5. Eliminar contacto\n6. Modificar\n7. Compactar\n8. Salir", 1, 8, EnumRango.AMBOSINCLUIDOS)) {
                case 1:
                    leerSecuencial(f);
                    break;
                case 2:
                    id = Teclado.nextInt("¿Qué ID estás buscando?", 0, EnumLimite.MAYOR);
                    consultarContacto(f, id);
                    break;
                case 3:
                    anhadirContacto(true, f, "Pipiolo4", "423456789", "Calle Falsa 123", 11200, "01-01-2001", false, 0);
                    break;
                case 4:
                    anhadirContacto(false, f, "Pipiolo5", "523456789", "Calle Falsa 123", 11200, "01-01-2001", false, 0);
                    break;
                case 5:
                    id = Teclado.nextInt("¿Qué ID quieres borrar?", 0, EnumLimite.MAYOR);
                    borrarContacto(id, f);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    salir = true;
                    System.out.println("Adiós con el corazón");
                    break;
            }
        } while (!salir);
    }

    public static void leerSecuencial(File f) {
        RandomAccessFile raf;
        int id = 1;
        long posicion = 0;

        try {
            raf = new RandomAccessFile(f, "r");
            System.out.println(raf.length());
            while (posicion != raf.length()) {
                posicion = raf.getFilePointer();
                if (raf.readBoolean())
                    System.out.printf("ID: %d - Nombre: %s - Teléfono: %s - Dirección: %s - Código postal: %d - Fecha de nacimiento: %s - ¿Debe? %s - Deuda: %.2f%n", id, raf.readUTF(), raf.readUTF(), raf.readUTF(), raf.readInt(), raf.readUTF(), raf.readBoolean() ? "Sí" : "No", raf.readFloat());
                else
                    raf.seek(posicion += TAMAHNHO);
                id++;
            }
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }

    public static void consultarContacto(File f, int id) {
        RandomAccessFile raf;
        long posicion = (id - 1) * TAMAHNHO;
        try {
            raf = new RandomAccessFile(f, "r");

            if (posicion >= raf.length())
                System.out.println("No existe ese contacto");
            else {
                raf.seek(posicion);
                if (raf.readBoolean())
                    System.out.printf("ID: %d - Nombre: %s - Teléfono: %s - Dirección: %s - Código postal: %d - Fecha de nacimiento: %s - ¿Debe? %s - Deuda: %.2f%n", id, raf.readUTF(), raf.readUTF(), raf.readUTF(), raf.readInt(), raf.readUTF(), raf.readBoolean() ? "Sí" : "No", raf.readFloat());
                else
                    System.out.println("No existe ese contacto");
            }

            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }

    public static void anhadirContacto(boolean fin, File f, String nombre, String telefono, String direccion, int codigoPostal, String fechaNacimiento, boolean leDebo, float deuda) {
        RandomAccessFile raf;
        long posicion;

        try {
            raf = new RandomAccessFile(f, "rw");
            if (fin)
                raf.seek(raf.length() - 1);
            else {
                while(!raf.readBoolean()) {
                    posicion = raf.getFilePointer();
                    raf.seek(posicion + TAMAHNHO );
                }
            }

            raf.seek(raf.getFilePointer() - 1);

            raf.writeBoolean(true);
            raf.writeUTF(nombre);
            raf.writeUTF(telefono);
            raf.writeUTF(direccion);
            raf.writeInt(codigoPostal);
            raf.writeUTF(fechaNacimiento);
            raf.writeBoolean(leDebo);
            raf.writeFloat(deuda);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public static void borrarContacto(int id, File f) {
        RandomAccessFile raf;
        long posicion = (id - 1) * TAMAHNHO;

        try {
            raf = new RandomAccessFile(f, "rw");

            if (posicion >= raf.length())
                System.out.println("No existe ese contacto");
            else {
                raf.seek(posicion);
                raf.writeBoolean(false);
            }

            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }








    public static void leerBinarioSerializable(File origen, File destino) {
        DataInputStream in = null;
        RandomAccessFile raf = null;
        try {
            in = new DataInputStream(new FileInputStream(origen));
            raf = new RandomAccessFile(destino, "rw");
            while (true) {
                raf.writeBoolean(true);
                raf.writeUTF(in.readUTF());
                raf.writeUTF(in.readUTF());
                raf.writeUTF(in.readUTF());
                raf.writeInt(in.readInt());
                raf.writeUTF(in.readUTF());
                raf.writeBoolean(in.readBoolean());
                raf.writeFloat(in.readFloat());
            }

        } catch (EOFException e) {

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        try {
            in.close();
            raf.close();
        } catch (IOException e) {

        }
    }
}
