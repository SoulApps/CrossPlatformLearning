import java.sql.Time;

public class ClaseTime {

	public static void main(String[] args) {
		
		Time hora=new Time(134234234);//Se construye la hora dándole un valor en milisegundos
		System.out.println(hora);
		hora.setTime(2342342); //La cambiamos dándole por parámetros una hora en milisegundos
		System.out.println(hora);		
		hora = Time.valueOf("18:30:25");  //Se crea la hora a partir de una cadena
		System.out.printf("%s%n", hora);
	}
}
