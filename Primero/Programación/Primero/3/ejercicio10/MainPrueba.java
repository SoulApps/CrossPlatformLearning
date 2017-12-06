package ejercicio10;

import java.util.LinkedHashSet;

import ejercicio10.Vehiculo.Marca;

public class MainPrueba {

	public static void main(String[] args) {
		LinkedHashSet<Vehiculo> lista = new LinkedHashSet<Vehiculo>();
		
		lista.add(new Triciclo("12354r",Marca.GLOBE)); 
		lista.add(new Triciclo("12222", Marca.SKIPE));
		lista.add(new Triciclo("12222", Marca.GLOBE));
		lista.add(new Triciclo("12222", Marca.GLOBE));
		lista.add(new Moto("55555",Marca.GLOBE,60,45)); 
		lista.add(new Coche("1234578r",Marca.SKIPE,50,100)); 
		
		for (Vehiculo v: lista)
				System.out.println(v.hashCode());

	}

}
