import java.util.GregorianCalendar;

public class ClaseGregorianCalendar {

	public static void main(String[] args) {

		GregorianCalendar gc = new GregorianCalendar(2015, GregorianCalendar.JUNE, 20);
		//O bien gc = new GregorianCalendar(2015, 05, 20);
		System.out.printf("%s\n", gc.getTime());
		gc.set(GregorianCalendar.HOUR_OF_DAY, 18);
		gc.set(GregorianCalendar.MINUTE, 30);
		System.out.printf("Después de los set: %s\n", gc.getTime());
		//Se modifica el valor del campo 2, que es el mes, y se le añaden 3 meses
		gc.add(2, 3);
		System.out.printf("Fecha sumando 3 meses: %s\n", gc.getTime());
		gc.add((GregorianCalendar.DAY_OF_MONTH), -3);//Restar 3 días
		System.out.printf("Fecha restando 3 días: %s\n", gc.getTime());
		gc.add((GregorianCalendar.MONTH), 5);//Sumar 5 meses
		System.out.printf("Fecha sumando 5 meses: %s\n", gc.getTime());
		gc.add((GregorianCalendar.YEAR), -26);//Restar 26 años
		System.out.printf("Fecha restando 26 años: %s\n", gc.getTime());
		System.out.printf("Ultimo mes del año: %s %n",gc.getActualMaximum(GregorianCalendar.MONTH));
		System.out.printf("El 2014 %s %n", gc.isLeapYear(2014)?"es un año bisiesto":"no es un año bisiesto");
		System.out.printf("El 1988 %s %n", gc.isLeapYear(1988)?"es un año bisiesto":"no es un año bisiesto");
		System.out.printf("Zona horaria: %s\n",gc.getTimeZone());
		System.out.printf("Cambio de fecha: %s",gc.getGregorianChange());
	}
}
