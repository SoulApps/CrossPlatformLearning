import java.util.Calendar;
import java.util.Date;

public class ClaseCalendar {

	public static void main(String[] args) {
		
		Date fecha;
		
		//Obtenemos dos instancias de calendar
		Calendar calendario= Calendar.getInstance();
		Calendar calendario2= Calendar.getInstance();
		System.out.printf("Calendario con el getInstance(): %s\n",calendario.getTime());
		System.out.printf("Clase obtenida con el getInstance(): %s\n\n",calendario.getClass().getSimpleName());
		//Establecemos las fechas de cada uno
		calendario.set(1999, 01, 01);
		calendario2.set(2005, 01, 01);
		//Comprobamos si calendario es anterior a calendario2
		System.out.printf("Calendario: %s es %s a calendario2: %s\n",calendario.getTime(),calendario.before(calendario2)?"anterior":"posterior",calendario2.getTime());
		//Añadimos tres años y lo mostramos
		calendario.add(Calendar.YEAR, 3);
		System.out.printf("Calendario %s avanzado en 3 años\n\n",calendario.getTime());
		
		System.out.printf("Año= %d\n",calendario.get(Calendar.YEAR));
		System.out.printf("Mes= %d\n",calendario.get(Calendar.MONTH));//Los meses van de 0 a 11
		System.out.printf("Dia= %d\n",calendario.get(Calendar.DATE));
		System.out.printf("Hora= %d\n",calendario.get(Calendar.HOUR));
		
		System.out.printf("Máxima era: %d\n",calendario.getMaximum(Calendar.ERA));
		System.out.printf("Mínima era: %d\n",calendario.getMinimum(Calendar.ERA));
		System.out.printf("Máximo día: %d\n",calendario.getMaximum(Calendar.DATE));
		System.out.printf("Máxima hora: %d\n",calendario.getMaximum(Calendar.HOUR));
		System.out.printf("Máxima hora del día: %d\n\n",calendario.getMaximum(Calendar.HOUR_OF_DAY));
		
		calendario.set(1999, 7, 31);//31/08/1999
		System.out.printf("Fecha: %s\n",calendario.getTime());
		calendario.add(Calendar.MONTH, 8);//El año pasa a 2000
		System.out.printf("Fecha añadiendo 8 meses usando add: %s\n",calendario.getTime());
		
		calendario.set(1999, 7, 31);
		System.out.printf("Fecha: %s\n",calendario.getTime());
		calendario.roll(Calendar.MONTH, 8);//El año se queda a 1999
		System.out.printf("Fecha añadiendo 8 meses usando roll: %s\n\n",calendario.getTime());		
		
		calendario.set(2012, 2, 31);//31/03/2012
		System.out.printf("Fecha: %s\n",calendario.getTime());
		calendario.add(Calendar.DAY_OF_MONTH, 31);
		System.out.printf("Fecha añadiendo 31 días usando add: %s\n",calendario.getTime());
		
		calendario.set(2012, 2, 31);
		System.out.printf("Fecha: %s\n",calendario.getTime());
		calendario.roll(Calendar.DAY_OF_MONTH, 31);
		System.out.printf("Fecha añadiendo 31 días usando roll: %s\n\n",calendario.getTime());
		

		calendario.set(2013, 0, 31);//31/01/2013
		System.out.printf("Fecha: %s\n",calendario.getTime());
		calendario.add(Calendar.MONTH, 13);
		System.out.printf("Fecha añadiendo 13 meses usando add: %s\n",calendario.getTime());
		
		calendario.set(2013, 0, 31);//31/01/2013
		System.out.printf("Fecha: %s\n",calendario.getTime());
		calendario.roll(Calendar.MONTH, 13);
		System.out.printf("Fecha añadiendo 13 meses usando roll: %s\n\n",calendario.getTime());
		
		calendario.set(2013, 0, 31);//31/01/2013
		System.out.printf("Fecha: %s\n",calendario.getTime());
		calendario.add(Calendar.MONTH, -3);
		System.out.printf("Fecha restando 3 meses usando add: %s\n",calendario.getTime());
		
		calendario.set(2013, 0, 31);//31/01/2013
		System.out.printf("Fecha: %s\n",calendario.getTime());
		calendario.roll(Calendar.MONTH, -3);
		System.out.printf("Fecha restando 3 meses usando roll: %s\n\n",calendario.getTime());
		
		//isSet sirve para comprobar si un campo tiene el valor por defecto o no
		System.out.printf("Campo YEAR %s tiene valor por defecto: %s\n",calendario.isSet(Calendar.YEAR)?"no":"si",calendario.getTime());
		calendario.clear(); //Establece los valores por defecto
		System.out.printf("Campo YEAR %s tiene valor por defecto: %s\n",calendario.isSet(Calendar.YEAR)?"no":"si",calendario.getTime());
		
		/*Teniendo un Date es posible crear un Calendar, pero misteriosamente no existe un 
		 * constructor para esto por lo que se hace en dos pasos: crear un Calendar o utilizar 
		 * uno ya creado, y hacer que apunte a nuestro Date con el método setTime */
		fecha=new Date();
		calendario.setTime(fecha);
		System.out.printf("\nFecha actual: %s\n",calendario.getTime());
	}
}
