package paquete;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 14/12/2016.
 */
public class Tarea implements Callable<Resultado> {

    public static final SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss"); //Formato de la fecha


    private int numTarea;

    public Tarea(int numTarea) {
        this.numTarea = numTarea;
    }

    @Override
    public Resultado call() throws Exception {
        TimeUnit.SECONDS.sleep(Directora.RND.nextInt(4) + 2);
        return new Resultado(numTarea, formato.format(new Date()));
    }
}
