import java.sql.Timestamp;

public class ClaseTimestamp {

	public static void main(String[] args) {
		
		Timestamp fecha1,fecha2,fecha3;
		
		//Constructor: se le pasa un tiempo en milisegundos
		fecha1 = new Timestamp(591472200000L);
		System.out.printf("Fecha1: %s\n", fecha1);		
		fecha2 = new Timestamp(820182945000L);
		System.out.printf("Fecha2: %s\n", fecha2);

		System.out.printf("¿Es fecha1 posterior a fecha2?: %s\n", fecha1.after(fecha2));
		System.out.printf("¿Es fecha1 anterior a fecha2?: %s\n", fecha1.before(fecha2));
		
		System.out.printf("Fecha1 en milisegundos: %s\n", fecha1.getTime());
		System.out.printf("Fecha1 en nanosegundos: %s\n", fecha1.getNanos());
		fecha1.setNanos(549854);
		System.out.printf("Nanosegundos de Fecha1 despues del cambio con setNanos: %s\n", fecha1.getNanos());
		fecha1.setTime(591472200000L);
		System.out.printf("Fecha1 despues del cambio con setTime: %s\n", fecha1);	
		System.out.printf("Fecha1 en nanosegundos: %s\n", fecha1.getNanos());//Se han perdido los nanosegundos

		//Crear un timestamp con el método estático valueOf pasándole un string con fecha en formato JDBC
		fecha3 = Timestamp.valueOf("1993-07-07 14:23:50");
		System.out.printf("Fecha3 creada con valueOf: %s\n", fecha3);			
		
	}

}
