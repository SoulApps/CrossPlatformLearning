package ejercicio02;

import java.util.ArrayList;
import java.util.Iterator;

import boletinObjetos.Lapi;
import boletinObjetos.Lapi.Opcion;

public class ListaDecimales {
	public static void main(String[] args) {
		boolean seguir=true,op3=false;
		int opcion;
		Iterator<Float> it;
		ArrayList<Float> decimales=new ArrayList<Float>();
		
		decimales.add((float) 1.17);
		decimales.add((float) 2.17);		
		decimales.add((float) 3.17);
		it=decimales.iterator();
		
		while (seguir){
			System.out.println("\t\tMenu:");
			System.out.println("\t--------------------------");
			System.out.println("\t1.Mostrar Lista");
			System.out.println("\t2.Mostrar Siguiente");
			System.out.println("\t3.Eliminar Ultimo Mostrado");
			System.out.println("\t4.Salir");
			System.out.println("\t--------------------------");
			
			System.out.printf("\tOpcion:");
			opcion=Lapi.numInt(1, 4, Opcion.AMBOS_INCLUIDOS);
			System.out.println();
			
			switch (opcion) {
			case 1:
				if(!decimales.isEmpty())
					for (Float f : decimales) 
						System.out.println(f);
					
				else
					System.out.println("La lista esta vacia");
				break;
			case 2:
				if(it.hasNext()){
					System.out.println(it.next());
					op3=true;
				}else{
					it=decimales.iterator();
					if(it.hasNext()){
						System.out.println(it.next());
						op3=true;
					}else
						System.out.println("La lista esta vacia");
				}
				break;
			case 3:
				if(!decimales.isEmpty()){
					if(op3){
						it.remove();
						op3=false;
					}else
						System.out.println("Primero tienes que mostrar alguno");
				}else
					System.out.println("La lista esta vacia");
				break;
			case 4:
				seguir=false;
				break;
			}
			System.out.println();		
		}
	}
}
