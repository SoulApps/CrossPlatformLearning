
public class Asignatura implements Cloneable{
	String nombre;
	int numHoras;
	
	Asignatura(String nombre,int numHoras){
		this.nombre=nombre;
		this.numHoras=numHoras;
	}
	public Object clone(){
		Asignatura asignatura;
		try {
			asignatura=(Asignatura) super.clone();			
		} catch (CloneNotSupportedException e) {
			asignatura=null;
		}
		return asignatura;
	}
	public boolean equals(Object o){
		boolean resultado=false;
		if(o instanceof Asignatura && nombre.equals(((Asignatura)o).nombre) && numHoras==((Asignatura)o).numHoras)
			resultado=true;
		return resultado;
	}
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", numHoras=" + numHoras + "]";
	}
	
}
