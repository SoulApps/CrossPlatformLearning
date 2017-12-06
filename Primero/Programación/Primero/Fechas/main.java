package fechas;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
			
		GregorianCalendar fechaNac = new GregorianCalendar(1992, 06, 15);
		Time hora;
		
		System.out.println("-- Prueba dameMiliSec(int hora, int min, int sec) --");
		System.out.printf("Milisegundos: %d\n",Fechas.dameMiliSec(20,15,30));
		
		System.out.println("\n-- Prueba dameMiliSec(String hora) --");
		System.out.printf("Milisegundos: %d\n",Fechas.dameMiliSec("20:15:30"));
		
		System.out.println("\n-- Prueba dameMiliSec(String hora) con formato incorrecto --");
		System.out.printf("Milisegundos: %d\n",Fechas.dameMiliSec("20:15-30"));
		
		System.out.println("\n-- Prueba Milisegundos de Java --");
		hora = Time.valueOf("20:15:30");
		System.out.printf("Milisegundos con método Java: %d\n",hora.getTime());
		
		System.out.println("\n-- Prueba dameMiliSec(String hora) --");
		System.out.printf("Milisegundos: %d\n\n",Fechas.dameMiliSec("01:00:00"));
		
		System.out.println("-- Prueba Milisegundos de Java --");
		hora = Time.valueOf("00:00:00");
		System.out.printf("Milisegundos con método Java: %d\n",hora.getTime());

		System.out.println("\n-- Prueba dameEdad(Date fecha) --");
		System.out.printf("Edad: %d\n",Fechas.dameEdad(fechaNac.getTime()));
		
		System.out.println("\n-- Prueba dameEdad(String fecha) --");
		System.out.printf("Edad: %d\n",Fechas.dameEdad("15/06/1992"));
		
		System.out.println("\n-- Prueba dameEdad(String fecha) con formato incorrecto --");
		System.out.printf("Edad: %d\n",Fechas.dameEdad("15/06-1992"));
		
		System.out.println("\n-- Prueba normalToAmericano(String fecha) --");
		System.out.printf("fecha formato americano: %s\n",Fechas.normalToAmericano("12/5/1992"));
		
		System.out.println("\n-- Prueba normalToAmericano(String fecha) con formato fecha incorrecto --");
		System.out.printf("fecha formato americano: %s\n",Fechas.normalToAmericano("12/5-1992"));
		
		System.out.println("\n-- Prueba americanoToNormal(String fecha) --");
		System.out.printf("fecha formato normal: %s\n",Fechas.americanoToNormal("12/5/1992"));
		
		System.out.println("\n-- Prueba americanoToNormal(String fecha) con formato fecha incorrecto --");
		System.out.printf("fecha formato normal: %s\n",Fechas.americanoToNormal("12/5-1992"));
		
		System.out.println("\n-- Ejercicio 04 Boletín de fechas --");
		Date fecha = new Date();
		SimpleDateFormat formatoF = new SimpleDateFormat("'Hoy es' EEEE dd-MMMM-yyyy 'a las' HH:mm:ss");
		System.out.println(formatoF.format(fecha));
	}
}

