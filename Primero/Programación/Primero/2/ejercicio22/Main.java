package ejercicio22;

import ejercicio22.Camaras.TipoCam;
import ejercicio22.Camaras.TipoCam2;
import ejercicio22.Moviles.Cobertura;

public class Main {

	public static void main(String[] args) {
		
		Producto producto = new Producto();
		Producto producto2;
		Producto producto3 = new Producto("Hp", "50F", 40);
		
		producto2 = (Producto)producto.clone(); 					//Prueba del metodo Clone.
		
		System.out.println(producto2.equals(producto)); //Prueba de equals que genera true.
		System.out.println(producto3.toString());		//Prueba del toString.
		
		
		System.out.println(); //Espacio
		
		
		Ordenador ordenador = new Ordenador();
		Ordenador ordenador2;
		Ordenador ordenador3 = new Ordenador("Hp", "50F", 40, (float)2.66, 500);
		
		ordenador2 = (Ordenador)ordenador.clone(); 				//Prueba del metodo Clone.
		
		System.out.println(ordenador2.equals(ordenador));//Prueba de equals que genera true.
		System.out.println(ordenador3.toString());		//Prueba del toString.
		
		
		System.out.println(); //Espacio
				
		
		Portatil portatil = new Portatil();
		Portatil portatil2;
		Portatil portatil3 = new Portatil("Hp", "50F", 40, (float)2.66, 500, (float)2.3);
		
		portatil2 = (Portatil)portatil.clone();					//Prueba del metodo Clone.
		
		System.out.println(portatil2.equals(portatil));	//Prueba de equals que genera true.
		System.out.println(portatil3.toString());		//Prueba del toString.
		
		
		System.out.println(); //Espacio
		
		
		Monitor monitor = new Monitor();
		Monitor monitor2;
		Monitor monitor3 = new Monitor("Hp", 1080);
		
		monitor2 = (Monitor)monitor.clone();						//Prueba del metodo Clone.
		
		System.out.println(monitor2.equals(monitor));	//Prueba de equals que genera true. POLTERGEIST.
		System.out.println(monitor3.toString());		//Prueba del toString.
		
		
		System.out.println(); //Espacio
		
		
		Sobremesa sobremesa = new Sobremesa();
		Sobremesa sobremesa2;
		Sobremesa sobremesa3 = new Sobremesa("Hp", "50F", 40, (float)2.66, 500, (float)2.3, monitor3);
		
		sobremesa2 = (Sobremesa)sobremesa.clone();					//Prueba del metodo Clone.
		
		System.out.println(sobremesa2.equals(sobremesa));//Prueba de equals que genera true.
		System.out.println(sobremesa3.toString());		//Prueba del toString.
				
		
		System.out.println(); //Espacio
		
		
		Dispositivos dispositivo = new Dispositivos();
		Dispositivos dispositivo2;
		Dispositivos dispositivo3 = new Dispositivos("Huawei", "Honor 6", 50, 8);
		
		dispositivo2 = (Dispositivos)dispositivo.clone();				//Prueba del metodo Clone.
		
		System.out.println(dispositivo2.equals(dispositivo));//Prueba de equals que genera true.
		System.out.println(dispositivo3.toString());		//Prueba del toString.
		
		
		System.out.println(); //Espacio
		
		
		Camaras camara = new Camaras();
		Camaras camara2;
		Camaras camara3 = new Camaras("Nikon", "D5100", 10, 8, TipoCam.REFLEX, TipoCam2.DIGITAL);
		
		camara2 = (Camaras)camara.clone();						//Prueba del metodo Clone.
		
		System.out.println(camara2.equals(camara));		//Prueba de equals que genera true.
		System.out.println(camara3.toString());			//Prueba del toString.
		
		
		System.out.println(); //Espacio
		
		
		Moviles movil = new Moviles();
		Moviles movil2;
		Moviles movil3 = new Moviles("Huawei", "Honor 6", 50, 8, Cobertura.COBERTURA_4G);
		
		
		movil2 = (Moviles)movil.clone();							//Prueba del metodo Clone.
		
		System.out.println(movil2.equals(movil));		//Prueba de equals que genera true.
		System.out.println(movil3.toString());			//Prueba del toString.
				
	}

}
