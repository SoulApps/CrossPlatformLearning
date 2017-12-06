package codigosJava8;

import java.time.*;


public class ClasesFechas {

	public static void main(String[] args) {
		
		YearMonth mes;
		LocalDate date,fechaActual; 
		DayOfWeek dia;
		MonthDay dia2;
		Year año;
		
		date = LocalDate.of(2009, Month.NOVEMBER, 16);
		dia=date.getDayOfWeek();
		System.out.printf("El día que conocí a quien es mi esposa fue el %s y fue un %s%n%n",date,dia); 
		
		fechaActual = LocalDate.now();
		System.out.printf("La fecha actual es %s, mes: %s, año:%s%n",fechaActual,fechaActual.getMonth(),fechaActual.getYear());
		System.out.printf("Hace una semana fue %s%n",fechaActual.minusDays(7));
		System.out.printf("Dentro de 2 meses será %s%n%n",fechaActual.plusMonths(2));
		
		mes = YearMonth.now(); 
		System.out.printf("Este mes es %s y tiene %d días%n", mes, 	mes.lengthOfMonth()); 
		mes = YearMonth.of(2004, Month.FEBRUARY); 
		System.out.printf("El mes %s tuvo %d días,%n", mes, mes.lengthOfMonth()); 
		mes = YearMonth.of(2010, Month.FEBRUARY); 
		System.out.printf("el mes %s tuvo %d días,%n", mes, mes.lengthOfMonth()); 
		mes = YearMonth.of(2000, Month.FEBRUARY); 
		System.out.printf("el mes %s tuvo %d días%n", mes, mes.lengthOfMonth()); 
		
		dia2=MonthDay.of(Month.FEBRUARY, 29); 
		System.out.printf("El día %s %s es válido para el año 2010%n%n",dia2,dia2.isValidYear(2010)?"":"no");

		año = Year.now(); 
		System.out.printf("Este año es %s y %s es bisiesto%n",año,año.isLeap()?"sí":"no");

	}

}
