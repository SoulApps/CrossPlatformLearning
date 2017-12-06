import java.util.InputMismatchException;
import java.util.Scanner;


public class Excepcion {

	public static void main(String[] args) {
		byte n=0;
		Scanner teclado=new Scanner(System.in);
		
		
		try {
			n = teclado.nextByte();
			System.out.printf("Valor de n: %d%n", n);
			System.out.printf("50 entre n: %d", 50 / n);
		} catch (InputMismatchException e) {
			System.out.println("Error: introduce un entero entre -128 y 127");
		} catch (ArithmeticException e){
			System.out.println("Error: no se puede dividir entre cero");
		}

	}
}
