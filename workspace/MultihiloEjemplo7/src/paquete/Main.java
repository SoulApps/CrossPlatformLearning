package paquete;

/**
 * Created by Alejandro on 26/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        Thread hilos[] = new Thread[10];
        ThreadGroup grupo = new ThreadGroup("Grupo");

        for (i = 0; i < 9; i++) {
            hilos[i] = new Thread(grupo, new Tabla(i + 1), "Hilo-" + (i + 1));
            hilos[i].start();
        }


        try {
            Thread.sleep(2000);
            for (i = 0; i < 9; i++)
                grupo.interrupt();
        } catch (InterruptedException e) {
        }
    }
}
