package codigosJava8;

import java.time.LocalTime;


public class ClaseLocalTime {

	public static void main(String[] args) {
		
		LocalTime justoAhora,enOchoHoras;
		
		justoAhora = LocalTime.now();
		System.out.printf("En este momento son las %d horas con %d minutos y %d segundos\n",justoAhora.getHour(),justoAhora.getMinute(),justoAhora.getSecond());
		
		enOchoHoras = justoAhora.plusHours(8);
		System.out.printf("Dentro de ocho horas serán las %d horas con %d minutos y %d segundos\n",enOchoHoras.getHour(),enOchoHoras.getMinute(),enOchoHoras.getSecond());

	}

}
