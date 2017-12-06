/**
 * Created by Alejandro on 03/10/2016.
 */
public class Cuenta {

    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }


    public void ingresar(double cantidad) {
        synchronized (this) {
            saldo += cantidad;
            System.out.printf("Se ha ingresado %.2f----Hay %.2f eurors%n", cantidad, saldo);
        }
    }

    public void cargar(double cantidad) {
        synchronized (this) {
            if (saldo > cantidad) {
                saldo -= cantidad;
                System.out.printf("Se ha retirado %.2f----Hay %.2f eurors%n", cantidad, saldo);
            }
            else
                System.out.println("No hay dinero suficiente");
        }
    }



    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
