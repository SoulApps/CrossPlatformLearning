package ejercicio16;

import teclado.Teclado;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alejandro on 10/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        String buscar = Teclado.next("¿A quién quieres buscar?");
        File f = new File("./src/ejercicio16/Json.json");
        buscarNombreJson(buscar, f);
    }

    /*public static void buscarNombreJson(String buscar, File f) {
        final String mensajeError = "No existe ese contacto";
        boolean encontrado = false;
        String s, reemplazo = "[\t, ]", reemplazoResultado = "[\t\", ]";
        String formato = String.format("(\"nombre\":\"%s\")", buscar);
        Pattern patron = Pattern.compile(formato);
        Matcher matcher;
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            while (!(s = reader.readLine()).equals("]")) {
                s = s.replaceAll(reemplazo, "");
                matcher = patron.matcher(s);
                if (matcher.find()) {
                    encontrado = true;
                    System.out.println(matcher.group(1).replaceAll(reemplazo, ""));
                    while (!(s = reader.readLine()).replaceAll(reemplazo, "").equals("}"))
                        System.out.println(s.replaceAll(reemplazo, ""));
                }
            }
            if (!encontrado)
                System.out.println(mensajeError);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void buscarNombreJson(String buscar, File f) {
        final String mensajeError = "No existe ese contacto";
        boolean encontrado = false;
        String s;
        String formato = String.format("\"nombre\":.+?\"%s\",(.+?)}", buscar);
        Pattern patron = Pattern.compile(formato);
        Matcher matcher;

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            s = reader.readLine();
            //System.out.println(s);
            matcher = patron.matcher(s);

            while (matcher.find()) {
                encontrado = true;
                System.out.println(matcher.group(1));
            }

            if (!encontrado)
                System.out.println(mensajeError);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
