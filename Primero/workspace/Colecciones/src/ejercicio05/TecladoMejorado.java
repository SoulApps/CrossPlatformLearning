package ejercicio05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Alejandro on 23/04/2016.
 */
public class TecladoMejorado {

    public static Scanner teclado = new Scanner(System.in);

    public static void close() {
        teclado.close();
    }

    public static <T> T nextDatum(String mensaje, EnumGenerico g) {
        boolean error = false;
        String cadenaAuxChar;
        T t = null;
        do {
            System.out.println(mensaje);
            try {
                error = false;

                switch (g) {
                    case CHAR:
                        cadenaAuxChar = teclado.next();
                        if (cadenaAuxChar.length() != 1)
                            error = true;
                        else
                            error = false;
                        t = (T) new Character(cadenaAuxChar.charAt(0));
                        break;
                    case STRING:
                        t = (T) new String(teclado.nextLine());
                        break;
                    case BYTE:
                        t = (T) new Byte(teclado.nextByte());
                        break;
                    case SHORT:
                        t = (T) new Short(teclado.nextShort());
                        break;
                    case INT:
                        t = (T) new Integer(teclado.nextInt());
                        break;
                    case LONG:
                        t = (T) new Long(teclado.nextLong());
                        break;
                    case FLOAT:
                        t = (T) new Float(teclado.nextFloat());
                        break;
                    case DOUBLE:
                        t = (T) new Double(teclado.nextDouble());
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("¡Error tipo de dato introducido incorrecto!");
                error = true;
            } finally {
                teclado.nextLine();
            }
        }
        while (error);

        return t;
    }

    public static void main(String[] args) {
        System.out.println((Character) TecladoMejorado.nextDatum("Introduce un dato", EnumGenerico.CHAR));
        System.out.println((Double) TecladoMejorado.nextDatum("Introduce un dato", EnumGenerico.DOUBLE));
    }
}
