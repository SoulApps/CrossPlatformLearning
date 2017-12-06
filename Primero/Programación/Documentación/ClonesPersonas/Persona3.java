
public class Persona3 implements Cloneable {
	/* Implementamos la interfaz Cloneable
	 * No anulamos el clone de Object
	 * Qué ocurre: 
	 * 		Nos obliga a poner try-catch para CloneNotSupportedException
	 * 		Clonamos bien
	 */
	String nombre;
	int numHijos;
	Persona3(String nombre,int numHijos){
		this.nombre=nombre;
		this.numHijos=numHijos;
	}
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Persona3 && nombre.equals(((Persona3)obj).nombre) 
				&& numHijos==((Persona3)obj).numHijos)
				resultado=true;
		return resultado;		
	}	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", numHijos=" + numHijos + "]";
	}

	public static void main(String[] args) {
		Persona3 p=new Persona3("Ana",2);
		Persona3 clonado=null;
		try {
			clonado=(Persona3)p.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Clone no soportado");
		}
		System.out.println(p.equals(clonado));
		System.out.println("Variable p: "+p.toString());
		System.out.println("Variable clonada: "+clonado.toString());
	}
}
