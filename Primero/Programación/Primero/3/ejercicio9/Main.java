package ejercicio9;
import java.util.Date;

import ejercicio9.Munieca.Fecha;
import ejercicio9.Peluche.Tamanio;

public class Main {

	public static void main(String[] args) {
		
		Peluche p1 = null, p2;
		Sorpresa s1 = null;
		Munieca m1 = null, m2;
		Chucheria c1 = null, c2;
		
		try {
			m1 = new Munieca("barbi", "blanca", true, 2.3f, Fecha.FEBRERO);
			m2 = (Munieca)m1.clone();

			System.out.println(m1.toString());
			System.out.println(m2.toString());
			System.out.println(m1.equals(m2));
			
			m1.setFechaCompra(new Date());
			System.out.println();
			
			System.out.println(m1.toString());
			System.out.println(m2.toString());
			System.out.println(m1.equals(m2));
			
			System.out.println();
			m1.bebe.comer(5);
			
			System.out.println(m1.toString());
			System.out.println(m2.toString());
			System.out.println(m1.equals(m2));
			
			System.out.println();
			
			p1 = new Peluche("osito", "rosa", false, Tamanio.GRANDE);
			p2 = (Peluche) p1.clone();
			
			System.out.println(p1.toString());
			System.out.println(p2.toString());
			System.out.println(p1.equals(p2));
			
			p2.nombre = "pantera";
			p2.tamanio = Tamanio.PEQUENIO;
			
			System.out.println();
			
			System.out.println(p1.toString());
			System.out.println(p2.toString());
			System.out.println(p1.equals(p2));
			System.out.println();
			
			c1 = new Chucheria("Piruleta");
			c2 = (Chucheria)c1.clone();
			System.out.println(c1.toString());
			System.out.println(c2.toString());
			
			c1.nombre="caramelo";
			
			System.out.println(c1.toString());
			System.out.println(c2.toString());
			
			System.out.println();
			
			s1 = new Sorpresa("SURPRISE"); 
			System.out.println(s1.toString());
			
			s1 = new Sorpresa("SURPRISE1"); // Salta la excepcion porque no cumple el patron.
			System.out.println(s1.toString());
			
		} catch (NombreIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
