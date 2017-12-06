package ejercicio04;

import ejercicio03.Caja;

import java.util.ArrayList;

/**
 * Created by Alejandro on 23/04/2016.
 */
public class Almacen<T> implements Almacenable {
    ArrayList<Caja<T>> cajas = new ArrayList<>();

    public Object primero() {
        return cajas.get(0).getContenido();
    }


    public Object ultimo() {
        return cajas.get(cajas.size()).getContenido();
    }
}
