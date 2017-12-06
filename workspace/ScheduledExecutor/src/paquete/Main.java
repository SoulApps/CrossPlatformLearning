package paquete;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 30/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        InsultoCall insultoCall;
        InsultoRun insultoRun;
        ScheduledThreadPoolExecutor ejecutor;

        //Insultos diferentes
        /*ejecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 5; i++) {
            insultoCall = new InsultoCall(String.format("Me meto contigo por %d vez", i + 1));
            System.out.printf("InsultoCall enviado en %s%n", new Date());
            ejecutor.schedule(insultoCall, i + 1, TimeUnit.SECONDS);
        }

        ejecutor.shutdown();

        try {
            ejecutor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ahora soy feliz");*/


        //Mismo insulto
        ejecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        insultoRun = new InsultoRun("Insulto definitivo");
        ScheduledFuture<?> resultadoInsulto = ejecutor.scheduleAtFixedRate(insultoRun, 1, 3, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i++) {
            //System.out.printf("Próximo insuto dentro de %d milisegundos\n", resultadoInsulto.getDelay(TimeUnit.MILLISECONDS));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ejecutor.shutdown();
        System.out.println("Ahora soy feliz");
    }
}
