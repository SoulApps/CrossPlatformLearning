import java.util.Calendar;


public class Eje5 {

	public static void main(String[] args) {
		int dia;
		int mes;
		
		System.out.println("Introduce dia:");
		dia = Lector.scanIntParam(1, 31);
		System.out.println("Introduce mes:");
		mes = Lector.scanIntParam(1, 12);
		
		System.out.println("Dias transcurridos desde 1 de enero: "+ej5(dia, mes));
	}
	
	
	private static int ej5(int dia, int mes) {
		Calendar ud = Calendar.getInstance();
		ud.set(Calendar.YEAR, mes-1, dia);
		return ud.get(Calendar.DAY_OF_YEAR)-1;
	}
}
