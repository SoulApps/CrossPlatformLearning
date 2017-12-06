package paquete;

import java.util.concurrent.Phaser;

/**
 * Created by Alejandro on 15/11/2016.
 */
public class MiPhaser extends Phaser {

    public MiPhaser(int i) {
        super(i);
    }

    @Override
    public int arriveAndAwaitAdvance() {
        synchronized (this) {
            if (getPhase() != 0)
                System.out.printf("%s ha llegado a %s en el puesto %d y quedan %d por llegar%n", Thread.currentThread().getName(), getPhase() == 1 ? "La Línea" : "Estepona", getArrivedParties() + 1, getUnarrivedParties() - 1);
            else
                System.out.printf("%s está listo%n", Thread.currentThread().getName());
        }
        return super.arriveAndAwaitAdvance();
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                System.out.println("Todos los ciclistas están listos\n");
                break;
            case 1:
                System.out.println("Fase de La Línea terminada\n");
                break;
            case 2:
                System.out.println("Fase de Estepona terminada\n");
                break;
        }

        return super.onAdvance(phase, registeredParties);
    }
}
