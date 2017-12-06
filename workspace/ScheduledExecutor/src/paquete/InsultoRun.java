package paquete;

import java.util.Date;

/**
 * Created by Alejandro on 30/11/2016.
 */
public class InsultoRun implements Runnable {

    private String insulto;

    public InsultoRun(String insulto) {
        this.insulto = insulto;
    }

    @Override
    public void run() {
        System.out.printf("%s a las %s%n", insulto,  new Date());
    }
}
