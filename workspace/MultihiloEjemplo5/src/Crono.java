import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alejandro on 27/09/2016.
 */
public class Crono implements Runnable {

    @Override
    public void run() {
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");

        while(!Thread.interrupted()) {
            System.out.println(formato.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
