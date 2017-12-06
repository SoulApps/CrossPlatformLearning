import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ejercicio07 {
	public static String sacarFecha(String dia, String mes, int año){
		String salida="",temp;
		SimpleDateFormat formatoE=new SimpleDateFormat("EEEE-MMMM-yyyy");
		SimpleDateFormat formatoS=new SimpleDateFormat("dd/MM/yyyy");
		Date fecha;
		// cadena para pasarle por formatoE y crear el date
		temp=String.format("%s-%s-%d",dia,mes,año);
		try {
			fecha=formatoE.parse(temp);
			salida=formatoS.format(fecha);
		} catch (ParseException e) {
			System.out.println("Error");
		}
	
		return salida;
	}
	
	public static void main(String[] args) {
		System.out.println(sacarFecha("Lunes", "Abril", 2015));// 01/05/2012
	}
}
