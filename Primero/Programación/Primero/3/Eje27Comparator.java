package Bol7;

import java.util.Comparator;

public class Eje27Comparator implements Comparator<Eje27Mascota>{

	@Override
	public int compare(Eje27Mascota o1, Eje27Mascota o2) {
		int comparacion = o1.cod.compareToIgnoreCase(o2.cod);
		if(comparacion==0)
			return (int)(o1.cuota - o2.cuota);
		else
			return comparacion;
	}

}
