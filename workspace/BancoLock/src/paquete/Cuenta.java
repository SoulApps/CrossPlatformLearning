package paquete;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alejandro on 24/10/2016.
 */
public class Cuenta {

    private float saldo;
    private ReentrantLock lock;

    public Cuenta() {
        saldo = 0;
        lock = new ReentrantLock();
    }

    public void incrementarSaldo() {
        lock.lock();
        saldo++;
        lock.unlock();
    }

    public float getSaldo() {
        return saldo;
    }
}
