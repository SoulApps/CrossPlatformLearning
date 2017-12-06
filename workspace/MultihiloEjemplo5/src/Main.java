/**
 * Created by Alejandro on 27/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        Thread crono = new Thread(new Crono());
        crono.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        crono.interrupt();
    }
}
