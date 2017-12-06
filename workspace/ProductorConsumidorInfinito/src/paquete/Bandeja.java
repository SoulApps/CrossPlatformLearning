package paquete;

import java.util.ArrayList;

/**
 * Created by Alejandro on 18/10/2016.
 */
public class Bandeja {
    ArrayList<Integer> bandeja;

    public Bandeja() {
        bandeja = new ArrayList<>();
    }

    public synchronized void anhadirDonut(String nombre) {
        while (bandeja.size() >= 10) {
            System.out.println("Bandeja llena");
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        bandeja.add(new Integer(0));
        System.out.printf("%s ha hecho un donut y hay %d donuts en la bandeja%n", nombre, bandeja.size());
        notifyAll();
    }

    public synchronized void cogerDonut(String nombre) {
        while (bandeja.size() == 0) {
            System.out.println("Bandeja vacía");
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        bandeja.remove(0);
        System.out.printf("%s se ha comido un donut y hay %d donuts en la bandeja%n", nombre, bandeja.size());
        notifyAll();
    }
}
