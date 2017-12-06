package AlejandroSanchezGalvin;

import java.util.Comparator;

/**
 * Created by Alejandro on 13/05/2016.
 */
public class ComparadorClavePelicula implements Comparator<Clave> {
    public int compare(Clave o1, Clave o2) {
        int comp = o1.getGenero().compareTo(o2.getGenero());
        if (comp == 0)
            comp = o1.getNumero() - o2.getNumero();

        return comp;
    }
}
