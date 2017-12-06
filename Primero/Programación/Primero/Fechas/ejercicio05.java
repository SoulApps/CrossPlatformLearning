import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ejercicio05 {
	public static int numDias(int dia, int mes){
		int diasPasados=0;
		SimpleDateFormat formatoF, diaAnyo, anyo;
		Date fActual=new Date(), fNueva;
		String cadena;
		//formato para sacar el año actual
		anyo=new SimpleDateFormat("yyyy");
		
		//guardamos la fecha introducida con el año actual en una cadena
		cadena=String.format("%d/%d/%s", dia,mes,anyo.format(fActual));
		
		// formato para asignar la fecha introducida
		formatoF=new SimpleDateFormat("dd/MM/yyyy");
		
		// formato para mostrar el dia del año de la fecha
		diaAnyo=new SimpleDateFormat("D");
		
		try {
			fNueva=formatoF.parse(cadena);
			diasPasados=Integer.parseInt(diaAnyo.format(fNueva))-1;
			
		} catch (ParseException e) {
			System.out.println("ERROR!!");
		}
		
		return diasPasados;
	}
	
	public static void main(String[] args) {
		System.out.println(numDias(2, 3));
	}
}
