package ejercicio13;

import java.util.Comparator;
import java.util.TreeSet;

import ejercicio01.Teclado;
import ejercicio01.Teclado.TipoEntre;

public class Ejercicio13_VAnonima {
	public static void main(String[] args) {

		TreeSet<Mascota> arbol = new TreeSet<Mascota>(new Comparator<Mascota>(){
				public int compare(Mascota m1, Mascota m2){
					return m1.getCodigo().compareTo(m2.getCodigo());
				}
			}
		);
		boolean salir = false;
		int resp;
		
		do {
			System.out.println("------------------------------- Menú: -------------------------------");
			System.out.println("1. Nuevo árbol.");
			System.out.println("2. Añadir animal.");
			System.out.println("3. Mostrar el más pequeño.");
			System.out.println("4. Mostrar el mayor.");
			System.out.println("5. Mostrar árbol.");
			System.out.println("6. Mostrar subárbol.");
			System.out.println("7. Salir.");
			System.out.print("\n- Respuesta: ");
			resp = Teclado.leerIntEntre(1, 7, TipoEntre.AMBOS_INC);
			System.out.println("---------------------------------------------------------------------");

			switch (resp){
			case 1: nuevoArbol(arbol); break;
			case 2: aniadirAnimal(arbol); break;
			case 3:	mostrarElMasPeque(arbol); break;
			case 4:	mostrarMayor(arbol); break;
			case 5:	mostrarArbol(arbol); break;
			case 6:	mostrarSubarbol(arbol); break;
			case 7:	
				Teclado.close(); 
				salir = true; 
				break;
			}
		} while (!salir);
	}
	// ------------------------- Opciones Menu: --------------------------------
	public static void nuevoArbol(TreeSet<Mascota> arbol){
		if (arbol.isEmpty())
			System.out.println("- El árbol ya está vacío.");
		else {
			arbol.clear();
			System.out.println("- Nuevo árbol listo para usar.");
		}
	}
	public static void aniadirAnimal(TreeSet<Mascota> arbol){
		int resp; boolean salir = false;
		do {
			System.out.println("------------------------------- SubMenú: -------------------------------");
			System.out.println("1. Añadir loro.");
			System.out.println("2. Añadir perro.");
			System.out.println("3. Añadir gato.");
			System.out.println("4. Añadir periquito.");
			System.out.println("5. Salir.");
			System.out.print("\n- Respuesta: ");
			resp = Teclado.leerIntEntre(1, 5, TipoEntre.AMBOS_INC);
			System.out.println("---------------------------------------------------------------------");
			
			switch (resp){
			case 1: aniadirLoro(arbol); break;
			case 2: aniadirPerro(arbol); break;
			case 3:	aniadirGato(arbol); break;
			case 4:	aniadirPeriquito(arbol); break;
			case 5:	
				salir = true; 
				break;
			}
		} while (!salir);
	}
	public static void mostrarElMasPeque(TreeSet<Mascota> arbol){
		if (arbol.isEmpty())
			System.out.println("- El árbol está vacío.");
		else 
			System.out.printf("- El animal más pequeño es: %s\n", arbol.first().toString());
	}
	public static void mostrarMayor(TreeSet<Mascota> arbol){
		if (arbol.isEmpty())
			System.out.println("- El árbol está vacío.");
		else 
			System.out.printf("- El animal más grande es: %s\n", arbol.last().toString());
	}
	public static void mostrarArbol(TreeSet<Mascota> arbol){
		if (arbol.isEmpty())
			System.out.println("- El árbol está vacío.");
		else 
			for (Mascota m: arbol)
				System.out.println(m.toString()+"\n");
	}
	public static void mostrarSubarbol(TreeSet<Mascota> arbol){
		String clave, clave2;
		Mascota m1 = null, m2 = null;
		if (arbol.isEmpty())
			System.out.println("- El árbol está vacío.");
		else {
			System.out.print("- Introduzca la clave del primer animal: ");
			clave = Teclado.leerPalabra();
			System.out.print("- Introduzca la clave del segundo animal: ");
			clave2 = Teclado.leerPalabra();
			
			System.out.println();
			for (Mascota m: arbol)
				if (m.getCodigo().equalsIgnoreCase(clave))
					m1 = m;
				else if (m.getCodigo().equalsIgnoreCase(clave2))
					m2 = m;
			
			if (m1 != null & m2 != null)
				for (Mascota m:arbol.subSet(m1, m2))
					System.out.println(m.toString() + "\n");
			else 
				System.out.println("- Los animales no se encontraron en el árbol.");
		}
	}
	
	// ---------------------------- Opciones submenu (añadir animal): -----------------------------------
	public static void aniadirLoro(TreeSet<Mascota> arbol){
		Loro loro = new Loro();
		arbol.add(loro);
		System.out.println("- Loro agregado.");
	}
	public static void aniadirPerro(TreeSet<Mascota> arbol){
		Perro perro = new Perro();
		arbol.add(perro);
		System.out.println("- Perro agregado.");
	}
	public static void aniadirGato(TreeSet<Mascota> arbol){
		Gato gato = new Gato();
		arbol.add(gato);
		System.out.println("- Gato agregado.");
	}
	public static void aniadirPeriquito(TreeSet<Mascota> arbol){
		Periquito peri = new Periquito();
		arbol.add(peri);
		System.out.println("- Periquito agregado.");
	}

}
