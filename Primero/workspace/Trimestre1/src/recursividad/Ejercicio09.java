package recursividad;

/**
 * Created by Alejandro on 12/11/2015.
 */
public class Ejercicio09 {
    public static void main(String[] args) {
        System.out.println(gcd(36, 60));
    }
    public static int gcd(int x, int y) {
        int resultado = 0;

        if (x % y == 0) {
            resultado = y;
        }
        else
            resultado = gcd(y, x % y);
        return resultado;
    }
}
