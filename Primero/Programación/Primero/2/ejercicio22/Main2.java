package ejercicio22;

public class Main2 {

	public static void main(String[] args) {
		
		Ordenador ordenador = new Ordenador();
		Ordenador ordenador2;
		Ordenador ordenador3 = new Ordenador("Hp", "50F", 40, (float)2.66, 500);
		
		ordenador2 = (Ordenador)ordenador3.clone(); 				//Prueba del metodo Clone.
		
		System.out.println(ordenador2.equals(ordenador3));//Prueba de equals que genera true.
		System.out.println(ordenador2.toString());		//Prueba del toString.

	}

}
