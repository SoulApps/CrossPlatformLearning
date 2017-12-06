import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ejercicio06 {
	public static String descodifica(int dato){
		String salida="", temp;
		SimpleDateFormat formatoD=new SimpleDateFormat("ddMMyy");
		SimpleDateFormat formatoS=new SimpleDateFormat("d-M-'20'yy");
		Date fecha;
		
		
		if (dato>=10100 && dato<=311299){
			temp=Integer.toString(dato);
			if (temp.length()==5)
				temp="0"+temp;
			try {
				fecha=formatoD.parse(temp);
				salida=formatoS.format(fecha);
			} catch (ParseException e) {

			}
			
		}else
			System.out.println("Error: el dato introducido debe estar entre 10100 y 311299");
		
		return salida;
	}
	public static void main(String[] args) {
		System.out.println(descodifica(130485));
	}
}
