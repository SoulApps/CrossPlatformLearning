/**
 * Created by Alejandro on 03/10/2016.
 */
public class Main {
    public static void main(String[] args) {

        int i = 5;

        Cuenta cuenta = new Cuenta(100);
        Thread bancos[] = new Thread[i];
        Thread empresas[] = new Thread[i];


        for (i = 0; i < 5; i++) {
            bancos[i] = new Thread(new Banco(cuenta));
            bancos[i].start();

            empresas[i] = new Thread(new Empresa(cuenta));
            empresas[i].start();
        }


        for (i = 0; i < 5; i++) {
            try {
                bancos[i].join();
                empresas[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Saldo actual: %.2f", cuenta.getSaldo());
    }
}
