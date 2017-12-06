package ejercicio9;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;
import ejercicio9.Peluche.Tamanio;
public class Ejercicio9{
	public static void main(String[] args){
		int opcion;
		boolean salir=false;
		LinkedList<Sorpresa> cola=new LinkedList<Sorpresa>();
		do{
			System.out.println("MENÚ"
					+ "\n1. Nueva cola de sorpresas"
					+ "\n2. Regalar sorpresa"
					+ "\n3. Añadir sorpresa"
					+ "\n4. Clonar sorpresa"
					+ "\n5. Mostrar toda la cola"
					+ "\n6. Salir");
			System.out.print("OPCIÓN: ");
			opcion=Lectura.numeroInt();
			switch(opcion){
				case 1: nuevaColaDeSorpresas(cola); break;
				case 2: regalarSorpresa(cola); break;
				case 3: aniadirSorpresa(cola); break;
				case 4: clonarSorpresa(cola); break;
				case 5: mostrarTodalaCola(cola); break;
				case 6: salir=true; break;
				default: System.out.println("Error"); break;
			}
		}while(!salir);
	}
	
	//opcion 1
	public static void nuevaColaDeSorpresas(LinkedList<Sorpresa> cola){
		cola.clear();
		System.out.println();
	}
	
	//opcion 2
		public static void regalarSorpresa(LinkedList<Sorpresa> cola){
			Sorpresa s;
			if(!cola.isEmpty()){
				s=cola.removeFirst();
				System.out.println(s);
				if(s instanceof Munieca){
					((Munieca)s).bebe.despertar();
					System.out.println(((Munieca)s).bebe.toString());
					((Munieca)s).bebe.comer(0.5f);
					System.out.println(((Munieca)s).bebe.toString());
					((Munieca)s).bebe.dormir();
					System.out.println(((Munieca)s).bebe.toString());
				}
			}
			else{
				System.out.println("La lista esta vacia");
			}
			System.out.println();
		}
		
	//opcion 3
	public static void aniadirSorpresa(LinkedList<Sorpresa> cola){
		Random aleatorio= new Random();
		int aleat=aleatorio.nextInt(3);
		try {
			switch(aleat){
				case 0: cola.add(new Munieca("Cabezona","Rubia",true,0.25f,new Date())); break;
				case 1: cola.add(new Chucheria("Piruleta")); break;
				case 2: cola.add(new Peluche("Animalito","Azul",false,Tamanio.PEQUENIO)); break;
			}
		} catch (NombreIncorrectoException e) {
			e.getMessage();
		}
		System.out.println();
	}
	
	//opcion 4
	public static void clonarSorpresa(LinkedList<Sorpresa> cola){
		if(!cola.isEmpty()){
			cola.addLast((Sorpresa)cola.getFirst().clone());
		}
		else{
			System.out.println("La lista esta vacia");
		}
		System.out.println();
	}
	
	//opcion 5
	public static void mostrarTodalaCola(LinkedList<Sorpresa> cola){
		int i=1;
		if(!cola.isEmpty()){
			for (Sorpresa s : cola){
				System.out.println(" "+i+".-"+s);
				i++;
			}
		}
		else{
			System.out.println("La lista esta vacia");
		}
		System.out.println();
	}
}
