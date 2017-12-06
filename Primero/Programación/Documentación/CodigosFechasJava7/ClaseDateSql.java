import java.sql.Date;


public class ClaseDateSql {
	public static void main(String[] args) {

		Date date = new Date(9819813);//Se construye a partir de un valor en milisegundos
		System.out.printf("%s%n", date.toString());
		date.setTime(924902834);
		System.out.printf("%s%n", date.toString());

	}
}
