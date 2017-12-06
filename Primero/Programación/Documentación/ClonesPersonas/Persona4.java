
public class Persona4 implements Cloneable {
	/* Implementamos la interfaz Cloneable
	 * Anulamos el clone de Object
	 * Qué ocurre: 
	 * 		Nos obliga a poner try-catch para CloneNotSupportedException dentro del clone que hemos anulado de Object
	 * 		Clonamos bien
	 */
	String nombre;
	int numHijos;
	Persona4(String nombre,int numHijos){
		this.nombre=nombre;
		this.numHijos=numHijos;
	}
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Persona4 && nombre.equals(((Persona4)obj).nombre) 
				&& numHijos==((Persona4)obj).numHijos)
				resultado=true;
		return resultado;		
	}	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", numHijos=" + numHijos + "]";
	}
	protected Object clone(){
		Persona4 clonado;
		try {
			clonado=(Persona4) super.clone();
		} catch (CloneNotSupportedException e) {
			clonado=null;
		}
		return clonado;		
	}
	public static void main(String[] args) {
		Persona4 p=new Persona4("Ana",2);
		Persona4 clonado;
		clonado=(Persona4)p.clone();
		System.out.println(p.equals(clonado));
		System.out.println("Variable p: "+p.toString());
		System.out.println("Variable clonada: "+clonado.toString());
	}
}
