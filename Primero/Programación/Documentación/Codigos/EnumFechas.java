import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;


public class EnumFechas {

	public static void main(String[] args) {
		Locale l;
		Month mes;
		DayOfWeek lunes = DayOfWeek.MONDAY; 
		System.out.printf("8 días será: %s%n",lunes.plus(8)); 
		System.out.printf("2 días antes fue: %s%n%n",lunes.minus(2)); 
		
		l = new Locale("es","ES"); //Español, España
		System.out.printf("TextStyle.FULL:%s%n",lunes.getDisplayName(TextStyle.FULL, l)); 
		System.out.printf("TextStyle.NARROW:%s%n",lunes.getDisplayName(TextStyle.NARROW, l)); 
		System.out.printf("TextStyle.SHORT:%s%n%n",lunes.getDisplayName(TextStyle.SHORT, l)); 
		
		mes = Month.MARCH; 
		System.out.printf("Dos meses más y será: %s%n", mes.plus(2)); 
		System.out.printf("Hace 1 mes fué: %s%n", mes.minus(1)); 
		System.out.printf("Este mes tiene %s días %n%n", mes.maxLength());
		
		l = new Locale("pt"); //Portugués 
		System.out.printf("TextStyle.FULL:%s%n",mes.getDisplayName(TextStyle.FULL, l)); 
		System.out.printf("TextStyle.NARROW:%s%n",mes.getDisplayName(TextStyle.NARROW, l)); 
		System.out.printf("TextStyle.SHORT:%s%n",mes.getDisplayName(TextStyle.SHORT, l));
	}
}
