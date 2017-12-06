package estructurada;
	
import java.util.Scanner;

public class EJER1 {
	
	public static void main(String[] args) {
		
		boolean b;
		int i;
		char c;
		double d;
		String resultado, s;
		Scanner teclado = new Scanner(System.in);

		b = teclado.nextBoolean();
		i = teclado.nextInt();
		s = teclado.next();//c = teclado.next().charAt(0);
		d = teclado.nextDouble();

		c = s.charAt(0);
		resultado = String.valueOf(b) + String.valueOf(i) + String.valueOf(c) + String.valueOf(d);
		System.out.println(resultado);

		teclado.close();
	
	}

}
