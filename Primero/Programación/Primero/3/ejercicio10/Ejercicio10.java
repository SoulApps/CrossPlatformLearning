package ejercicio10;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import ejercicio01.Teclado;
import ejercicio01.Teclado.TipoComparar;
import ejercicio01.Teclado.TipoEntre;
import ejercicio10.Vehiculo.Marca;

public class Ejercicio10 {

	public static void main(String[] args) {
		boolean salir = false; int resp;
		LinkedHashSet<Vehiculo> lista = new LinkedHashSet<Vehiculo>();
		
		lista.add(new Triciclo("12222",Marca.GLOBE)); lista.add(new Triciclo("12222", Marca.GLOBE));
		lista.add(new Triciclo("12222", Marca.SKIPE)); lista.add(new Triciclo("12222", Marca.SKIPE));
		lista.add(new Moto("55555",Marca.GLOBE,60,45)); lista.add(new Moto("55555",Marca.GLOBE,60,45)); 
		lista.add(new Coche("1234578r",Marca.SKIPE,50,100)); lista.add(new Coche("1234578r",Marca.SKIPE,50,100)); 
		
		do {
			System.out.println("---------------- Menú: ----------------");
			System.out.println("1. Insertar nuevo vehículo.");
			System.out.println("2. Ver vehículos insertados.");
			System.out.println("3. Mostrar cantidad de vehículos en lista.");
			System.out.println("4. Modificar estado de vehículo a motor.");
			System.out.println("5. Mostrar sublista al revés.");
			System.out.println("6. Clonar vehículo.");
			System.out.println("7. Salir");
			System.out.print("\n- Respuesta: ");
			resp = Teclado.leerIntEntre(1, 7, TipoEntre.AMBOS_INC);
			System.out.println("---------------------------------------");
			
			switch (resp){
			case 1:
				insertarVehiculo(lista);
				break;
			case 2:
				mostrarLista(lista);
				break;
			case 3:
				mostrarTamanioLista(lista);
				break;
			case 4:
				modificarVehiculoMotor(lista);
				break;
			case 5:
				mostrarSublistaAlReves(lista);
				break;
			case 6:
				clonarVehiculo(lista);
				break;
			case 7:
				Teclado.close();
				salir = true;
				break;
			}
		} while (!salir);
	}
	// ----------------------------- CASOS DEL MENU ---------------------------------
	public static void insertarVehiculo(LinkedHashSet<Vehiculo> lista){
		byte resp; boolean salir = false;
		
		do {
			System.out.println("------------- SubMenú: --------------");
			System.out.println("1.1 Añadir coche.");
			System.out.println("1.2 Añadir moto.");
			System.out.println("1.3 Añadir triciclo.");
			System.out.println("1.4 Salir");
			System.out.print("\n- Respuesta (1-4): ");
			resp = Teclado.leerByteEntre((byte)1, (byte)4, TipoEntre.AMBOS_INC);
			System.out.println("-------------------------------------");
			
			switch (resp){
			case 1:
				aniadirCoche(lista);
				break;
			case 2:
				aniadirMoto(lista);
				break;
			case 3:
				aniadirTriciclo(lista);
				break;
			case 4:
				salir = true;
				break;
			}
		} while (!salir);
	}
	
	public static void mostrarLista(LinkedHashSet<Vehiculo> lista){
		if (lista.isEmpty())
			System.out.println("- La lista está vacía.");
		else {
			System.out.println();
			for (Vehiculo v: lista)
				System.out.println(v.toString());
			System.out.println();
		}
	}
	
	public static void mostrarTamanioLista(LinkedHashSet<Vehiculo> lista){
		if (lista.isEmpty())
			System.out.println("- La lista está vacía.");
		else 
			System.out.printf("\n- La lista contiene %d vehículos.\n\n",lista.size());
	}
	
	public static void modificarVehiculoMotor(LinkedHashSet<Vehiculo> lista){
		int resp; boolean salir = false; Vehiculo vehiculo;
		ArrayList<Vehiculo> aList = new ArrayList<Vehiculo>(lista);
		if (!lista.isEmpty()){
			System.out.println("- Indique la posición de un vehiculo a motor de la siguiente lista: \n");
			for (Vehiculo v: lista)
				System.out.printf("+ %d - %s: matrícula = %s\n",aList.indexOf(v)+1, v.getClass().getSimpleName(), v.matricula);

			System.out.print("\n- Respuesta: ");
			resp = Teclado.leerIntEntre(1, lista.size(), TipoEntre.AMBOS_INC);
			vehiculo = aList.get(resp-1);
			
			if (vehiculo instanceof VehiculoMotor)
				do {
					System.out.println("------------- SubMenú: --------------");
					System.out.println("4.1 Arrancar vehiculo.");
					System.out.println("4.2 Parar vehiculo.");
					System.out.println("4.3 Subir marcha.");
					System.out.println("4.4 Bajar marcha.");
					System.out.println("4.5 Salir");
					System.out.print("\n- Respuesta (1-5): ");
					resp = Teclado.leerByteEntre((byte)1, (byte)5, TipoEntre.AMBOS_INC);
					System.out.println("-------------------------------------");
					
					switch (resp){
					case 1:
						arrancarVehiculo((VehiculoMotor)vehiculo);
						break;
					case 2:
						pararVehiculo((VehiculoMotor)vehiculo);
						break;
					case 3:
						subirMarcha((VehiculoMotor)vehiculo);
						break;
					case 4:
						bajarMarcha((VehiculoMotor)vehiculo);
						break;
					case 5:
						salir = true;
						break;
					}
				} while (!salir);
			 else 
				System.out.println("- Debe seleccionar un vehiculo a motor.");
		} else 
			System.out.println("- La lista está vacía.");
	}
	
	public static void mostrarSublistaAlReves(LinkedHashSet<Vehiculo> lista){
		int indice1, indice2;
		ArrayList<Vehiculo> aList = new ArrayList<Vehiculo>(lista);
		
		if (lista.isEmpty())
			System.out.println("- La lista está vacía");
		else {
			System.out.print("- Indique el índice de inicio de sublista: ");
			indice1 = Teclado.leerIntEntre(1, lista.size(), TipoEntre.AMBOS_INC);
			System.out.printf("- Indique el índice de fin de sumbista (<= %d): ",lista.size());
			indice2 = Teclado.leerIntEntre(indice1, lista.size(), TipoEntre.MIN_EXC_MAX_INC);
			
			System.out.println();
			for (int i = indice2-1; i >= indice1-1; i--)
				System.out.println(aList.get(i).toString());
		}
	}
	
	public static void clonarVehiculo(LinkedHashSet<Vehiculo> lista){
		ArrayList<Vehiculo> aList = new ArrayList<Vehiculo>(lista);
		int indice;
		if (lista.isEmpty())
			System.out.println("- La lista está vacía");
		else {
			System.out.print("- Indique el índice del vehículo que quiere clonar: ");
			indice = Teclado.leerIntEntre(1, lista.size(), TipoEntre.AMBOS_INC);
			
			lista.add((Vehiculo)aList.get(indice-1).clone());
			System.out.println("- Vehiculo agregado a la lista.");
		}
	}
	// ------------------ CASOS SUMBENU 1 (insertarVehiculo) ------------------------
	public static void aniadirCoche(LinkedHashSet<Vehiculo> lista){
		String matricula; Marca marca; int cilindrada, caballos;
		
		System.out.printf("\n- Indique la matricula del nuevo coche: ");
		matricula = Teclado.leerPalabra();
		System.out.print("- Indique cilindrada: ");
		cilindrada = Teclado.leerIntComparar(0, TipoComparar.MAYOR);
		System.out.print("- Indique caballos: ");
		caballos = Teclado.leerIntComparar(0, TipoComparar.MAYOR);
		
		if (Teclado.leerBoolean("Indique la marca: ", "Globe", "Skipe"))
			marca = Marca.GLOBE;
		else
			marca = Marca.SKIPE;
		
		lista.add(new Coche(matricula, marca, cilindrada, caballos));
		
		System.out.println("\n- Coche agregado a la lista.\n");
	}
	
	public static void aniadirMoto(LinkedHashSet<Vehiculo> lista){
		String matricula; Marca marca; int cilindrada, caballos;
		
		System.out.printf("\n- Indique la matricula de la nueva moto: ");
		matricula = Teclado.leerPalabra();
		System.out.print("- Indique cilindrada: ");
		cilindrada = Teclado.leerIntComparar(0, TipoComparar.MAYOR);
		System.out.print("- Indique caballos: ");
		caballos = Teclado.leerIntComparar(0, TipoComparar.MAYOR);
		
		if (Teclado.leerBoolean("Indique la marca: ", "Globe", "Skipe"))
			marca = Marca.GLOBE;
		else
			marca = Marca.SKIPE;
		
		lista.add(new Moto(matricula, marca, cilindrada, caballos));
		
		System.out.println("\n- Moto agregada a la lista.\n");
	}
	
	public static void aniadirTriciclo(LinkedHashSet<Vehiculo> lista){
		String matricula; Marca marca;
		
		System.out.printf("\n- Indique la matricula del nuevo triciclo: ");
		matricula = Teclado.leerPalabra();
		
		if (Teclado.leerBoolean("Indique la marca: ", "Globe", "Skipe"))
			marca = Marca.GLOBE;
		else
			marca = Marca.SKIPE;
		
		lista.add(new Triciclo(matricula, marca));
		System.out.println("\n- Triciclo agregado a la lista.\n");
	}
	// ------------------ CASOS SUMBENU 4 (modificarEstadoVehiculoMotor) ------------------------
	public static void arrancarVehiculo(VehiculoMotor v){
		if (!v.arrancado){
			v.arrancar();
			System.out.println("- Vehículo arrancado.");
		} else 
			System.out.println("- El vehículo ya estaba arrancado.");
	}
	public static void pararVehiculo(VehiculoMotor v){
		if (v.arrancado){
			v.parar();
			System.out.println("- Vehículo parado.");
		} else 
			System.out.println("- El vehículo ya estaba parado.");
	}
	public static void subirMarcha(VehiculoMotor v){
		if (v.marcha < v.MARCHA_MAX){
			v.subirMarcha();
			System.out.println("- Se ha aumentado la marcha del vehículo.");
		} else 
			System.out.println("- No se puede subir más marchas.");
	}
	public static void bajarMarcha(VehiculoMotor v){
		if (v.marcha > v.MARCHA_MIN){
			v.bajarMarcha();
			System.out.println("- Se ha bajado la marcha del vehículo");
		} else 
			System.out.println("- No se puede bajar más marchas.");
	}
}
