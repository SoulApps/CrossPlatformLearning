package fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fechas {

	public static long dameMiliSec(String hora){ // Devuelve los milisec con un desfase de 1 hora (+ 3.600.000 milisec). 
		long milisec = 0;
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
		String array[];
		
		try {
			formato.parse(hora); // Para comprobar que la cadena cumple el patrón de hora HH:mm:ss. 
			array = hora.split(":");
			
			milisec = Integer.parseInt(array[0])*60*60*1000 + Integer.parseInt(array[1])*60*1000 +
					Integer.parseInt(array[2])*1000;
			
		} catch (ParseException e) {
			System.out.println("Formato de hora incorrecto [HH:mm:ss]");
		}
		
		return milisec;
	}
	
	public static long dameMiliSec(int hora, int min, int sec){ // Devuelve los milisec con un desfase de 1 hora (+ 3.600.000 milisec). 
		long milisec = 0;
		
		if (hora >= 0 && hora < 24 && min >= 0 && min < 60 && sec >= 0 && sec < 60)
			milisec = hora*60*60*1000 + min*60*1000 + sec*1000;
		
		return milisec;
	}
	
	public static int dameEdad(String fechaDeNac){
		int edad = 0;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String hoy, fActual[], fNac[];

		try {
			formato.parse(fechaDeNac);
			
			hoy = formato.format(new Date());
			
			fActual = hoy.split("/");
			fNac = fechaDeNac.split("/");
			
			// Compruebo si ya ha pasado el mes la fecha de nacimiento. Si no ha pasado, resta un año. 
			if (Integer.parseInt(fActual[1]) < Integer.parseInt(fNac[1]) - 1)
				edad = Integer.parseInt(fActual[2])-Integer.parseInt(fNac[2])-1;
			
			// Si ambas fechas están en el mismo mes, se comparán los días. Si no se pasa el día de fNac, se resta un año.
			else if (Integer.parseInt(fActual[1]) == Integer.parseInt(fNac[1]) - 1)
				if (Integer.parseInt(fActual[0]) < Integer.parseInt(fNac[0]))
					edad = Integer.parseInt(fActual[2])-Integer.parseInt(fNac[2])-1;
				else
					edad = Integer.parseInt(fActual[2])-Integer.parseInt(fNac[2]);
			
			else
				edad = Integer.parseInt(fActual[2])-Integer.parseInt(fNac[2]);
			
		} catch (ParseException e){
			System.out.println("Formato de fecha incorrecto [dd/MM/yyyy]");
		}

		return edad;
	}
	
	public static int dameEdad(Date fechaDeNac){
		int edad = 0;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String hoy, fActual[], fNac[], cadenaFNac;

		cadenaFNac = formato.format(fechaDeNac);
		hoy = formato.format(new Date());
		
		fActual = hoy.split("/");
		fNac = cadenaFNac.split("/");
		
		// Compruebo si ya ha pasado el mes la fecha de nacimiento. Si no ha pasado, resta un año. 
		if (Integer.parseInt(fActual[1]) < Integer.parseInt(fNac[1]) - 1)
			edad = Integer.parseInt(fActual[2])-Integer.parseInt(fNac[2])-1;
		
		// Si ambas fechas están en el mismo mes, se comparán los días. Si no se pasa el día de fNac, se resta un año.
		else if (Integer.parseInt(fActual[1]) == Integer.parseInt(fNac[1]) - 1)
			if (Integer.parseInt(fActual[0]) < Integer.parseInt(fNac[0]))
				edad = Integer.parseInt(fActual[2])-Integer.parseInt(fNac[2])-1;
			else
				edad = Integer.parseInt(fActual[2])-Integer.parseInt(fNac[2]);
		
		else
			edad = Integer.parseInt(fActual[2])-Integer.parseInt(fNac[2]);
		
		return edad;
	}
	
	public static String normalToAmericano(String fecha){
		SimpleDateFormat formatoA = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formatoN = new SimpleDateFormat("dd/MM/yyyy");
		String fechaA = "";
		Date fechaN;
		
		try {
			fechaN = formatoN.parse(fecha);
			fechaA = formatoA.format(fechaN);
			
		} catch (ParseException e){
			System.out.println("Formato de fecha incorrecto [dd/MM/yyyy]");
		}
		
		return fechaA;
	}
	
	public static String americanoToNormal(String fecha){
		SimpleDateFormat formatoA = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formatoN = new SimpleDateFormat("dd/MM/yyyy");
		String fechaN = "";
		Date fechaA;
		
		try {
			fechaA = formatoA.parse(fecha);
			fechaN = formatoN.format(fechaA);
			
		} catch (ParseException e){
			System.out.println("Formato de fecha incorrecto [dd/MM/yyyy]");
		}
		
		return fechaN;
	}
	

}
