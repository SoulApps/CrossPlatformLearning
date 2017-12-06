package ejercicio07;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.PatternSyntaxException;

import ejercicio01.Teclado;
import ejercicio01.Teclado.TipoEntre;


public class Ejercicio07 {
	public static void main (String args[]){
		boolean salir = false; int resp;
		LinkedList<Empleado> listaEm = new LinkedList<Empleado>();
		
		do {
			System.out.println("---------------- Menú: ----------------");
			System.out.println("1. Mostrar la lista de empleados");
			System.out.println("2. Mostrar la lista de empleados al revés");
			System.out.println("3. Buscar nombre de empleado");
			System.out.println("4. Añadir empleado");
			System.out.println("5. Salir");
			System.out.print("\n- Respuesta: ");
			resp = Teclado.leerIntEntre(1, 5, TipoEntre.AMBOS_INC);
			System.out.println("---------------------------------------");
			
			switch (resp){
			case 1:
				mostrarLista(listaEm);
				break;
			case 2:
				mostrarListaAlReves(listaEm);
				break;
			case 3:
				buscarNombreEmpleado(listaEm);
				break;
			case 4:
				aniadirEmpleado(listaEm);
				break;
			case 5:
				Teclado.close();
				salir = true;
				break;
			}
		} while (!salir);
	}
	
	public static void mostrarLista(LinkedList<Empleado> listaEm){
		System.out.println();
		if (!listaEm.isEmpty())
			for (Empleado e:listaEm)
				System.out.println(e.toString());
		else 
			System.out.println("- La lista está vacía.\n");
	}
	
	public static void mostrarListaAlReves(LinkedList<Empleado> listaEm){
		Iterator <Empleado> it = listaEm.descendingIterator();
		System.out.println();
		if (!listaEm.isEmpty())
			while (it.hasNext())
				System.out.println(it.next().toString());
		else 
			System.out.println("- La lista está vacía.\n");
	}
	public static void buscarNombreEmpleado(LinkedList<Empleado> listaEm){
		String patron;
		
		if (!listaEm.isEmpty()){
			System.out.print("\n- Indique el patrón que quiere buscar: ");
			patron = Teclado.leerPalabra();
			System.out.println();
			
			try {
				for (Empleado e:listaEm)
					if(e.nombre.matches(patron))
						System.out.printf("En la posicion %d: %s\n",listaEm.indexOf(e),e.toString());
			} catch (PatternSyntaxException e){
				System.out.println("- Patrón inválido.\n");
			}
		}else 
			System.out.println("\n- La lista está vacía.\n");
	}
	public static void aniadirEmpleado(LinkedList<Empleado> listaEm){
		String nomEm, nom2; float sueldo; int posicion, posicionUltEm = 0;
		boolean ninguno = true;
		System.out.print("\n- Indique el nombre del nuevo empleado: ");
		nomEm = Teclado.leerPalabra();
		System.out.print("- Indique el sueldo del nuevo empleado: ");
		sueldo = Teclado.leerFloat();
		System.out.print("\n- ¿Delante de quien quiere añadirlo?: ");
		nom2 = Teclado.leerPalabra();
		
		for (Empleado e: listaEm)
			if(e.nombre.equals(nom2)) {
				if (ninguno){
					System.out.printf("\n- Se encontraron empleados con el nombre \"%s\" en las posiciones: \n", nom2);
					ninguno = false; 
				}
				System.out.printf("- %d\n",listaEm.indexOf(e)+1);
				posicionUltEm = listaEm.indexOf(e)+1;
			}
		
		if (!ninguno){
			System.out.print("\n- ¿En qué posición quieres agregar el nuevo empleado?: ");
			posicion = Teclado.leerIntEntre(0, posicionUltEm, TipoEntre.AMBOS_INC);
			listaEm.add(posicion-1, new Empleado(nomEm,sueldo));
		} else 
			listaEm.addLast(new Empleado(nomEm, sueldo));
		
		System.out.println("\n- Empleado agregado.\n");
	}
}
