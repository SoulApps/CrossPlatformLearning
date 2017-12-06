package pruebas;

public class Ejemplo {

	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_RESET = "\u001B[0m";
	private int numero;

	Ejemplo(int numero){
		this.numero=numero;
	}
	
	public String toString(){
		return ANSI_CYAN+"Este es el ejemplo número: "+numero+ANSI_RESET; /*Es importante hacer el reset para evitar que el resto de los datos 
																			salgan de un color normal a no ser que se cambie en el main*/ 
	}
}
