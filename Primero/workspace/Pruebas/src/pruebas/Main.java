package pruebas;

public class Main {
	
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		
		String s=ANSI_GREEN+"El color se puede cambiar directamente en la asignación.";
		Ejemplo ejemplo = new Ejemplo(1);
		Contaminador contaminador = new Contaminador();
		Contaminado contaminado = new Contaminado();
		
		System.out.println(s);
		System.out.println(ejemplo.toString());
		System.out.println(ANSI_GREEN+"El toString mantiene su color."+ANSI_RESET);
		System.out.println(contaminador.toString());
		System.out.println("...se puede contaminar...");
		System.out.println(contaminado.toString());
		
		System.out.println(ANSI_RESET);
		System.out.println("Un reset puede resetear aunque el color venga de otra clase que no tiene color.");
		
		System.out.println(ANSI_GREEN+contaminado.toString()+ANSI_RESET); // Y puede cambiar por supuesto el color de un toString que no tenga uno.
		
		
	}

}
