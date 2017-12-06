package Ejercicio24;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Jefe j1=new Jefe("Juan",100,"Jefe ingeniero");
		Jefe j2;
		Encargado e1= new Encargado("Pepe",200,"Encargado de seguridad");
		Encargado e2;
		Encargado e3;
		Trabajador t1= new Trabajador("Juani",1000);
		Trabajador t2;
		
		
		
		System.out.println(j1);
		System.out.println("****************************");
		System.out.println(e1);
		System.out.println("****************************");
		System.out.println(t1);
		System.out.println("****************************");
		
		
		//Venta del encargado1
		e1.venta_realizada(1, 2000);
		e1.venta_realizada(2, 4444);
		
		
		System.out.printf("Sueldo de %s antes del aumento: %.2f€%n",e1.nombre,e1.sueldo);
		
		e1.aumento_productividad(5);
		System.out.printf("Sueldo de %s despues del aumento: %.2f€%n",e1.nombre,e1.sueldo);
		
		
		//CLONADOS
		
		t2=(Trabajador) t1.clone();
		System.out.println(t1);
		System.out.println(t2);
		
		System.out.println();
		e2=(Encargado) e1.clone();
		System.out.println(e1);
		System.out.println();
		System.out.println(e2);
		
		System.out.println();
		j2=(Jefe) j1.clone();
		System.out.println(j1);
		System.out.println();
		System.out.println(j2);
		System.out.println();
		
		//EQUALS
		e3=(Encargado) e1.clone();
		
		
		if(Arrays.equals(e1.ventas, e3.ventas))
			System.out.println("Igual");
		else
			System.out.println("No igual");
		
		
	}

}
