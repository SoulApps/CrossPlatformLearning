package ejercicio25;

/**
 * Created by Alejandro on 23/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        Coche octavia = new Coche("0639GLZ", Marca.GLOBE, 2000, 140);
        System.out.println(octavia);
        octavia.arrancar();
        octavia.subirMarcha();
        System.out.println(octavia);
        octavia.marchaAtras();
        System.out.println(octavia);
        octavia.subirMarcha();
        System.out.println(octavia);
    }
}
