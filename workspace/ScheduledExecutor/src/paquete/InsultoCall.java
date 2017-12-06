package paquete;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by Alejandro on 30/11/2016.
 */
public class InsultoCall implements Callable<String> {

    private String insulto;

    public InsultoCall(String insulto) {
        this.insulto = insulto;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s a las %s%n", insulto,  new Date());
        return null;
    }
}
