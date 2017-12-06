package cadenas;

/**
 * Created by Alejandro on 16/11/2015.
 */
public class Ejercicio14 {
    public static void main(String[] args) {
        String s = "hola", resultado;
        resultado = alReves(s);
        System.out.println(resultado);
    }

    public static String alReves(String s) {
        char c;
        int n;
        String resultado = "";
        if (s.length() == 0)
            resultado = "";
        else
            resultado = alReves(s.substring(1, s.length())) + s.charAt(0);
        return resultado;
    }
}
