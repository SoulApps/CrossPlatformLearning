package arrays;

import teclado.Teclado;
import java.util.Random;


public class Ejercicio21 {

    static Random rnd = new Random();
    public static void main(String[] args) {
        boolean ganar = true, error = true;
        byte menu = 0, i = 0;
        int r = 0;
        String mensaje = "";

        do {
            r = rnd.nextInt(3) + 1;
            switch (r) {
                case 1:
                    mensaje = "¿Es un número?";
                    break;
                case 2:
                    mensaje = "¿Es una vocal?";
                    break;
                case 3:
                    mensaje = "¿Es una consonante?";
            }
            error = Teclado.nextBoolean(mensaje, "Sí", "No");
            if (!error)
                i++;
        } while(i < 2 && !error);

        if (error)
            menu = (byte) r;
        else
            ganar = false;

        switch (menu) {
            case 1:
                ganar = adivinarNumero();
                break;
            case 2:
                ganar = adivinarVocal();
                break;
            case 3:
                ganar = adivinarConsonante();
                break;
        }

        if (!ganar)
            System.out.println("Has ganado");
        else
            System.out.println("Has perdido");
    }

    public static boolean adivinarNumero() {
        boolean ganar = false;
        boolean error = true;
        boolean esMayor = true;
        int r, i = 0, menor = 1, mayor = 9;

        do {
            r = rnd.nextInt(mayor) + menor;
            System.out.printf("El número aleatorio es %d%n", r);
            error = Teclado.nextBoolean("¿Es este número?", "Sí", "No");
            if (!error)
                i++;
            else {
                error = true;
                ganar = true;
            }
        } while(!error && i < 3);

        return ganar;
    }

    public static boolean adivinarVocal() {
        boolean ganar = false;
        boolean error = true;
        boolean esMayor = true;
        int r, menor = 1, i = 0, mayor = 5;
        char c = 'a';

        do {
            r = rnd.nextInt(mayor) + menor;
            switch (r) {
                case 1:
                    c = 'a';
                    break;
                case 2:
                    c = 'e';
                    break;
                case 3:
                    c = 'i';
                    break;
                case 4:
                    c = 'o';
                    break;
                case 5:
                    c = 'u';
                    break;
            }

            System.out.printf("La vocal aleatoria es %c%n", c);
            error = Teclado.nextBoolean("¿Es esta vocal?", "Sí", "No");
            if (!error)
                i++;
            else {
                error = true;
                ganar = true;
            }
        } while(!error && i < 2);

        return ganar;
    }

    public static boolean adivinarConsonante() {
        boolean ganar = false;
        boolean error = true;
        boolean esMayor = true;
        int r, menor = 97, i = 0, mayor = 26;
        char c = 0;
        do {
            do {
                r = rnd.nextInt((mayor)) + menor;
            } while(r == 'a' || r == 'e' || r == 'i' || r == 'o' || r == 'u');

            c = (char) r;

            System.out.printf("La consonante aleatoria es %c%n", c);
            error = Teclado.nextBoolean("¿Es esta consonante?", "Sí", "No");
            if (!error) {
                i++;
                esMayor = Teclado.nextBoolean("¿Es mayor?", "Sí", "No");
                if (esMayor) {
                    mayor = menor;
                    menor = r;
                }
                else
                    mayor = r;
            }
            else {
                error = true;
                ganar = true;
            }
        } while(!error && i < 5);

        return ganar;
    }
}
