package ejercicios;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Alejandro on 08/04/2016.
 */
public class Main {
    public static void main(String[] args) {
        Date fecha = new Date();
        Time hora;
        GregorianCalendar gc;
        SimpleDateFormat formato, formato2;

        System.out.println("-------------EJERCICIO 1-------------");
        hora = Time.valueOf("01:00:01");
        System.out.println("Mi modo: " + Fechas.horaEnMilisegundos(1, 0, 1));
        System.out.println("Modo Java: " + hora.getTime()); //El de Java tiene una hora menos.

        System.out.println("-------------EJERCICIO 2-------------");
        gc = new GregorianCalendar(1976, 04, 21);
        System.out.println(Fechas.calcularEdad(gc.getTime()));

        System.out.println("-------------EJERCICIO 3-------------");
        System.out.println(Fechas.normalToAmericano("21/3/2014"));
        System.out.println(Fechas.americanoToNormal("3/21/2014"));

        System.out.println("-------------EJERCICIO 4-------------");
        formato = new SimpleDateFormat("'Hoy es' EEEE dd-MMMM-yyyy 'a las' HH:mm:ss");
        System.out.println(formato.format(fecha));

        System.out.println("-------------EJERCICIO 5-------------");
        System.out.println(Fechas.contarDias(1, 2)); //Mes de 0 a 11 (No controlo de 1 a 12 porque no uso teclado, de ser así tendría que restar 1 al mes en el set)

        System.out.println("-------------EJERCICIO 6-------------");
        System.out.println(Fechas.decodificarFechas(10100));

        System.out.println("-------------EJERCICIO 7-------------");
        System.out.println(Fechas.formatearFecha("Lunes", "Abril", 2016));

        System.out.println("-------------EJERCICIO 8-------------");
        System.out.println(Fechas.diaSemana(fecha));

        System.out.println("-------------EJERCICIO 9-------------");
        System.out.println(Fechas.fechaCorrecta("29/02/2016")?"Fecha correcta":"Fecha incorrecta");

        System.out.println("-------------EJERCICIO 10-------------");
        System.out.println(Fechas.comprobarBisiesto(2007)?"Es bisiesto":"No es bisiesto");
    }
}
