import java.util.Date;

public class ClaseDate {

	public static void main(String[] args) {
		
		Date fecha1 = new Date(); //Se crea una fecha con el instante actual
		Date fecha2 = new Date();
		Date fecha3;
		
		System.out.printf("Fecha1: %s\nFecha2: %s\n",fecha1,fecha2);
		System.out.printf("Ambas fechas son iguales porque se han creado en el mismo instante, por lo tanto, compareTo devuelve %d\n\n", fecha1.compareTo(fecha2)); //Devuelve 0
		
		//Creamos la fecha 28/09/1988, 18:50:00 pasada en milisegundos. CET significa Central European Time
		fecha3 = new Date(591472200000L);
		System.out.printf("Fecha3: %s\n", fecha3);
		System.out.printf("¿Es fecha1 posterior a fecha3?: %s\n", fecha1.after(fecha3));
		System.out.printf("compareTo fecha1 con fecha3 devuelve %d\n",fecha1.compareTo(fecha3));
		System.out.printf("¿Es fecha1 anterior a fecha3?: %s\n", fecha1.before(fecha3));
		System.out.printf("compareTo fecha3 con fecha1 devuelve %d\n\n",fecha3.compareTo(fecha1));
		
		//Obtenemos la fecha1 en milisegundos
		System.out.printf("Fecha1 en milisegundos: %s\n", fecha1.getTime());
		//Cambiamos el valor de fecha1
		System.out.printf("Fecha1 antes del cambio: %s\n", fecha1);
		fecha1.setTime(591472200000L);
		System.out.printf("Fecha1 después del cambio: %s", fecha1);		
	}
}
