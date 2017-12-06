package ejercicio08;

import java.io.*;
import java.util.Date;

/**
 * Created by Alejandro on 10/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        Agenda pipiolos[] = new Agenda[3];
        pipiolos[0] = new Agenda("Pipiolo1", "123456789", "Calle Falsa 123", 11200, "01-01-2001", false, 0);
        pipiolos[1] = new Agenda("Pipiolo2", "223456789", "Calle Falsa 123", 11200, "01-01-2001", true, 0);
        pipiolos[2] = new Agenda("Pipiolo3", "323456789", "Calle Falsa 123", 11200, "01-01-2001", false, 0);
        File ficheroSin = new File(".\\src\\ejercicio08\\FicheroSin.dat");
        File ficheroCon = new File(".\\src\\ejercicio08\\FicheroCon.dat");
        DataInputStream in = null;
        DataOutputStream out;
        ObjectInputStream iN = null;
        ObjectOutputStream ouT;

        try {
            in = new DataInputStream(new FileInputStream(ficheroSin));
            out = new DataOutputStream(new FileOutputStream(ficheroSin));

            for (i = 0; i < pipiolos.length; i++) {
                out.writeUTF(pipiolos[i].getNombre());
                out.writeUTF(pipiolos[i].getTelefono());
                out.writeUTF(pipiolos[i].getDireccion());
                out.writeInt(pipiolos[i].getCodigoPostal());
                out.writeUTF(pipiolos[i].getFechaNacimiento());
                out.writeBoolean(pipiolos[i].isLeDebo());
                out.writeFloat(pipiolos[i].getDeuda());
            }
            out.close();
            for (; ; ) {
                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                System.out.println(in.readInt());
                System.out.println(in.readUTF());
                System.out.println(in.readBoolean());
                System.out.println(in.readFloat());
            }


        } catch (IOException e) {
            try {
                in.close();
            } catch (IOException e1) {

            }
        }


        try {
            iN = new ObjectInputStream(new FileInputStream(ficheroCon));
            ouT = new ObjectOutputStream(new FileOutputStream(ficheroCon));

            for (i = 0; i < pipiolos.length; i++)
                ouT.writeObject(pipiolos[i]);
            ouT.close();

            for (; ; )
                System.out.println(iN.readObject());


        } catch (FileNotFoundException e) {

        } catch (IOException | ClassNotFoundException e) {
            try {
                iN.close();
            } catch (IOException e1) {

            }
        }
    }

    public static void leerBinario(File f) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(f));

        try {
            while (true) {
                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                System.out.println(in.readInt());
                System.out.println(in.readUTF());
                System.out.println(in.readBoolean());
                System.out.println(in.readFloat());
            }
        } catch (IOException e) {
        }

        in.close();
    }

    public static void escribirBinario(File f, Agenda a) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(f));

        out.writeUTF(a.getNombre());
        out.writeUTF(a.getTelefono());
        out.writeUTF(a.getDireccion());
        out.writeInt(a.getCodigoPostal());
        out.writeUTF(a.getFechaNacimiento());
        out.writeBoolean(a.isLeDebo());
        out.writeFloat(a.getDeuda());

        out.close();
    }

    public static void leerBinarioSerializable(File f) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));

        try {
            while (true)
                System.out.println(in.readObject());
        } catch (EOFException e) {
            System.out.println("FIN DE FICHERO");
            in.close();
        }
    }

    public static void escribirBinarioSerializable(File f, Agenda a) throws IOException {
        ObjectOutputStream out;

        out = new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject(a);

        out.close();
    }
}
