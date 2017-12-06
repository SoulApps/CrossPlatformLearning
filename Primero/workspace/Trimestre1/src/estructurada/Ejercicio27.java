package estructurada;

public class Ejercicio27 {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	
	public static void main(String[] args) {

		int i, j, k, l, x = 1, y = 1;
		String n = ANSI_BLACK + "██" + ANSI_RESET, b = "██";
		
		for (i = 1; i <= 8; i++) {
			for (j = 1; j <= 8; j++) {
				if (i == x && j == y) {
					System.out.print("A ");
				}
				else if ((i + j) %2 == 0) {
					System.out.print(n);
				}
				else if ((i + j) %2 != 0) {
					System.out.print(b);
				}	
				else if (i == x++ && j == y++){
					for (k = x++, l = y++; k < 8 && l < 8; k++, l++) {
						System.out.print("*");
						
					}
				}
			}
			System.out.println();
		}
	}

}
