import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Ejercicio09 {
	public static boolean fechaValida(String fecha){
		boolean salida=false;
		String [] fechas=new String[3];
		SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			formato.parse(fecha);
			fechas=fecha.split("/");
			salida=fechaValida(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]), Integer.parseInt(fechas[2]));
		} catch (ParseException e) {
			System.out.println("Error: Patron incorrecto [dd/MM/yyyy]");
		}
		return salida;
	}
	public static boolean fechaValida(int day, int month, int year){
		boolean salida=false;
		GregorianCalendar fecha;
		
		if(year>0 && month>=1 && month<=12 && day>=1 && day<=31){
			//le pasamos el dia a 1 para que no cambie el mes en caso de que se pase
			fecha = new GregorianCalendar(year, month-1, 1);
			if(day<=fecha.getActualMaximum(GregorianCalendar.DAY_OF_MONTH))
				salida=true;
		}
		return salida;
	}
	public static void main(String[] args) {
		System.out.println(fechaValida(31, 4, 2000));
		//System.out.println(fechaValida("29/2/2016"));
	}
}
