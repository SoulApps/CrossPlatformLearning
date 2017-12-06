package paquete;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Alejandro on 29/11/2016.
 */
public class Main {
    /*
    El profesor de multihilo quiere pegarse unas vacaciones a costa de sus alumnos
    por lo que envía una tarea de clase consistente en que cada alumno obtenga
    una determinada cantidad dinero y se la done a su profesor. El programa debe mostrar
    por pantalla la cantidad de euros que ha conseguido el profesor gracias a sus diez
    alumnos. Para simular el tiempo tarda en conseguir el dinero utilizaremos un sleep
    aleatorio de 1 a 5 segundos. Además de la cantidad total conseguida, se debe
    mostrar por pantalla el nombre de cada alumno junto con la cantidad aportada
    para que el profesor lo tenga en cuenta en la evaluación final.
     */

    public static void main(String[] args) {
        final int MAX = 10;
        int i, dinero = 0;
        ThreadPoolExecutor ejecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        ArrayList<Alumno> alumnos = new ArrayList<>();


        List<Future<Entrega>> entregas = new ArrayList<>(); //Tiene que ser List


        Future<Entrega> entregaFuture;
        Entrega entrega;

        for (i = 0; i < MAX; i++)
            alumnos.add(new Alumno("Alumno " + i));


        try {
            entregas = ejecutor.invokeAll(alumnos);
            ejecutor.shutdown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (i = 0; i < MAX; i++) {
            entregaFuture = entregas.get(i);
            try {
                entrega = entregaFuture.get();
                System.out.printf("%s%n", entrega);
                dinero += entrega.getDinero();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


        System.out.printf("Pedro tiene %d€", dinero);
    }
}
