package ejemplosArrays;

public class EjemploArrays {

	public static void main(String[] args) {
		
		int i,j;
		double decimales[]={1.69,3.89,8.26,5.12};
		String nombres[]={"Ana","Juan","Pepe","Esteban","Antonio","Pepa","Alejandro","Laura","Marta"};
		int matriz[][]={{1,4,9},{3,5,7},{4,6,5}};//Inicialización de arrays bidimensionales
		
		for(i=0;i<matriz.length;i++){//Recorrido de arrays bidimensionales
			for(j=0;j<matriz[i].length;j++)
				System.out.printf("%d ",matriz[i][j]);
			System.out.println();
		}
		System.out.println();
		//Otra sintaxis de for: solamente para arrays unidimensionales. Las variables obligatoriamente se tienen que declarar dentro del for
		for(String s:nombres)
			System.out.println(s);

		System.out.println();
		
		for(double k:decimales)
			System.out.println(k);

		System.out.println();
		
		for(int h:matriz[1])//Recorro el segundo array unidimensional del array bidimensional
			System.out.println(h);
	}

}
