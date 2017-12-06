import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonaArrays implements Cloneable{
	/* Pruebas de clon con arrays y fechas:
	 * Los enum,wrappers,cadenas y primitivos se clonan bien con el clone de Object.
	 * Los arrays tienen clone. Funciona bien si el array es de primitivos,cadenas,
	 * enum o wrappers pero si el array es de objetos, se hace el clone del array
	 * para obtener otra dirección de memoria para el array clonado y después hay que
	 * clonar objeto por objeto del array con un for. 
	 * El equals de los arrays compara direcciones de memoria, es decir, que dos 
	 * variables apunten al mismo array. Por lo tanto, usar el método estático Arrays.equals
	 * para comparar dos arrays. 
	 * La clase Arrays dispone también del método estático toString para mostrar el 
	 * contenido de un array.
	 */
	String nombre;
	int numHijos;
	Date fecha;
	String hijos[]=new String[3];
	PersonaArrays(String nombre,int edad,Date fecha,String hijos[]){
		this.nombre=nombre;
		this.numHijos=edad;
		this.fecha=fecha;
		this.hijos=hijos;
	}
	public Object clone(){
		PersonaArrays clonado;
		try {
			clonado=(PersonaArrays)super.clone();//Se llama al clone de Object
			clonado.fecha=(Date)fecha.clone();//Cómo se clona una fecha
			clonado.hijos=hijos.clone(); //Cómo se clona un array de primitivos,cadenas,enum y wrappers
		} catch (CloneNotSupportedException e) {
			clonado=null;
		}
		return clonado;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + numHijos + ", fecha="
				+ fecha + ", hijos=" + Arrays.toString(hijos) + "]";//La clase Arrays tiene un toString
	}
	public static void main(String[] args) {
		PersonaArrays p1,clon;
		Date fecha=new Date();
		String hijos[]={"Juan","Eli","Lucy"};
				
		System.out.println("********* PRUEBAS CLON ***********");
		p1=new PersonaArrays("Juana",3,fecha,hijos);
		clon=(PersonaArrays)p1.clone();
		System.out.println("Persona p1  : "+p1.toString());
		System.out.println("Persona clon: "+clon.toString());
		//Se modifica el clon. Si el clone() está bien hecho,no debe afectar a p1
		clon.hijos[0]="Juanito";
		clon.fecha.setTime(234567);
		System.out.println("Persona p1  : "+p1.toString());
		System.out.println("Persona clon: "+clon.toString());				
	}	
}
