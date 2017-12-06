package paquete;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 22/11/2016.
 */

/*
    Suponer que Manolo es un capataz que puede contratar todos los albañiles que quiera siempre que sea necesario.
    Simular que a Manolo le llegan una serie de tareas cuyo tiempo de ejecución es aleatorio de 1 a 5 segundos en los 2 siguientes casos:
	    -Que se envían 10 tareas con una frecuencia entre ellas de 3 segundos.
	    -Que se envían 10 tareas con una frecuencia entre ellas de 1 segundos.
    Cada tarea debe mostrar el nombre del hilo en el que se está ejecutando y la hora en la que inicia y finaliza su ejecución.
    El programa principal debe mostrar el momento en la que envía cada tarea a Manolo, junto con el número de trabajadores que tiene
    contratado Manolo en ese momento y el número de trabajadores de Manolo que están trabajando en ese momento.
 */
public class Main {
    public static void main(String[] args) {
        final int NUM_TAREAS = 100, FRECUENCIA = 1;
        int i;
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        Manolo manolo = new Manolo();
        Tarea[] tareas = new Tarea[NUM_TAREAS];

        for (i = 0; i < NUM_TAREAS; i++) {
            tareas[i] = new Tarea(i);
            manolo.ejecutarTarea(tareas[i]);
            System.out.printf("Manolo ha enviado la tarea %d a las %s, tiene %d trabajadores y %d están trabajando%n", i, formato.format(new Date()),manolo.getNumTrabajadoresTotal(), manolo.getNumTrabajadoresTrabajando());
            /*try {
                TimeUnit.SECONDS.sleep(FRECUENCIA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

        manolo.terminarJornada();
    }
}
