package pruebas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alejandro on 12/05/2016.
 */
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha1 = null, fecha2= null;
        try {
            fecha1 = formato.parse("21/07/1996");
            fecha2 = new Date();
        } catch (ParseException e) {

        }
        System.out.println(contarMeses(fecha1, fecha2));
    }

    public static int contarMeses(Date fecha1, Date fecha2) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(fecha1);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(fecha2);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH); //Sin este cuenta años solo

        return diffMonth;
    }
}
