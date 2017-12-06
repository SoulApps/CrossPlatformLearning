import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClaseSimpleDateFormat {
	public static void main(String[] args) {

		SimpleDateFormat sdf,sdf1,sdf2,sdf3,sdf4,sdf5,sdf6;
		String cadena;
		Date fecha;
		
		/*Construye un SimpleDateFormat utilizando el patrón por defecto
		y los símbolos de formato de fecha para la configuración regional predeterminada*/
		sdf = new SimpleDateFormat();
		System.out.printf("El patrón de este formato de fecha es %s\n", sdf.toLocalizedPattern());		
		fecha = new Date();
		System.out.printf("Fecha actual: %s\n",fecha);
		sdf1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		System.out.printf("Fecha actual %s con el patrón %s\n",sdf1.format(fecha),sdf1.toPattern());
		sdf2 = new SimpleDateFormat("HH:mm:ss");
		System.out.printf("Hora de fecha actual: %s\n",sdf2.format(fecha));
		sdf3 = new SimpleDateFormat("dd/MM/yyyy");
		System.out.printf("Fecha %s con el patrón %s\n ",sdf3.format(fecha),sdf3.toPattern());
		sdf4 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		System.out.printf("Hora y fecha:  %s\n",sdf4.format(fecha));
		sdf5 = new SimpleDateFormat("EEEE dd MMMM yyyy -HH:mm:ss");
		System.out.printf("Fecha actual %s con el patrón %s\n",sdf5.format(fecha),sdf5.toPattern());
		sdf5.applyPattern("EEE dd/MM/yy HH:mm");//cambiamos el patrón
		System.out.printf("Fecha actual %s con el patrón %s\n",sdf5.format(fecha),sdf5.toPattern());
		
		cadena = "12-2-5"; 
		sdf6 = new SimpleDateFormat("yy-MM-dd"); 
		try { 
			fecha = sdf6.parse(cadena); // Pasar la cadena con una fecha a tipo Date.
		} catch (ParseException ex) {
			System.out.printf("ERROR");
		}
		System.out.printf("Cadena: \"%s\" Fecha: %s - %s con el patrón %s\n",cadena,fecha,sdf6.format(fecha),sdf6.toPattern());
		
		
				

	}
}
