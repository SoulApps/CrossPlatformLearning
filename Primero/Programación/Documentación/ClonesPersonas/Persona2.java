
public class Persona2 {
	/* No implementamos la interfaz Cloneable
	 * Anulamos el clone de Object
	 * Qué ocurre: 
	 * 		Nos obliga a poner try-catch para CloneNotSupportedException dentro del clone que hemos anulado de Object
	 * 		El clone de Object nos lanza la excepción, por lo tanto, no se llega a clonar
	 */
	String nombre;
	int numHijos;
	Persona2(String nombre,int numHijos){
		this.nombre=nombre;
		this.numHijos=numHijos;
	}
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Persona2 && nombre.equals(((Persona2)obj).nombre) 
				&& numHijos==((Persona2)obj).numHijos)
				resultado=true;
		return resultado;		
	}	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", numHijos=" + numHijos + "]";
	}
	protected Object clone(){
		Persona2 clonado;
		try {
			clonado=(Persona2) super.clone();
		} catch (CloneNotSupportedException e) {
			clonado=null;
		}
		return clonado;		
	}
	public static void main(String[] args) {
		Persona2 p=new Persona2("Ana",2);
		Persona2 clonado;
		clonado=(Persona2)p.clone();
		System.out.println(p.equals(clonado));
		System.out.println("Variable p: "+p.toString());
		System.out.println("Variable clonada: "+clonado.toString());//Aborta con NullPointerException
	}
}
