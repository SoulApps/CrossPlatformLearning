package paquete;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Alejandro on 14/12/2016.
 */
public class Directora {

    public static final Random RND = new Random(); //Random que comparten las tareas.

    public static void main(String[] args) {
        final int NUM_PROCESADORES = 4, PRIMERA_TANDA = 10, SEGUNDA_TANDA = 15, TOTAL = PRIMERA_TANDA + SEGUNDA_TANDA;
        final int SEGUNDOS_ENTRE_TAREAS = 5;
        int i;
        ThreadPoolExecutor baldoMac = (ThreadPoolExecutor) Executors.newFixedThreadPool(NUM_PROCESADORES);
        ArrayList<Tarea> tareas = new ArrayList<>();
        ArrayList<Future<Resultado>> resultados = new ArrayList<>();

        try {
            //Creo las tareas.
            for (i = 0; i < TOTAL; i++)
                tareas.add(new Tarea(i + 1));

            //Mando las 15 primeras.
            for (i = 0; i < PRIMERA_TANDA; i++)
                resultados.add(baldoMac.submit(tareas.get(i)));

            //Me espero 5 segundos para empezar la segunda tanda.
            baldoMac.awaitTermination(SEGUNDOS_ENTRE_TAREAS, TimeUnit.SECONDS);

            for (; i < TOTAL; i++) //No declaro porque sigo con el mismo valor de i;
                resultados.add(baldoMac.submit(tareas.get(i)));

            baldoMac.shutdown(); //Cierro el ejecutor.
            baldoMac.awaitTermination(SEGUNDOS_ENTRE_TAREAS, TimeUnit.HOURS); //Me espero a que terminen todas las tareas.

            //Muestro los resultados.
            for (i = 0; i < TOTAL; i++)
                System.out.println(resultados.get(i).get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
