package paquete;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Alejandro on 23/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        final int MAX = 10;
        int i;
        String persona;
        Random rnd = new Random();
        ThreadPoolExecutor ejecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        ArrayList<ListaInvitados> invitados = new ArrayList<>();

        for (i = 0; i < MAX; i++) {
            invitados.add(new ListaInvitados(rnd.nextInt(10)));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        for (i = 0; i < MAX; i++) {
            try {
                persona = ejecutor.invokeAny(invitados);
                System.out.printf("Este usuario es un %s\n", persona);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                // Si ninguno de los sistema ha finalizado bien y no ha lanzado una
                // excepción, significa que ningún sistema ha validado al usuario.
                System.out.println("Pringao");
            }
        }

        ejecutor.shutdown();
    }
}
