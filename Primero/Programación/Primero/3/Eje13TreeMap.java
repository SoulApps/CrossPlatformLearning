import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import Bol7.Eje27Alimentacion;
import Bol7.Eje27Gato;
import Bol7.Eje27Loro;
import Bol7.Eje27Mascota;
import Bol7.Eje27Periquito;
import Bol7.Eje27Perro;
import Bol7.Lector;
import Bol7.Eje27Mascota.Cria;

public class Eje13TreeMap {

	public static void main(String[] args) {
		
		TreeMap<String, Eje27Mascota> mapa = new TreeMap<String, Eje27Mascota>();
		
		/*PRUEBA DE TREEMAP CON COMPARATOR ANONIMO PARA QUE LAS CLAVES SE ORDENEN DE FORMA INVERSA.
		TreeMap<String, Eje27Mascota> mapa = new TreeMap<String, Eje27Mascota>(
				new Comparator<String>() {
					@Override
				
					public int compare(String o1, String o2) {
						return o2.compareToIgnoreCase(o1);
					}
				});
		*/
		
		// Añadido automatico
		Eje27Perro p1 = new Eje27Perro("Rex", 100, "Pastor Aleman",
				new Cria[0], "H&S", 6);
		p1.fechaN = new Date(234323242342523L);
		Eje27Perro p2 = new Eje27Perro("Tara", 450, "Caniche", new Cria[1],
				"Herbal", 5);
		p2.crias[0] = p2.new Cria("Cria1", new Date());
		p2.fechaN = new Date(5463453452342342L);
		Eje27Gato g1 = new Eje27Gato("Michi", 234, "Rayado", new Cria[0], "H&S");
		Eje27Loro l1 = new Eje27Loro("Vince", 452, "Africano", new Cria[2],
				Eje27Alimentacion.CARNIVORA, true);
		l1.crias[0] = l1.new Cria("CriaL1", new Date());
		l1.crias[1] = l1.new Cria("CriaL2", new Date());
		Eje27Periquito pe1 = new Eje27Periquito("Piru", 1233, "Asiatico",
				new Cria[0], Eje27Alimentacion.HERBIVORA);
		Eje27Periquito pe2 = new Eje27Periquito("Rico", 1345, "Europeo",
				new Cria[0], Eje27Alimentacion.OMNIVORA);
		mapa.put(p1.cod, p1);
		mapa.put(g1.cod, g1);
		mapa.put(pe1.cod, pe1);
		mapa.put(p2.cod, p2);
		mapa.put(l1.cod, l1);
		mapa.put(pe2.cod, pe2);
		int elecc;
		do {
			System.out
					.println("--\n1. Nuevo Arbol\n2. Añadir animal\n3. Mostrar el mas pequeño\n4. Mostrar el mayor\n5. Mostrar arbol\n6. Mostrar subarbol\n7. Salir\n--");
			elecc = Lector.scanIntParam(1, 7);
			switch (elecc) {
			case 1:
				newTree(mapa);
				break;
			case 2:
				addAnim(mapa);
				break;
			case 3:
				showLittle(mapa);
				break;
			case 4:
				showBigger(mapa);
				break;
			case 5:
				showTree(mapa);
				break;
			case 6:
				showSubTree(mapa);
				break;
			case 7:
				System.out.println("Fin del programa");
				break;
			}
		} while (elecc != 7);

	}

	private static void newTree(TreeMap<String, Eje27Mascota> mapa) {
		if (mapa.isEmpty())
			System.out.println("El Arbol esta vacio. Rellena primero.");
		else {
			mapa.clear();
			System.out.println("Arbol renovado.");
		}

	}

	private static void addAnim(TreeMap<String, Eje27Mascota> mapa) {
		String nombre;
		double cuota;
		String raza;
		int numc;
		Eje27Mascota.Cria crias[];
		String nombrec;
		Date fechan = null;
		String f;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		boolean parsef = false;
		Eje27Mascota msc = new Eje27Periquito();
		int elecm;
		int elecmam;
		String champu;
		int agresividad;
		int al;
		Eje27Alimentacion alim = null;
		int eleca;
		boolean hablanh;
		Date fechaN = null;
		boolean p = false;
		System.out.println("Introduce nombre:");
		nombre = Lector.scanStringAll();
		System.out.println("Introduce cuota:");
		cuota = Lector.scanDoubleAll();
		System.out.println("Introduce raza:");
		raza = Lector.scanStringAll();
		System.out.println("Introduce numero de Crias:");
		numc = Lector.scanIntAll();
		crias = new Eje27Mascota.Cria[numc];
		for (int i = 0; i < numc; i++) {
			System.out.println("CRIA " + (i + 1) + "\nIntroduce nombre:");
			nombrec = Lector.scanStringAll();

			do {
				parsef = false;
				System.out.println("Introduce Fecha (dd/m/yyyy):");
				f = Lector.scanStringAll();
				try {
					fechan = format.parse(f);
				} catch (ParseException e) {
					parsef = true;
					System.out.println("Fecha no parseable. Reintroduce");
				}
			} while (parsef);

			Eje27Mascota.Cria cr = msc.new Cria(nombrec, fechan);

			crias[i] = cr;
		}
		System.out.println("Introduce tipo de Mascota:\n[1]Mamifero [2]Ave");
		elecm = Lector.scanIntParam(1, 2);
		if (elecm == 1) {// Mamifero
			System.out.println("Introduce Champu:");
			champu = Lector.scanStringAll();

			System.out.println("Introduce tipo de Mamifero\n[1]Perro [2]Gato");
			elecmam = Lector.scanIntParam(1, 2);

			if (elecmam == 1) {// Perro
				System.out.println("Introduce grado de agresividad:");
				agresividad = Lector.scanIntAll();

				Eje27Perro perro = new Eje27Perro(nombre, cuota, raza, crias,
						champu, agresividad);

				do {
					p = false;
					System.out
							.println("Introduce fecha de nacimiento dd/mm/yyyy:");
					try {
						fechaN = format.parse(Lector.scanStringAll());
					} catch (ParseException e) {
						System.out.println("Fecha no parseable.");
						p = true;
					}
				} while (p);

				perro.fechaN = fechaN;

				System.out.println(perro.toString());
				mapa.put(perro.cod, perro);

			} else {// Gato
				Eje27Gato gato = new Eje27Gato(nombre, cuota, raza, crias,
						champu);
				do {
					p = false;
					System.out
							.println("Introduce fecha de nacimiento dd/mm/yyyy:");
					try {
						fechaN = format.parse(Lector.scanStringAll());
					} catch (ParseException e) {
						System.out.println("Fecha no parseable.");
						p = true;
					}
				} while (p);

				gato.fechaN = fechaN;
				System.out.println(gato.toString());

				mapa.put(gato.cod, gato);
			}
		} else {// Ave
			System.out
					.println("Introduce tipo de Alimentacion:\n[1]Insectivora\n[2]Herbivora\n[3]Omnivora\n[4]Carnivora");
			al = Lector.scanIntParam(1, 4);

			switch (al) {
			case 1:
				alim = Eje27Alimentacion.INSECTIVORA;
				break;
			case 2:
				alim = Eje27Alimentacion.HERBIVORA;
				break;
			case 3:
				alim = Eje27Alimentacion.OMNIVORA;
				break;
			case 4:
				alim = Eje27Alimentacion.CARNIVORA;
				break;
			}

			System.out.println("Introduce tipo de Ave:\n[1]Loro [2]Periquito");
			eleca = Lector.scanIntParam(1, 2);

			if (eleca == 1) {// Loro
				System.out.println("Habla humano? [1]Si [2]No");
				hablanh = Lector.scanBoolean(Lector.scanIntParam(1, 2));

				Eje27Loro loro = new Eje27Loro(nombre, cuota, raza, crias,
						alim, hablanh);
				do {
					p = false;
					System.out
							.println("Introduce fecha de nacimiento dd/mm/yyyy:");
					try {
						fechaN = format.parse(Lector.scanStringAll());
					} catch (ParseException e) {
						System.out.println("Fecha no parseable.");
						p = true;
					}
				} while (p);

				loro.fechaN = fechaN;
				System.out.println(loro.toString());
				mapa.put(loro.cod, loro);
			} else {// Periquito
				Eje27Periquito periquito = new Eje27Periquito(nombre, cuota,
						raza, crias, alim);

				do {
					p = false;
					System.out
							.println("Introduce fecha de nacimiento dd/mm/yyyy:");
					try {
						fechaN = format.parse(Lector.scanStringAll());
					} catch (ParseException e) {
						System.out.println("Fecha no parseable.");
						p = true;
					}
				} while (p);

				periquito.fechaN = fechaN;
				System.out.println(periquito.toString());
				mapa.put(periquito.cod, periquito);
			}
		}

	}

	private static void showLittle(TreeMap<String, Eje27Mascota> mapa) {
		if (mapa.isEmpty())
			System.out.println("El Arbol esta vacio. Rellena primero.");
		else {
			System.out.println(mapa.get(mapa.firstKey()).toString());
		}

	}

	private static void showBigger(TreeMap<String, Eje27Mascota> mapa) {
		if (mapa.isEmpty())
			System.out.println("El Arbol esta vacio. Rellena primero.");
		else {
			System.out.println(mapa.get(mapa.lastKey()).toString());
		}

	}

	private static void showTree(TreeMap<String, Eje27Mascota> mapa) {
		if (mapa.isEmpty())
			System.out.println("El Arbol esta vacio. Rellena primero.");
		else {
			Set<String> claves = mapa.keySet();

			for (String s : claves) {
				System.out.println(mapa.get(s).toString());
			}
		}

	}

	private static void showSubTree(TreeMap<String, Eje27Mascota> mapa) {
		Eje27Mascota elementoA = null;
		Eje27Mascota elementoZ = null;
		String aux;
		int cont = 1;
		int a = 0;
		int z = 0;
		NavigableMap<String, Eje27Mascota> subarbol;
		Set<String> clavesA = mapa.keySet();
		if (mapa.isEmpty())
			System.out.println("El Arbol esta vacio. Rellena primero.");
		else {
			String c1 = Lector.scanGen('t', "Introduce primera Clave");
			Lector.scanStringAllNextLine();
			String c2 = Lector.scanGen('t', "Introduce segunda Clave");

			for (String s : clavesA) {
				if (mapa.get(s).cod.matches(c1)) {
					elementoA = mapa.get(s);
					a = cont;
				} else if (mapa.get(s).cod.matches(c2)) {
					elementoZ = mapa.get(s);
					z = cont;
				}
				cont++;
			}

			if (a > z) {
				System.out.println("Claves introducidas inversamente.");
				aux = c1;
				c1 = c2;
				c2 = aux;
			}

			if (elementoA == null || elementoZ == null)
				System.out.println("Error, alguna de las claves es erronea");

			else {
				subarbol = mapa.subMap(c1, true, c2, true); // Booleanos
															// significan que
															// tanto el elemento
															// A como el Z estan
															// incluidos en el
															// subset
				Set<String> claves = subarbol.keySet();
				for (String s : claves) {
					System.out.println(subarbol.get(s).toString());
				}
			}

		}

	}

}
