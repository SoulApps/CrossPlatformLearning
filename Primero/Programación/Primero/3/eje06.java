import java.util.Iterator;
import java.util.LinkedList;


public class Eje06 {

	public static void main(String[] args){
		int elec;
		boolean salir = false;
		
		LinkedList<Byte> pila = new LinkedList<Byte>();
		do {
			System.out.println("\n--\n1. Nueva pila\n2. Consultar elemento\n3. Añadir elemento\n4. Eliminar elemento\n5. Consultar toda la pila\n6. Salir\n--\n");
			elec = Lector.scanIntParam(1, 6);
			switch (elec) {
			case 1:
				newList(pila);
				break;
			case 2:
				consElem(pila);
				break;
			case 3:
				addElem(pila);
				break;
			case 4:
				remElem(pila);
				break;
			case 5:
				showList(pila);
				break;
			case 6:
				System.out.println("Fin del Programa.");
				salir = true;
				break;
			}
		} while (!salir);
	}

	private static void showList(LinkedList<Byte> pila) {
		Iterator<Byte> it = pila.descendingIterator();
		
		if(!pila.isEmpty()){
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
		else
			System.out.println("La lista esta vacia. Rellena primero.");
		
	}

	private static void remElem(LinkedList<Byte> pila) {
		if(!pila.isEmpty()){
			pila.removeLast();
		}
		else
			System.out.println("La lista esta vacia. Rellena primero.");
		
	}

	private static void addElem(LinkedList<Byte> pila) {
		byte b = Lector.scanGen('b', "Introduce numero a añadir:");
		pila.addLast(b);
		System.out.println("Elemento añadido.");
		
	}

	private static void consElem(LinkedList<Byte> pila) {
		if (!pila.isEmpty()) {
			byte b = Lector.scanGen('b', "Introduce elemento:");
			if (pila.contains(b))
				System.out.println("El numero SI esta contenido en la pila.");
			else
				System.out.println("El numero NO esta contenido en la pila.");
		}
		else
			System.out.println("La lista esta vacia. Rellena primero.");
		
	}

	private static void newList(LinkedList<Byte> pila) {
		if(pila.isEmpty())
			System.out.println("La lista esta vacia. Rellena primero.");
		else{
			pila.clear();
			System.out.println("Pila renovada.");
		}
		
		
	}
}
