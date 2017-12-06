import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;


public class ClaseDateFormat {
	public static void main(String[] args) {
		
		int i;		
		Date fecha,fecha1,fecha2,fecha3,fecha4,fecha5,fecha6;
		DateFormat formato,formato1,formato2,formato3,formato4,formato5,formato6,formato7,formato8;
		String cad1, cad2, cad3, cad4;
		
		fecha=new Date();
		formato= DateFormat.getDateInstance();
		System.out.printf("Calendario por defecto: %s\n\n",formato.getCalendar());
		System.out.printf("Fecha con formato por defecto: %s\n",formato.format(fecha));
		
		fecha1=new Date();
		formato1= DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.printf("Fecha con formato corto: %s\n",formato1.format(fecha1));
		
		fecha2=new Date();
		formato2= DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.printf("Fecha con formato medio: %s\n",formato2.format(fecha2));
		
		fecha3=new Date();
		formato3= DateFormat.getDateInstance(DateFormat.LONG);
		System.out.printf("Fecha con formato largo: %s\n",formato3.format(fecha3));
		
		fecha4=new Date();
		formato4= DateFormat.getDateInstance(DateFormat.FULL);
		System.out.printf("Fecha con formato completo: %s\n\n",formato4.format(fecha4));
		
		//se instancia un objeto DateFormat con un formato por defecto
		formato5 = DateFormat.getInstance();
		//se instancia un objeto DateFormat con un estilo de fecha por defecto para la configuración regional predeterminada
		formato6 = DateFormat.getDateInstance();
		//se instancia un objeto DateFormat con un estilo de fecha determinado para la configuración regional predeterminada
		formato7 = DateFormat.getDateInstance(DateFormat.LONG);
		//se instancia un objeto DateFormat con un estilo de fecha determinado para una configuración regional indicada
		formato8 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
				
		//Conversión de la fecha actual a Strings usando el método format con los cuatro formatos anteriores
		cad1 = formato5.format(fecha);
		cad2 = formato6.format(fecha);
		cad3 = formato7.format(fecha);
		cad4 = formato8.format(fecha);
				
		System.out.printf("Formato5 a cadena: %s\n",cad1);
		System.out.printf("Formato6 a cadena: %s\n",cad2);
		System.out.printf("Formato7 a cadena: %s\n",cad3);
		System.out.printf("Formato8 a cadena: %s\n\n",cad4);
		
		//Creación de un objeto Date a partir de una cadena. Hay que controlar la excepción ParseException
		try{
			fecha5 = formato8.parse(cad4);
			System.out.printf("Creación de fecha5 a partir de cadena4: %s - %s\n",fecha5,formato8.format(fecha5));
			fecha6 = formato6.parse(cad2);
			System.out.printf("Creación de fecha6 a partir de cadena2: %s - %s\n\n",fecha6,formato6.format(fecha6));
		}
		catch(ParseException e){
			System.out.printf("Error al parsear %s\n",cad1);
		}
		
		//Muestra todas las posibles regiones que puedan ser utilizadas por los métodos get
		for(i=0;i<DateFormat.getAvailableLocales().length;i++)
			System.out.printf("%s%n",DateFormat.getAvailableLocales()[i]);
	}
}
