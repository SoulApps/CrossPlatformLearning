import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ejercicio08 {
	public static String diaSemana(String cadena){
		Date fecha;
		SimpleDateFormat formatoF=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatoDia=new SimpleDateFormat("EEEE");
		String salida="";
		
		try {
			fecha=formatoF.parse(cadena);
			salida=formatoDia.format(fecha);
			
		} catch (ParseException e) {
			System.out.println("Error: formato de la fecha incorrecto. [dd/MM/yyyy]");
		}
		return salida;
	}
	public static void main(String[] args) {
		System.out.println(diaSemana("14/3/2015"));
		System.out.println(diaSemana("11/12/1992"));
	}
}
