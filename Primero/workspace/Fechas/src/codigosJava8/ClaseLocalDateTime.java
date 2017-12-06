package codigosJava8;

import java.time.LocalDateTime;
import java.time.Month;


public class ClaseLocalDateTime {

	public static void main(String[] args) {
		
		LocalDateTime ahora,algunDia;
		
		ahora = LocalDateTime.now(); 
		System.out.printf("La hora es: %s%n", ahora); 
		algunDia = LocalDateTime.of(1976, Month.MARCH, 27, 6, 10); 
		System.out.printf("Yo nací el %s%n", algunDia); 
		System.out.printf("Hace seis meses fue %s%n", LocalDateTime.now().minusMonths(6));

	}

}
