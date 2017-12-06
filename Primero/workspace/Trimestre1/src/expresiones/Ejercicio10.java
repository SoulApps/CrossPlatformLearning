package expresiones;

public class Ejercicio10 {

	public static void main(String[] args) {

		int x = 10;
		int y = -10;
		float n = (float) 13.269834;
		String cad = "Ana";
		
		System.out.printf("%d\n", x);
		System.out.printf("%+d\n", x);
		System.out.printf("%d\n", y);
		System.out.printf("%.2f\n", n);
		System.out.printf("%+.4f\n", n);
		System.out.printf("%5f\n", n);
		System.out.printf("%+010.3f\n", n);
		System.out.printf("n=%-8.2fx=%d\n", n, x);
		System.out.printf("%5s%s%5s", cad, cad, cad);

	}

}
