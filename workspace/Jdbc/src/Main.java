/**
 * Created by Alejandro on 05/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        prueba("hola", "adios", "stfu", "bernardaspussy");
    }

    public static void prueba(String... args) {
        for (int i = 0; i < args.length; i++)
            System.out.println(args[i]);

        for (String arg : args)
            System.out.println(arg);
    }
}
