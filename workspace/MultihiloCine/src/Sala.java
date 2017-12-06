/**
 * Created by Alejandro on 04/10/2016.
 */
public class Sala {
    private final int AFORO_MAXIMO = 50, AFORO_MIMIMO = 0;
    private int plazasDisponibles, numero;

    public Sala(int numero) {
        this.numero = numero;
        plazasDisponibles = AFORO_MAXIMO;
    }


    public synchronized void comprar(int entradas) {
        if ((plazasDisponibles - entradas) >= AFORO_MIMIMO) {
            plazasDisponibles -= entradas;
            System.out.printf("Has comprado %d entradas para la sala %d -- Hay %d entradas en la sala %2$d%n", entradas, numero, plazasDisponibles);
        } else
            System.out.printf("No puedes comprar %d entradas para la sala %d%n", entradas, numero);
    }

    public synchronized void vender(int entradas) {

        if ((plazasDisponibles + entradas) <= AFORO_MAXIMO) {
            plazasDisponibles += entradas;
            System.out.printf("Has vendido %d entradas para la sala %d -- Hay %d entradas en la sala %2$d%n", entradas, numero, plazasDisponibles);
        } else
            System.out.printf("No puedes vender %d entradas para la sala %d%n", entradas, numero);

    }
}
