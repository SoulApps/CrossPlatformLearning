package codigosJava8;

import java.time.LocalDate;
import java.time.Period;


public class ClasePeriod {

	public static void main(String[] args) {
		
		LocalDate fechaA,fechaB;
		Period period;
		
		fechaA = LocalDate.of(1978, 8, 26);
		fechaB = LocalDate.of(1988, 9, 28);
		period = Period.between(fechaA, fechaB);
		System.out.printf("Periodo %s y %s hay %d años, %d meses y %d dias%n", fechaA, fechaB,period.getYears(),
				period.getMonths(),period.getDays());

	}

}
