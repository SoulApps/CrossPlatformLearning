import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Persona implements Cloneable{
	String nombre;
	int edad;
	Date fecha;
	Categoria categoria;
	String hijos[]=new String[3];
	ArrayList<Hijo> lista_hijos;
	Persona(String nombre,int edad,Date fecha,Categoria categoria,String hijos[],ArrayList<Hijo> lista_hijos){
		this.nombre=nombre;
		this.edad=edad;
		this.fecha=fecha;
		this.categoria=categoria;
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
			//Hay dos formas de clonar una colección: con el clone y con el constructor
			//Forma 1: con el clone
			p.lista_hijos=(ArrayList<Hijo>) lista_hijos.clone();
			for(i=0;i<lista_hijos.size();i++)
				p.lista_hijos.set(i, (Hijo)lista_hijos.get(i).clone());
			/*Forma 2: con el constructor
			p.lista_hijos=new ArrayList<Hijo>(lista_hijos);
			for(i=0;i<lista_hijos.size();i++)
				p.lista_hijos.set(i, (Hijo)lista_hijos.get(i).clone());*/			
		} catch (CloneNotSupportedException e) {
			p=null;
		}
		return p;
	}
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", fecha="
				+ fecha + ", categoria=" + categoria + ", hijos="
				+ Arrays.toString(hijos) + ", lista_hijos=" + lista_hijos + "]";
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
		p1=new Persona("Juana",40,fecha,Categoria.JEFE,hijos,lista_hijos);
		p2=(Persona)p1.clone();
		System.out.printf("Persona1: %s%n",p1.toString());
		System.out.printf("Persona2: %s%n",p2.toString());
		p2.edad=30; //Se modifica p2. Si el clon está bien hecho,no debe afectar a p1
		p2.hijos[0]="Juanito";
		p2.fecha.setTime(934567899);
		p2.lista_hijos.get(0).nombre="Alejandro";
		System.out.printf("Persona1: %s%n",p1.toString());
		System.out.printf("Persona2: %s%n",p2.toString());
		
		System.out.println("********* PRUEBAS HASHCODE ***********");
		n1="Eva";
		n2="Ana";
		n3="Eva";
		i1=new Integer(5);
		i2=new Integer(5);
		System.out.printf("Hashcode n1: %d%n",n1.hashCode()); //Las String dan el mismo hashcode si el valor es el mismo
		System.out.printf("Hashcode n2: %d%n",n2.hashCode());
		System.out.printf("Hashcode n3: %d%n%n",n3.hashCode());
		
		System.out.printf("Hashcode i1: %d%n",i1.hashCode()); //Los wrappers dan el mismo hashcode si el valor es el mismo
		System.out.printf("Hashcode i2: %d%n%n",i2.hashCode());
		
		System.out.printf("fecha: %s Hashcode de fecha: %d%n",fecha,fecha.hashCode()); //Mismo valor de fecha, mismo hashcode
		System.out.printf("fecha1: %s Hashcode de fecha1: %d%n%n",fecha1,fecha1.hashCode());
		
		System.out.printf("Categoria de persona1: %s Su hashcode: %d%n",p1.categoria,p1.categoria.hashCode());//Mismo valor de enum, mismo hashcode
		System.out.printf("Categoria de su clon: %s Su hashcode: %d%n%n",p2.categoria,p2.categoria.hashCode());
				
		p3=p1;
		System.out.printf("Hashcode de persona1: %d%n",p1.hashCode());
		System.out.printf("Hashcode de persona3 que apunta al mismo sitio que persona1: %d%n",p3.hashCode());//Igual hashcode de p1 porque apuntan al mismo sitio, es decir,contienen la misma referencia a memoria
		p4=(Persona)p1.clone();
		System.out.printf("Hashcode de persona4 que es un clon de persona1: %d%n%n",p4.hashCode());//Distinto hashcode si es un clon
		
		System.out.printf("Hashcode de p1.lista_hijos: %d%n",p1.lista_hijos.hashCode());
		System.out.printf("Hashcode de p4.lista_hijos que está clonada de p1.lista_hijos: %d%n",p4.lista_hijos.hashCode());//Una lista da distinto hashcode que su lista clonada
		p4.lista_hijos.add(new Hijo("Pepe",7));
		System.out.printf("Hashcode de p4.lista_hijos añadiendo un hijo: %d%n%n",p4.lista_hijos.hashCode());//Añadiendo un elemento a la lista se modifica el hashcode
		
		lista_hijos2=new ArrayList<Hijo>();
		lista_hijos2.add(new Hijo("Juan",4));
		lista_hijos2.add(new Hijo("Eli",9));
		System.out.printf("lista_hijos: %s%nlista_hijos2: %s%n",lista_hijos,lista_hijos2);
		System.out.printf("lista_hijos %s a lista_hijos2%n",lista_hijos.equals(lista_hijos2)?"es igual":"no es igual");
		System.out.printf("Hashcode de lista_hijos %d%nHashcode de lista_hijos2 %d",lista_hijos.hashCode(),lista_hijos2.hashCode());//Dos listas iguales dan hashcode diferentes
	}	
}
