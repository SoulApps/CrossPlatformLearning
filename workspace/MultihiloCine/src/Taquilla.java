import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 04/10/2016.
 */
public class Taquilla implements Runnable {

    Sala salas[];

    public Taquilla(Sala[] salas) {
        this.salas = salas;
    }

    @Override
    public void run() {
        int i;
        Random rnd = new Random();

        for (i = 0; i < 10; i++) {
            if (rnd.nextInt(2) == 1)
                salas[rnd.nextInt(2)].comprar(rnd.nextInt(50) + 1);
            else
                salas[rnd.nextInt(2)].vender(rnd.nextInt(50) + 1);

            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(3) + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
