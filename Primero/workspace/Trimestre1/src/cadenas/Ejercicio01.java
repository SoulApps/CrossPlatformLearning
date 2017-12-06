package cadenas;

public class Ejercicio01 {

	public static void main(String[] args) {

		String a = "True", b = "añc", c = "aaaaaa", d = "a1", e = "a", f = "299", g = "923456789", h = "12345678A",
				i = "Alejandro", j = "áb", k = "sa2_-.fa@asdig.com";

		// a
		System.out.print("a)");
		if(a.matches("True"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		// b
		System.out.print("b)");
		if(b.matches("[\\wÑñ]{3}"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		// c
		System.out.print("c)");
		if(c.matches("[^ñzx]{5,}"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		// d
		System.out.print("d)");
		if(d.matches("\\D.*"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		// e
		System.out.print("e)");
		if(e.matches("[^b]*"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		// f
		System.out.print("f)");
		if(f.matches("[1-2]?[0-9]{1,2}"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		// g
		System.out.print("g)");
		if(g.matches("[6-9]{1}\\d{8}"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		// h
		System.out.print("h)");
		if(h.matches("\\d{8}[A-Z]"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		// i
		System.out.print("i)");
		if(i.matches("[A-Z][a-z]+"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		// j
		System.out.print("j)");
		if(j.matches("[aeiouAEIOUáéíóúÁÉÍÓÚ][a-zA-Z&&[^aeiouAEIOUáéíóúÁÉÍÓÚ]]*"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		// k
		System.out.print("k)");
		if(k.matches("[a-z][0-9a-z-_\\.]+@[a-z]+\\.(es|com)"))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
	}

}
