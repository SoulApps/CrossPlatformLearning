package ejercicio13;

import java.util.Comparator;

import ejercicio13.Mascota;

public class ComparadorMascotas implements Comparator<Mascota>{
	public int compare(Mascota m1, Mascota m2){
		/*int resultado = 0;
		
		String codigo1 = m1.getCodigo();
		String codigo2 = m2.getCodigo();
		
		int cod1 = Integer.parseInt(codigo1.substring(1));
		int cod2 = Integer.parseInt(codigo2.substring(1));
		
		resultado+= codigo1.charAt(0) - codigo2.charAt(0);
		resultado+= cod1-cod2;
		
		return resultado;*/
		
		return m1.getCodigo().compareTo(m2.getCodigo());
	}
}
