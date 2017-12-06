package paquete;

/**
 * Created by Alejandro on 07/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        final int NUM_PERSONAS = 20;
        int i;
        SalaOrdenadores salaOrdenadores = new SalaOrdenadores();
        Thread personas[] = new Thread[NUM_PERSONAS];

        for (i = 0; i < NUM_PERSONAS; i++) {
            if (i % 2 == 0)
                personas[i] = new Persona("Persona " + i, salaOrdenadores, true);
            else
                personas[i] = new Persona("Persona " + i, salaOrdenadores, false);
            personas[i].start();
        }
    }
}
