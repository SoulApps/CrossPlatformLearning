package ejercicio16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej16 {

    public static void main(String[] args) {
        String entrada ="[\n" +
                "    {\n" +
                "      \"nombre\": \"Juan\",\n" +
                "      \"direccion\": \"Calle real\",\n" +
                "      \"fechadeNac\": \"12/07/95\",\n" +
                "      \"id\": 0,\n" +
                "      \"telefono\": 685457896,\n" +
                "      \"codpostal\": 11250,\n" +
                "      \"cant\": 4.5,\n" +
                "      \"debo\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"nombre\": \"Pepe\",\n" +
                "      \"direccion\": \"Calle real2\",\n" +
                "      \"fechadeNac\": \"12/07/95\",\n" +
                "      \"id\": 0,\n" +
                "      \"telefono\": 685457896,\n" +
                "      \"codpostal\": 11250,\n" +
                "      \"cant\": 4.5,\n" +
                "      \"debo\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"nombre\": \"Pepe\",\n" +
                "      \"direccion\": \"Calle real2\",\n" +
                "      \"fechadeNac\": \"12/07/95\",\n" +
                "      \"id\": 0,\n" +
                "      \"telefono\": 685457896,\n" +
                "      \"codpostal\": 11250,\n" +
                "      \"cant\": 4.5,\n" +
                "      \"debo\": false\n" +
                "    }\n" +
                "]";
        String nombre="Juan";
        System.out.println(entrada);
        entrada = entrada.replace("\n","");
        /*Pattern limpiar = Pattern.compile(
                "\"nombre\":.+\"Juan\".*\"direccion\":.\"(.*?)\""
        );*/
        Pattern limpiar = Pattern.compile(
                "\"nombre\":.+?\""+nombre+"\",(.+?)}"
        );
        Matcher buscar = limpiar.matcher(entrada);
        while (buscar.find())
            System.out.println(buscar.group(1));
    }
}
