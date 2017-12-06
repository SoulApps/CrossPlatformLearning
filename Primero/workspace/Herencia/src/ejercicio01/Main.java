package ejercicio01;

/**
 * Created by Alejandro on 19/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        Profesor p = new Profesor("Leprofe", (byte) 50, Sexo.HOMBRE, "Española", 1830.33f);
        Alumno a = new Alumno();
        System.out.println(a);
        System.out.println(p);
    }
}
