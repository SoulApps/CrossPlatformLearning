package colecciones;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.TreeSet;

public class Arboles {

	public static void main(String[] args) {
		TreeSet<Empleado> arbol = new TreeSet<Empleado>(new Comparator<Empleado>(){
			public int compare(Empleado e1, Empleado e2){
				return e1.toString().compareTo(e2.toString());
			}
		}
	);
		
		
		Empleado e1=new Empleado("Pepe", Categoria.EMPLEADO, null, null);
		Empleado e2=new Empleado("Juan", Categoria.ENCARGADO, null, null);
		Empleado e3=new Empleado("María", Categoria.JEFE, null, null);
		Empleado e4=new Empleado("Laura", Categoria.EMPLEADO, null, null);
		Empleado e5=new Empleado("Esteban", Categoria.ENCARGADO, null, null);
		Empleado e6=new Empleado("Pedro", Categoria.JEFE, null, null);
		Empleado e7=new Empleado("Yolanda", Categoria.EMPLEADO, null, null);
		Empleado e8=new Empleado("Nuria", Categoria.JEFE, null, null);
		Empleado e9=new Empleado("Antonio", Categoria.ENCARGADO, null, null);
		
		Empleado e10=new Empleado();
		e10=(Empleado)e1.clone();
		Empleado e11=new Empleado();
		e11=(Empleado)e5.clone();
		Empleado e12=new Empleado();
		e12=(Empleado)e6.clone();
		
		//Adds
		arbol.add(e1);
		arbol.add(e2);
		arbol.add(e3);
		arbol.add(e4);
		arbol.add(e5);
		arbol.add(e6);
		arbol.add(e7);
		arbol.add(e8);
		arbol.add(e9);
		
		arbol.add(e10);
		arbol.add(e11);
		arbol.add(e12);
		
		
		
		Arboles.mostrarArbol(arbol);
		
	}

	//Método para mostrar el árbol
	private static void mostrarArbol(TreeSet<Empleado> arbol){
		for (Empleado e: arbol)
			System.out.println(e.toString()+"\n");
	}
	
}
