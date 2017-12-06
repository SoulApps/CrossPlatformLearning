import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Persona implements Cloneable{
	String nombre;
	int edad;
	Date fecha;
	String hijos[]=new String[3];
	ArrayList<Hijo> lista_hijos;
	Persona(String nombre,int edad,Date fecha,String hijos[],ArrayList<Hijo> lista_hijos){
		this.nombre=nombre;
		this.edad=edad;
		this.fecha=fecha;
		this.hijos=hijos;
		this.lista_hijos=lista_hijos;
	}
	@SuppressWarnings("unchecked")
	public Object clone(){
		int i;
		Persona p;
		try {
			p=(Persona)super.clone();
			p.fecha=(Date)fecha.clone();
			p.hijos=hijos.clone();
			p.lista_hijos=new ArrayList<Hijo>(lista_hijos);
			p.lista_hijos=(ArrayList<Hijo>) lista_hijos.clone();
			for(i=0;i<lista_hijos.size();i++)
				p.lista_hijos.set(i, (Hijo)lista_hijos.get(i).clone());
			
		} catch (CloneNotSupportedException e) {
			p=null;
		}
		return p;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", fecha="
				+ fecha + ", hijos=" + Arrays.toString(hijos)
				+ ", lista_hijos=" + lista_hijos + "]";
	}
	public static void main(String[] args) {
		String n1,n2,n3;
		Integer i1,i2;
		Persona p1,p2,p3,p4;
		Date fecha1=new Date(),fecha=new Date();
		String hijos[]={"Juan","Eli"};
		ArrayList<Hijo> lista_hijos2,lista_hijos=new ArrayList<Hijo>();
		
		System.out.println("********* PRUEBAS CLON ***********");
		lista_hijos.add(new Hijo("Juan",4));
		lista_hijos.add(new Hijo("Eli",9));
		p1=new Persona("Juana",40,fecha,hijos,lista_hijos);
		p2=(Persona)p1.clone();
		System.out.println("Persona1: "+p1.toString());
		System.out.println("Persona2: "+p2.toString());
		p2.edad=30; //Se modifica p2. Si el clon está bien hecho,no debe afectar a p1
		p2.hijos[0]="Juanito";
		p2.fecha.setTime(934567899);
		p2.lista_hijos.get(0).nombre="Alejandro";
		System.out.println("Persona1: "+p1.toString());
		System.out.println("Persona2: "+p2.toString());
		
		System.out.println("********* PRUEBAS HASHCODE ***********");
		n1="Eva";
		n2="Ana";
		n3="Eva";
		i1=new Integer(5);
		i2=new Integer(5);
		System.out.println("Hashcode n1: "+n1.hashCode()); //Las String dan el mismo hashcode si el valor es el mismo
		System.out.println("Hashcode n2: "+n2.hashCode());
		System.out.println("Hashcode n3: "+n3.hashCode());
		System.out.println("Hashcode i1: "+i1.hashCode()); //Los wrappers dan el mismo hashcode si el valor es el mismo
		System.out.println("Hashcode i2: "+i2.hashCode());
		
		System.out.println("fecha: "+fecha+" Hashcode de fecha: "+fecha.hashCode()); //Mismo valor de fecha, mismo hashcode
		System.out.println("fecha1: "+fecha1+" Hashcode de fecha1: "+fecha1.hashCode());
				
		p3=p1;
		System.out.println("Hashcode de persona1: "+p1.hashCode());
		p4=(Persona)p1.clone();
		System.out.println("Hashcode de persona4 que es un clon de p1: "+p4.hashCode());//Distinto hashcode si es un clon
		System.out.println("Hashcode de persona3: "+p3.hashCode());//Igual hashcode de p1 porque apuntan al mismo sitio, es decir,contienen la misma referencia a memoria
		
		p4=(Persona)p1.clone();
		lista_hijos2=new ArrayList<Hijo>();
		lista_hijos2.add(new Hijo("Juan",4));
		lista_hijos2.add(new Hijo("Eli",9));
		System.out.println("Hashcode de p1.lista_hijos  "+p1.lista_hijos.hashCode());
		System.out.println("Hashcode de p4.lista_hijos "+p4.lista_hijos.hashCode());
		p4.lista_hijos.add(new Hijo("Pepe",7));
		System.out.println("Hashcode de p4.lista_hijos añadiendo un hijo "+p4.lista_hijos.hashCode());
		System.out.println("Hashcode de lista_hijos3 "+lista_hijos2.hashCode());//Añadiendo los mismos objetos da distinto hashcode
	}	
}
