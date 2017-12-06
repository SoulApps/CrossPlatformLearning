package ejercicio26;

import ejercicio26.Vehiculo.Marca;


public class Main {

	public static void main(String[] args) {
		
	
		Coche c = new Coche ("23522F", Marca.GLOBE, 150, 500);
		Coche c2 = new Coche ();
		Coche c3;
		Moto m = new Moto ("56787R", Marca.SKIPE, 50 , 100);
		Moto m2 = new Moto ();
		Moto m3;
		Triciclo t = new Triciclo("78543X", Marca.GLOBE);
		Triciclo t2 = new Triciclo();
		Triciclo t3;
		
		
		System.out.println(t.toString());
		
		t3 = (Triciclo) t.clone();						//Triciclo
		
		System.out.println(t.equals(t3));
		
		System.out.println(t2.toString());
		
		System.out.println("-------------------");
		
		//-------------------------
						
		System.out.println(c.toString());			//Coche		
		
		c.arrancar();
		
		c.subir_marcha();
		
		System.out.println(c.toString());
		
		c3 = (Coche) c.clone();
		
		System.out.println(c.equals(c3));
		
		System.out.println("-------------------");
		
		//------------------------
		
		System.out.println(m.toString());

		m.arrancar();
		
		m.subir_marcha();					//Moto
		
		m.subir_marcha();	
		
		m.bajar_marcha();
		
		System.out.println(m.toString());
		
		m3 = (Moto) m.clone();
		
		System.out.println(m.equals(m3));
		
		//-----------------

		System.out.println("-------------------");
		
		c.puntoMuerto();
		
		System.out.println(c.toString());
		
		c.marchaAtras();
		
		System.out.println(c.toString());
	}

}
