package paquete;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 23/11/2016.
 */
public class ListaInvitados implements Callable<String> {

    private int numero;
    private Random rnd;

    public ListaInvitados(int numero) {
        this.numero = numero;
        rnd = new Random();
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(rnd.nextInt(2));
        if (numero == 0)
            return "invitado normal";

        else if (numero == 1)
            return "invitado vip";

        else if (numero == 2)
            return "invitado dueño";

        else
            throw new Exception();
    }
}
