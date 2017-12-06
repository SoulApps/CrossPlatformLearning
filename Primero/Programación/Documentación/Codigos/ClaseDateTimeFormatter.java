import java.time.*;
import java.time.format.*;

public class ClaseDateTimeFormatter {

	public static void main(String[] args) {
		
		DateTimeFormatter fechaFormateada,zonaHoraria,df; 
		String fechaInicial,fechaInicialHora;
		LocalDate fechaTomada;
		LocalDateTime fechaHoraTomada;
		
		fechaFormateada = DateTimeFormatter.ofPattern("yyyy/LL/dd");
		System.out.println(fechaFormateada.format(LocalDate.now()));
		System.out.println(LocalDate.parse("2014/11/15", fechaFormateada));
		zonaHoraria = DateTimeFormatter.ofPattern("d MMMM, yyyy h:mm a");
		System.out.println(ZonedDateTime.now().format(zonaHoraria));
		
		fechaInicial = "1906-12-31";
		fechaTomada = LocalDate.parse(fechaInicial);
		System.out.printf("Fecha: %s%n",fechaTomada);
		fechaInicialHora = "1906-12-31T12:05";
		fechaHoraTomada = LocalDateTime.parse(fechaInicialHora);
		System.out.printf("Fecha/Hora: %s%n",fechaHoraTomada);
		df = DateTimeFormatter.ofPattern("dd MMM yyyy");
		System.out.printf("%s con nuevo formato: %s",fechaTomada,df.format(fechaTomada));
	}
}
