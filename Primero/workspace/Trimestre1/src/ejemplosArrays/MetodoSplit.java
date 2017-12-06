package ejemplosArrays;

public class MetodoSplit {

	public static void main(String[] args) {
		
		String cadena="boo:and:foo";//Son los mismos ejemplos que vienen en la API
		String array[][]=new String[9][];//Utilizo 9 arrays porque si utilizo solamente uno, se deja basura digital
		
		array[0]=cadena.split(":");
		System.out.printf("Cadena: boo:and:foo   %-15s","split(\":\")");
		for(String s:array[0])
			System.out.printf("|%s",s);
		System.out.printf("%20s%d%n","Tamaño del array: ",array[0].length);
		array[1]=cadena.split("o");
		System.out.printf("Cadena: boo:and:foo   %-15s","split(\"o\")");
		for(String s:array[1])
			System.out.printf("|%s",s);
		System.out.printf("%22s%d%n","Tamaño del array: ",array[1].length);
		array[2]=cadena.split(":",2);
		System.out.printf("Cadena: boo:and:foo   %-15s","split(\":\",2)");
		for(String s:array[2])
			System.out.printf("|%s",s);
		System.out.printf("%20s%d%n","Tamaño del array: ",array[2].length);
		array[3]=cadena.split(":",5);
		System.out.printf("Cadena: boo:and:foo   %-15s","split(\":\",5)");
		for(String s:array[3])
			System.out.printf("|%s",s);
		System.out.printf("%20s%d%n","Tamaño del array: ",array[3].length);
		array[4]=cadena.split(":",-2);
		System.out.printf("Cadena: boo:and:foo   %-15s","split(\":\",-2)");
		for(String s:array[4])
			System.out.printf("|%s",s);
		System.out.printf("%20s%d%n","Tamaño del array: ",array[4].length);
		array[5]=cadena.split("o",5);
		System.out.printf("Cadena: boo:and:foo   %-15s","split(\"o\",5)");
		for(String s:array[5])
			System.out.printf("|%s",s);
		System.out.printf("%20s%d%n","Tamaño del array: ",array[5].length);
		array[6]=cadena.split("o",-2);
		System.out.printf("Cadena: boo:and:foo   %-15s","split(\"o\",-2)");
		for(String s:array[6])
			System.out.printf("|%s",s);
		System.out.printf("%20s%d%n","Tamaño del array: ",array[6].length);
		array[7]=cadena.split("o",0);
		System.out.printf("Cadena: boo:and:foo   %-15s","split(\"o\",0)");
		for(String s:array[7])
			System.out.printf("|%s",s);
		System.out.printf("%22s%d%n","Tamaño del array: ",array[7].length);
		array[8]=cadena.split("b",3);
		System.out.printf("Cadena: boo:and:foo   %-15s","split(\"b\",3)");
		for(String s:array[8])
			System.out.printf("|%s",s);
		System.out.printf("%20s%d%n","Tamaño del array: ",array[8].length);
	}
}
