package ejercicio06;

import java.util.ArrayList;
import java.util.ListIterator;

import ejercicio01.Teclado;
import ejercicio01.Teclado.TipoEntre;

public class Ejercicio06 {

	public static void main(String[] args) {
		ArrayList<Empleado> listaEm = new ArrayList<Empleado>();
		boolean salir=false;
		byte resp;
		
		do {
			System.out.println("--------------- Menú: ---------------");
			System.out.println("1. Nueva lista de empleados");
			System.out.println("2. Insertar un empleado nuevo");
			System.out.println("3. Eliminar un empleado");
			System.out.println("4. Modificar un empleado");
			System.out.println("5. Consultar un empleado");
			System.out.println("6. Consultar lista de empleados");
			System.out.println("7. Mostrar el número de empleados introducidos");
			System.out.println("8. Clonar un empleado");
			System.out.println("9. Salir");
			System.out.print("\n- Respuesta (1-9): ");
			resp = Teclado.leerByteEntre((byte)1, (byte)9, TipoEntre.AMBOS_INC);
			System.out.println("-------------------------------------");
			
			switch (resp){
			case 1:
				nuevaListaEmpleados(listaEm);
				break;
			case 2:
				insertarEmpleadoNuevo(listaEm);
				break;
			case 3:
				eliminarEmpleado(listaEm);
				break;
			case 4:
				modificarEmpleado(listaEm);
				break;
			case 5:
				consultarEmpleado(listaEm);
				break;
			case 6:
				consultarListaEmpleados(listaEm);
				break;
			case 7: 
				mostrarNumeroEmpleadosIntrod(listaEm);
				break;
			case 8: 
				clonarEmpleado(listaEm);
				break;
			case 9: 
				Teclado.close();
				salir = true;
				break;
			}
		} while (!salir);
	}
	
	// **************************** Casos del MENU ****************************
	public static void nuevaListaEmpleados(ArrayList<Empleado> listaEm){
		listaEm.clear();
		System.out.println("\n - Lista vaciada.\n");
	}
	
	public static void insertarEmpleadoNuevo(ArrayList<Empleado> listaEm){
		boolean salir=false;
		byte resp;
		
		do {
			System.out.println("------------- SubMenú: --------------");
			System.out.println("2.1 Añadir un empleado");
			System.out.println("2.2 Añadir un empleado en una posicion");
			System.out.println("2.3 Salir");
			System.out.print("\n- Respuesta (1-3): ");
			resp = Teclado.leerByteEntre((byte)1, (byte)3, TipoEntre.AMBOS_INC);
			System.out.println("-------------------------------------");
			
			switch (resp){
			case 1:
				aniadirEmpleado(listaEm);
				break;
			case 2:
				aniadirEmpleadoPosicion(listaEm);
				break;
			case 3:
				salir = true;
				break;
			}
				
		} while(!salir);
	}
	
	public static void eliminarEmpleado(ArrayList<Empleado> listaEm){
		boolean salir = false;
		byte resp;
		if (!listaEm.isEmpty())
			do {
				System.out.println("------------- SubMenú: --------------");
				System.out.println("3.1 Eliminar por posicion");
				System.out.println("3.2 Eliminar por contenido");
				System.out.println("3.3 Salir");
				System.out.print("\n- Respuesta (1-3): ");
				resp = Teclado.leerByteEntre((byte)1, (byte)3, TipoEntre.AMBOS_INC);
				System.out.println("-------------------------------------");
				
				switch (resp){
				case 1:
					eliminarPorPosicion(listaEm);
					break;
				case 2:
					eliminarPorContenido(listaEm);
					break;
				case 3:
					salir = true;
					break;
				}
			} while (!salir);
		else 
			System.out.print("\n- La lista está vacía.\n\n");
		} 
	public static void modificarEmpleado(ArrayList<Empleado> listaEm){
		boolean salir = false; byte resp; int posicion;
		if (!listaEm.isEmpty())
			do {
				System.out.println("------------- SubMenú: --------------");
				System.out.println("4.1 Incrementar horas trabajadas en 1");
				System.out.println("4.2 Incrementar horas trabajadas");
				System.out.println("4.3 Agregar nueva venta realizada");
				System.out.println("4.4 Aumentar productividad");
				System.out.println("4.5 Salir");
				System.out.print("\n- Respuesta (1-5): ");
				resp = Teclado.leerByteEntre((byte)1, (byte)5, TipoEntre.AMBOS_INC);
				System.out.println("-------------------------------------");
				
				if (resp != 5){
					System.out.print("\n- Introduzca la posición del empleado que quiere modificar: ");
					posicion = Teclado.leerInt();
					if (posicion >= 0 && posicion < listaEm.size())
							switch (resp){
							case 1:
								incrementarHorasEn1(listaEm, posicion);
								break;
							case 2:
								incrementarHoras(listaEm, posicion);
								break;
							case 3:
								agregarNuevaVenta(listaEm, posicion);
								break;
							case 4:
								aumentarProductividad(listaEm, posicion);
								break;
							}
						else 
							System.out.printf("\n- No existe el usuario en la posicion %d\n\n", posicion);
				} else 
					salir = true;
			} while(!salir);
		else 
			System.out.print("\n- La lista está vacía.\n\n");
	}
	public static void consultarEmpleado(ArrayList<Empleado> listaEm){
		int posicion;
		if (!listaEm.isEmpty()){
			System.out.print("\n- Introduzca la posición del empleado que quiere consultar: ");
			posicion = Teclado.leerInt();
			
			if (posicion >= 0 && posicion < listaEm.size())
				System.out.printf("\nEmpleado: %s\n",listaEm.get(posicion).toString());
			else 
				System.out.printf("\n- No existe el empleado en la posicion %d\n\n", posicion);
		} else 
				System.out.print("\n- La lista está vacía.\n\n");
	}
	public static void consultarListaEmpleados(ArrayList<Empleado> listaEm){
		System.out.println();
		if (!listaEm.isEmpty())
			for (Empleado u:listaEm){
				System.out.println(u.toString());
			}
		else 
			System.out.print("- La lista está vacía.\n\n");
	}
	public static void mostrarNumeroEmpleadosIntrod(ArrayList<Empleado> listaEm){
		System.out.printf("\n- La lista tiene %d elementos.\n\n", listaEm.size());
	}
	public static void clonarEmpleado(ArrayList<Empleado> listaEm){
		int posicion;
		if (!listaEm.isEmpty()){
			System.out.print("\n- Introduzca la posición del empleado que quiere clonar: ");
			posicion = Teclado.leerInt();
			
			if (posicion >=0 && posicion < listaEm.size()){
				listaEm.add((Empleado)listaEm.get(posicion).clone());
				System.out.println("- Empleado clonado y agregado a la lista.\n");
			} else 
				System.out.println("- Posicion incorrecta.\n");
		}else 
			System.out.print("\n- La lista está vacía.\n\n");
	}
	
	// ************************** Casos del SubMenu2 **************************
	public static void aniadirEmpleado(ArrayList<Empleado> listaEm){
		String nomEm; float sueldoEm;
		
		System.out.print("\n- Indique el nombre del nuevo empleado: ");
		nomEm = Teclado.leerPalabra();
		System.out.print("- Indique el sueldo del nuevo empleado: ");
		sueldoEm = Teclado.leerFloat();
		
		listaEm.add(new Empleado(nomEm,sueldoEm));
		System.out.println("- Empleado agregado.\n");
	}
	public static void aniadirEmpleadoPosicion(ArrayList<Empleado> listaEm){
		String nomEm; float sueldoEm; int posicion;
		if (!listaEm.isEmpty()){
			System.out.print("\n- Indique el nombre del nuevo empleado: ");
			nomEm = Teclado.leerPalabra();
			System.out.print("- Indique el sueldo del nuevo empleado: ");
			sueldoEm = Teclado.leerFloat();
			System.out.print("- Indique la posición en la que lo desea añadir: ");
			posicion = Teclado.leerInt();
			
			if (posicion >=0 && posicion <= listaEm.size()){
				listaEm.add(posicion, new Empleado(nomEm, sueldoEm));
				System.out.println("- Empleado agregado.\n");
			} else 
				System.out.println("- Posicion incorrecta.\n");
		} else {
			System.out.print("- La lista está vacía, por tanto:\n");
			aniadirEmpleado(listaEm);
		}
	}
	// ************************** Casos del SubMenu3 **************************
	public static void eliminarPorPosicion(ArrayList<Empleado> listaEm){
		int posicion;
		System.out.print("\n- Indique la posición en la lista del empleado que quiere borrar: ");
		posicion = Teclado.leerInt();
		
		if (posicion>= 0 && posicion < listaEm.size()){
			listaEm.remove(posicion);
			System.out.println("- Elemento borrado.\n");
		} else 
			System.out.println();
	}
	public static void eliminarPorContenido(ArrayList<Empleado> listaEm){
		String nomEm; ListIterator<Empleado> it = listaEm.listIterator();
		System.out.print("\n- Indique el nombre del empleado que quiere borrar de la lista: ");
		nomEm = Teclado.leerPalabra();
		
		do {
			if (nomEm.equalsIgnoreCase(it.next().nombre)){
				it.remove();
				System.out.println("- Elemento borrado.");
			}
		} while (it.hasNext());
		System.out.println();
	}
	// ************************** Casos del SubMenu4 **************************
	public static void incrementarHorasEn1(ArrayList<Empleado> listaEm, int posicion){
		System.out.println("- Horas incrementadas.\n");
		System.out.printf("Empleado antiguo: %s",listaEm.get(posicion).toString());
		System.out.println();
		listaEm.get(posicion).incrementarHorasTrabajadas();
		System.out.printf("Empleado modificado: %s\n",listaEm.get(posicion).toString());
	}
	public static void incrementarHoras(ArrayList<Empleado> listaEm, int posicion){
		int inc;
		System.out.print("- ¿Cuántas horas quiere incrementar?: ");
		inc = Teclado.leerInt();
		if (inc > 1){
			System.out.println("- Horas incrementadas.\n");
			System.out.printf("Empleado antiguo: %s",listaEm.get(posicion).toString());
			System.out.println();
			listaEm.get(posicion).incrementarHorasTrabajadas(inc);
			System.out.printf("Empleado modificado: %s",listaEm.get(posicion).toString());
		}
		System.out.println();
	}
	public static void agregarNuevaVenta(ArrayList<Empleado> listaEm, int posicion){
		float importe; int numVenta;
		
		System.out.print("- Indique el id de la nueva venta: ");
		numVenta = Teclado.leerInt();
		System.out.print("- Indique el importe de la nueva venta: ");
		importe = Teclado.leerFloat();
		if (importe >=0 && importe > 0){
			listaEm.get(posicion).ventaRealizada(numVenta, importe);
			System.out.println("- Venta agregada.\n");
		}
	}
	public static void aumentarProductividad(ArrayList<Empleado> listaEm, int posicion){
		int inc;
		System.out.print("- Indique el porcentaje de aumento de productividad: ");
		inc = Teclado.leerInt();
		if (inc > 0){
			System.out.println("- Productividad incrementada.\n");
			System.out.printf("Empleado antiguo: %s",listaEm.get(posicion).toString());
			System.out.println();
			listaEm.get(posicion).aumentoProductividad(inc);
			System.out.printf("Empleado antiguo: %s",listaEm.get(posicion).toString());
		}
		System.out.println();
	}
}
