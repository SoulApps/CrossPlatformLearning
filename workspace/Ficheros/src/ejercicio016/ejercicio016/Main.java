package ejercicio016.ejercicio016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		String nombreContacto;
		
		File archivoJSON = new File("JSON.json");
		FileReader lector = new FileReader(archivoJSON);
		BufferedReader bufferLector = new BufferedReader(lector);
		String cadenaJSON = bufferLector.readLine(); //Obtenemos el JSON del archivo
		System.out.println(cadenaJSON);
		
		System.out.print("Introduzca el nombre del contacto a buscar: ");
		nombreContacto = teclado.next();
		System.out.println();
		
		//Comenzamos la extraccion de los datos
		//Pattern patron = Pattern.compile("\"([^\"]*)\":\"?([^,&\"]*)");
		//Pattern patron = Pattern.compile("\"([^\"]*)\":\"?([^,]*),\"([^\"]*)\":\"?([^,&\"]*)\",\"([^\"]*)\":\"?([^,&\"]*)\",\"([^\"]*)\":\"?([^,&\"]*)\",\"([^\"]*)\":\"?([^,]*),\"([^\"]*)\":\"?([^,&\"]*)\",\"([^\"]*)\":([^,&\"]*),\"([^\"]*)\":([^,&\"]*)}");
		Pattern patron = Pattern.compile("\"([^\"]*)\":\"?([^,]*),\"([^\"]*)\":\"?("+nombreContacto+")\",\"([^\"]*)\":\"?([^,&\"]*)\",\"([^\"]*)\":\"?([^,&\"]*)\",\"([^\"]*)\":\"?([^,]*),\"([^\"]*)\":\"?([^,&\"]*)\",\"([^\"]*)\":([^,&\"]*),\"([^\"]*)\":([^,&\"]*)}");
		Matcher matcher = patron.matcher(cadenaJSON);
		
		
		while(matcher.find()){ //Mientras que se pueda sacar el patron...
			System.out.println(matcher.group(1)+": "+matcher.group(2));
			System.out.println(matcher.group(3)+": "+matcher.group(4));
			System.out.println(matcher.group(5)+": "+matcher.group(6));
			System.out.println(matcher.group(7)+": "+matcher.group(8));
			System.out.println(matcher.group(9)+": "+matcher.group(10));
			System.out.println(matcher.group(11)+": "+matcher.group(12));
			System.out.println(matcher.group(13)+": "+matcher.group(14));
			System.out.println(matcher.group(15)+": "+matcher.group(16));
			System.out.println();
		}
		
		
		teclado.close();
		bufferLector.close();
	}

}
