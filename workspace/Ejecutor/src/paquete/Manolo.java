package paquete;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Alejandro on 22/11/2016.
 */
public class Manolo {

    private ThreadPoolExecutor ejecutor;

    public Manolo() {
        //ejecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool(); //Manolo rico
        ejecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5); //Manolo no tan rico
    }

    public void ejecutarTarea(Tarea tarea) {
        ejecutor.execute(tarea);
    }

    public void terminarJornada() {
        ejecutor.shutdown();
    }

    public int getNumTrabajadoresTrabajando() {
        return ejecutor.getActiveCount();
    }

    public int getNumTrabajadoresTotal() {
        return ejecutor.getPoolSize();
    }
}
