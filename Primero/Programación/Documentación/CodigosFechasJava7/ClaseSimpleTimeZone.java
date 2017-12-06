import java.util.Calendar;
import java.util.SimpleTimeZone;


public class ClaseSimpleTimeZone {

	public static void main(String[] args) {
		  // Desplazamiento: -8:00 (-28800000 milisegundos)
	      // Comienzo: 2:00am el primer domingo de abril
	      // Fin: 2:00am el último domingo de octubre
	      // Cantidad de tiempo que el reloj se adelanta durante el horario de verano: 1 hora
		SimpleTimeZone stz1,stz2;  
		stz1 = new SimpleTimeZone(-28800000,"America/Los_Angeles",Calendar.APRIL, 1, -Calendar.SUNDAY,
	                     7200000,Calendar.OCTOBER, -1, Calendar.SUNDAY,7200000,3600000);
		
		
		
		System.out.printf("Desplazamiento horario con respecto al GMT: %d\n", stz1.getRawOffset());
		System.out.printf("Id de la zona horaria: %s\n", stz1.getID());
		System.out.printf("%s \n\n", stz1.useDaylightTime()?"Se adelanta el reloj durante el verano":"No se cambia el reloj durante el verano");

		stz2 = new SimpleTimeZone(0, "Europe/London");
		System.out.printf("Desplazamiento horario con respecto al GMT: %d\n", stz2.getRawOffset());
		System.out.printf("Id de la zona horaria: %s\n", stz2.getID());
		System.out.printf("%s \n\n", stz2.useDaylightTime()?"Se adelanta el reloj durante el verano":"No se adelanta el reloj durante el verano");
		
		System.out.printf("%s %s %s \n", stz1.getDisplayName(), stz1.hasSameRules(stz2)?"sigue las misma reglas para el cambio horario que":"no sigue las misma reglas para el cambio horario que",stz2.getDisplayName());
	}
}
