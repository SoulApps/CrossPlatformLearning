package alala;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

import Ejercicio27.Animales;
import Ejercicio27.Ave.Alimentacion;
import Ejercicio27.Gato;
import Ejercicio27.Loro;
import Ejercicio27.Periquito;
import Ejercicio27.Perro;
import Objetos.Teclado;
import Objetos.Teclado.Modo;
import Objetos.Teclado.Opcion;

public class MapaAnimal {
	public static void main(String[] args) {
		HashMap<String,Animales> mapa= new HashMap<String,Animales>();
		boolean salir=false;
		
		Animales a1=new Perro("a1",2,"aa","champu",2),a2=new Perro("a2",3,"ab","champu",3),a3=new Gato("a2",3,"ab","champu");
		a1.getHijos().add(new Perro("hijo1",2,"ab","Champu",4)); //hijo
		mapa.put(a1.codigo(), a1);
		mapa.put(a2.codigo(), a2);
		mapa.put(a3.codigo(), a3);
		do {
			System.out.println("--------------------Menú------------------");
			System.out.println("\t1.Nuevo Mapa\n"
							+ "\t2.Añadir animal\n"
							+ "\t3.Eliminar animal\n"
							+ "\t4.Número total de animales\n"
							+ "\t5.Mostrar mapa\n"
							+ "\t6.Sorteo\n"
							+ "\t7.Buscar una mascota y hacerla hablar. Comprobar si esta enfadada.\n"
							+ "\t8.Clonar una mascota con sus crias\n"
							+ "\t9.Salir");
			switch (Teclado.byteNum(1, 9, Opcion.AMBOSINCLUIDOS)) {
			case 1:
				mapa.clear();
				System.out.println("Mapa reiniciado...");
				break;
			case 2:
				introducirAnimal(mapa);
				break;
			case 3:
				eliminarAnimal(mapa);
				break;
			case 4:
				System.out.println(numeroTotalAnimales(mapa));
				break;
			case 5:
				mostrarMapa(mapa);
				break;
			case 6:
				loteria(mapa);
				break;
			case 7:
				hacerHablar(mapa);
				break;
			case 8:
				clonarMascota(mapa);
				break;
			case 9:
				salir=true;
				break;
			}
		} while (!salir);
	}
	// --------------------------- 2. AÑADIR ANIMAL ---------------------------------
	public static void introducirAnimal(HashMap<String,Animales> mapa){
		byte tipoAnimal,especie; 
		String nombre,raza,champu;
		int cuota;
		Animales animal;
		boolean habla=false;
		Alimentacion alimentacion=null;
		
		System.out.println("¿Qué tipo de animal desea añadir?");
		System.out.println("\t1.Mamífero\n\t2.Ave");
		tipoAnimal=Teclado.byteNum(1,2,Opcion.AMBOSINCLUIDOS);
		System.out.println("\t--Especies disponibles--");
		if(tipoAnimal==1){
			System.out.println("\t1.Perro\n\t2.Gato");
			especie=Teclado.byteNum(1,2,Opcion.AMBOSINCLUIDOS);
		}else{
			System.out.println("\t1.Loro\n\t2.Periquito");
			especie=Teclado.byteNum(1,2,Opcion.AMBOSINCLUIDOS);
		}
		
		
		System.out.print("Nombre: ");
		nombre= Teclado.cadena();
		System.out.print("Raza: ");
		raza= Teclado.cadena();
		System.out.print("Cuota mensual: ");
		cuota=Teclado.intNum(0, Modo.MAYORIGUAL);
		
		switch(tipoAnimal){
		case 1:     // MAMÍFERO
			System.out.print("Champú: ");
			champu= Teclado.cadena();
			
			switch(especie){
			case 1: //PERRO
				System.out.print("Grado de agresividad: ");
				animal=new Perro(nombre,cuota,raza,champu,Teclado.intNum(0, 100, Opcion.AMBOSINCLUIDOS));
				mapa.put(animal.codigo(),animal);
				break;
			case 2: //GATO
				animal=new Gato(nombre,cuota,raza,champu);
				mapa.put(animal.codigo(),animal);
				break;
			}
			
			break;
		case 2:   // AVE 
			System.out.println("¿Qué tipo de alimentación tiene? \n\t1.Carnivoro\n\t2.Herbivoro\n\t3.Insectivoro\n\t4.Omnivoro");
			switch(Teclado.byteNum(1, 4, Opcion.AMBOSINCLUIDOS)){
			case 1:
				alimentacion=Alimentacion.CARNIVORA;
				break;
			case 2:
				alimentacion=Alimentacion.HERBIVORA;
				break;
			case 3:
				alimentacion=Alimentacion.INSECTIVORA;
				break;
			case 4:
				alimentacion=Alimentacion.OMNIVORA;
				break;
			}
			switch(especie){
			case 1: // LORO 
				System.out.println("¿Habla? \n\t1.Sí\n\t2.No");
				if(Teclado.byteNum(1,2,Opcion.AMBOSINCLUIDOS)==1)
					habla=true;
				
				animal=new Loro(nombre,cuota,raza,alimentacion,habla);
				mapa.put(animal.codigo(), animal);
				break;
			case 2: // PERIQUITO
				animal= new Periquito(nombre,cuota,raza,alimentacion);
				mapa.put(animal.codigo(),animal);
				break;
			}
		}
	}
	// ---------------------------3. ELIMINAR ANIMAL---------------------------
	public static void eliminarAnimal(HashMap<String,Animales> mapa){
		String clave;
		
		if(!mapa.isEmpty()){
			System.out.println("Introduce la clave del animal a eliminar");
			clave=Teclado.cadena();
			if(mapa.remove(clave)!=null){
				System.out.println("Animal eliminado...");
			}else
				System.out.println("No existe ningún animal con esa clave");
		}else
			System.out.println("El mapa está vacío");
	}
	
	
	// ---------------------------4. MOSTRAR TOTAL ANIMALES--------------------
	
	public static String numeroTotalAnimales(HashMap<String,Animales> mapa){
		int numCrias=0,numPerros=0,numGatos=0,numPeriquitos=0,numLoros=0;
		Iterator<Entry<String,Animales>> it= mapa.entrySet().iterator();
		Animales animal;
		while(it.hasNext()){
			animal=(Animales) it.next().getValue();
			numCrias+=animal.getHijos().size();
			if(animal instanceof Perro)
				numPerros++;
			else if(animal instanceof Gato)
				numGatos++;
			else if(animal instanceof Loro)
				numLoros++;
			else if(animal instanceof Periquito)
				numPeriquitos++;
		}
			
		
		return String.format("\t-Perros totales: %d\n\t-Gatos totales: %d\n\t-Loros totales: %d\n\t-Periquitos totales: %d\n\tNúmero de crías totales: %d", numPerros,numGatos,numLoros,numPeriquitos,numCrias);
	}
	
	
	// ---------------------------5.MOSTRAR MAPA ------------------------------
	public static void mostrarMapa(HashMap<String,Animales> mapa){
		ArrayList<Animales> animales= new ArrayList<Animales>(mapa.values()); 
		int i;
		boolean salir=false;
		// ITERATOR para detras y toString en Animales(hijos)
		if(!mapa.isEmpty()){
			do {
				System.out.println("\t1-Mostrar hacia delante\n\t2-Mostrar hacia atrás\n\t3-Salir");
				switch (Teclado.byteNum(1, 3, Opcion.AMBOSINCLUIDOS)) {
				case 1: // HACIA DELANTE
					for (Animales a : animales)
						System.out.println("+"+a);
					System.out.println();
					break;
				case 2: //HACIA DETRAS
					for (i = animales.size()-1; i >= 0; i--)
						System.out.println("+"+animales.get(i));
					System.out.println();
					break;
				case 3:
					salir = true;
				}
			} while (!salir);

		}else
			System.out.println("El mapa está vacío");
		
		
	}
	
	//-------------------------6. SORTEO------------------------------------
	public static void loteria(HashMap<String,Animales> mapa){
		class Loteria{
			
			ArrayList<Animales> animales;
			
			public Loteria(HashMap<String,Animales> mapa){
				animales= new ArrayList<Animales>(mapa.values());
			}
		
			public String animalPremiado(){
				int num=new Random().nextInt(animales.size());
				
				return animales.get(num).codigo();
			}
		}
		Loteria r= new Loteria(mapa);
		Animales animal= mapa.get(r.animalPremiado());
		animal.setCuotaMensual((int) (animal.getCuotaMensual()*0.9F));
		System.out.printf("La cuota de %s ha sido disminuida...%n",animal.codigo());
		
	}
	//-------------------------7. BUSCAR MASCOTA Y HABLAR-------------------
	
	public static void hacerHablar(HashMap<String,Animales> mapa){
		String codigo;
		
		if(!mapa.isEmpty()){
			System.out.print("Introduzca el código del animal: ");
			codigo=Teclado.cadena();
			if(mapa.containsKey(codigo)){
				System.out.println(codigo+" dijo: "+mapa.get(codigo).hablar());
				System.out.println(mapa.get(codigo).isEnfadado()?codigo+" está enfadado":codigo+" no está enfadado");
			}else
				System.out.println("No existe ningún animal con este código.");
		}else
			System.out.println("El mapa está vacío.");
	}
	//------------------------8.CLONAR UNA MASCOTA--------------------------
	
	public static void clonarMascota(HashMap<String,Animales> mapa){
		String codigo;
		Animales animal;
		
		if(!mapa.isEmpty()){
			System.out.println("Introduzca el código del animal");
			codigo=Teclado.cadena();
			if(mapa.containsKey(codigo)){
				animal=(Animales) mapa.get(codigo).clone();
				mapa.put(animal.codigo(), animal);
			}else
				System.out.println("No existe ningún animal con este código");				
		}else
			System.out.println("El mapa está vacio");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
