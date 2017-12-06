package ejercicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alejandro on 08/04/2016.
 */
public class Fechas {
    public static long horaEnMilisegundos(int hora, int minutos, int segundos) {
        return hora * 3600000 + minutos * 60000 + segundos * 1000;
    }

    public static int calcularEdad(Date fnac) {
        int edad = 0;
        String hoy, cadfnac;
        String fechaActual[], fechaNac[];
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        hoy = formato.format(new Date()); //Creo la fecha de hoy y la paso a String con el formato
        cadfnac = formato.format(fnac); //Paso la fecha de nacimiento a String con el formato

        //Meto la fecha usando el split con "/" para separar año, mes y día
        fechaActual = hoy.split("/");
        fechaNac = cadfnac.split("/");

        if (Integer.parseInt(fechaActual[1]) < Integer.parseInt(fechaNac[1])) //Compruebo ha pasado el mes y si no le resto 1 al año
            edad = Integer.parseInt(fechaActual[2]) - Integer.parseInt(fechaNac[2]) - 1; //Calculo la edad con la resta entre los años
        else if (Integer.parseInt(fechaActual[1]) == Integer.parseInt(fechaNac[1])) //Misma comprobación que antes pero si el mes es el mismo, se compararán los días
            if (Integer.parseInt(fechaActual[0]) < Integer.parseInt(fechaNac[0])) //Si no ha pasado
                edad = Integer.parseInt(fechaActual[2]) - Integer.parseInt(fechaNac[2]) - 1;
            else
                edad = Integer.parseInt(fechaActual[2]) - Integer.parseInt(fechaNac[2]); //Si no ha pasado
        else
            edad = Integer.parseInt(fechaActual[2]) - Integer.parseInt(fechaNac[2]); //Si el mes ha pasado

        return edad;
    }

    public static String normalToAmericano(String cadena) {
        String americano = "";
        SimpleDateFormat formatoAmericano = new SimpleDateFormat("mm/dd/yyyy");
        SimpleDateFormat formatoNormal = new SimpleDateFormat("dd/mm/yyyy");
        Date fecha;

        try {
            fecha = formatoNormal.parse(cadena); //Paso la cadena a fecha con formato normal y de camino compruebo si el formato por parámetros es correcto
            americano = formatoAmericano.format(fecha); //Paso la fecha a String con el formato americano
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecta. (Ejemplo: 23/11/2015)");
        }

        return americano;
    }

    public static String americanoToNormal(String cadena) {
        String normal = "";
        SimpleDateFormat formatoAmericano = new SimpleDateFormat("mm/dd/yyyy");
        SimpleDateFormat formatoNormal = new SimpleDateFormat("dd/mm/yyyy");
        Date fecha;

        try {
            fecha = formatoAmericano.parse(cadena); //Paso la cadena a fecha con formato americano y de camino compruebo si el formato por parámetros es correcto
            normal = formatoNormal.format(fecha); //Paso la fecha a String con el formato normal
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecta. (Ejemplo: 07/30/2015)");
        }

        return normal;
    }

    public static int contarDias(int dia, int mes) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, mes, dia);
        return c.get(Calendar.DAY_OF_YEAR);
    }

    public static String decodificarFechas(int dato) {
        String aux;
        String resultado = "";
        SimpleDateFormat formatoRaw = new SimpleDateFormat("ddMMyy");
        SimpleDateFormat formatoBonito = new SimpleDateFormat("dd/MM/'20'yy");
        Date fecha;

        if (dato >= 10100 && dato <= 311299) {
            aux = Integer.toString(dato); //Paso el dato a cadena
            if (aux.length() == 5) //Compruebo que su longitud es 5 y si es así le añado un 0 para que coja el 01-01-2000 y no tenga problemas con el substring
                aux = "0" + aux;
            try {
                fecha = formatoRaw.parse(aux); //Lo paso a fecha tal cual, sin guiones con este patrón
                resultado = formatoBonito.format(fecha); //Le doy el formato correcto al pasarlo a String
            } catch (ParseException e) {

            }
        }
        else
            System.out.println("Dato incorrecto");

        return resultado;
    }

    public static String formatearFecha(String dia, String mes, int anho) {
        String resultado = "";
        String cadFecha;
        Date fecha;
        SimpleDateFormat formatoOriginal = new SimpleDateFormat("EEEEMMMMyyyy");
        SimpleDateFormat formatoNuevo = new SimpleDateFormat("dd/MM/yyyy");

        cadFecha = dia + mes + anho;

        try {
            fecha = formatoOriginal.parse(cadFecha);
            resultado = formatoNuevo.format(fecha);
        } catch (ParseException e) {

        }

        return resultado;
    }

    public static String diaSemana(Date fecha) {
        String dia;
        SimpleDateFormat formato = new SimpleDateFormat("EEEE");

        dia = formato.format(fecha);

        return dia;
    }

    public static boolean fechaCorrecta(String fecha) {
        boolean resultado = true;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            formato.setLenient(false);
            formato.parse(fecha);
        } catch (ParseException e) {
            resultado = false;
        }

        return resultado;
    }

    public static boolean comprobarBisiesto(int anho) {
        return ((anho % 4 == 0) && (anho % 100 != 0) || (anho % 400 == 0)); //Los años bisiestos cumplen esta condición
    }
}
