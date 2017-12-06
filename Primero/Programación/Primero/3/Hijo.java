
public class Hijo implements Cloneable{
	String nombre;
	int edad;
	Hijo(String nombre,int edad){
		this.nombre=nombre;
		this.edad=edad;
	}
	public String toString() {
		return "Hijo [nombre=" + nombre + ", edad=" + edad + "]";
	}
	public Object clone(){
		Object o;
		try {
			o=super.clone();
		} catch (CloneNotSupportedException e) {
			o=null;
		}
		return o; 
	}
}
