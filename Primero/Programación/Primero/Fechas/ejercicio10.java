import java.util.GregorianCalendar;

public class Ejercicio10 {
	public static boolean esBisiesto(int year){
		return new GregorianCalendar().isLeapYear(year);
	}
	public static boolean calcularBisiesto(int year){
		boolean salida=false;
		if(year%4==0 && year%100!=0 || year%400==0)
			salida=true;
		return salida;
		
	}
	public static void main(String[] args) {
		System.out.println(esBisiesto(2016));
		System.out.println(calcularBisiesto(2016));
	}
}
