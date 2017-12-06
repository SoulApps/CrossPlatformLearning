package ejercicio10;

import ejercicio10.Vehiculo.Marca;

public class Main {
	public static void main(String args[]){
		Coche c1 = new Coche("1234", Marca.GLOBE, 12, 111), c2;
		Moto m1 = new Moto("2222", Marca.SKIPE, 14, 444), m2;
		Triciclo t1 = new Triciclo("5432", Marca.SKIPE), t2;
		
		c2 = (Coche)c1.clone();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.equals(c2));
		System.out.println();
		
		c1.matricula="99999999";
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c2.equals(c1));
		System.out.println();
		
		m2 = (Moto)m1.clone();
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1.equals(m2));
		System.out.println();
		
		m1.matricula = "77777777777";
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m2.equals(m1));
		System.out.println();
		
		t2 = (Triciclo)t1.clone();
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t1.equals(t2));
		System.out.println();
		
		t1.matricula="3333333333333333333";
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t2.equals(t1));
		System.out.println();
	}
}
