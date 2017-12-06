package examenAnhoPasado;

import java.util.Comparator;

/**
 * Created by Alejandro on 09/05/2016.
 */
public class ComparadorEmpleados implements Comparator<Clave> {
    public int compare(Clave o1, Clave o2) {
        int comp = o1.getCategoria().compareTo(o2.getCategoria());
        if (comp == 0 && o1.getNumero() != o2.getNumero())
            comp = o1.getNumero() - o2.getNumero();

        return comp;
    }
}
