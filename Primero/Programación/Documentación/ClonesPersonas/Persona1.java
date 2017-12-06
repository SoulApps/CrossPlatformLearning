
public class Persona1 {
	/* No implementamos la interfaz Cloneable
	 * No anulamos el clone de Object
	 * Qué ocurre: 
	 * 		Nos obliga a poner try-catch para CloneNotSupportedException
	 * 		El clone de Object nos lanza la excepción, por lo tanto, no se llega a clonar
	 */
	String nombre;
	int numHijos;
	Persona1(String nombre,int numHijos){
		this.nombre=nombre;
		this.numHijos=numHijos;
	}
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Persona1 && nombre.equals(((Persona1)obj).nombre) 
				&& numHijos==((Persona1)obj).numHijos)
				resultado=true;
		return resultado;		
	}	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", numHijos=" + numHijos + "]";
	}

	public static void main(String[] args) {
		Persona1 p=new Persona1("Ana",2);
		Persona1 clonado=null;
		try {
			clonado=(Persona1)p.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Clone no soportado");
		}
		System.out.println(p.equals(clonado));
		System.out.println("Variable p: "+p.toString());
		System.out.println("Variable clonada: "+clonado.toString());//Aborta con NullPointerException
	}
}
