package ejercicio13;

import java.util.Comparator;

/**
 * Created by Alejandro on 07/05/2016.
 */
public class ComparadorAnimal implements Comparator<Animal> {
    public int compare(Animal o1, Animal o2) {
        return o1.codigo.compareTo(o2.codigo);
    }
}
