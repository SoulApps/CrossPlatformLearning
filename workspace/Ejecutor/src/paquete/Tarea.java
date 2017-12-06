package paquete;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 22/11/2016.
 */
public class Tarea implements Runnable {

    private int numTarea;

    public Tarea(int numTarea) {
        this.numTarea = numTarea;
    }

    @Override
    public void run() {
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        System.out.printf("%s está ejecutando la tarea %d a las %s%n", Thread.currentThread().getName(), numTarea, formato.format(new Date()));
        /*try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.printf("%s ha finalizado la tarea %d a las %s%n", Thread.currentThread().getName(), numTarea, formato.format(new Date()));
    }
}
