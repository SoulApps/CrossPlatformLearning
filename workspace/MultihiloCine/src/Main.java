/**
 * Created by Alejandro on 04/10/2016.
 */
public class Main {

    /*
    Queremos modelar la siguente situación utilizando programación multihilo:
    Un cine dispone de cuatro salas donde cada una de ellas tiene un aforo de 50 personas.
    El cine dispone de dos taquillas en las que los clientes compran y devuelven entradas.
    Cuando un cliente compra una entrada indica el número de sala y el número de entradas que desea comprar.
    Supón que cada taquilla es un hilo que ejecuta distintas operaciones de compra y venta correspondientes a los clientes.
    El tiempo entre compras/devoluciones en las taquillas será aleatorio entre 1 y 3 segundos.
    Suponer que en cada taquilla se realizan diez operaciones de compra/devolución.
     */


    public static void main(String[] args) {
        final int MAX_SALAS = 4, MAX_TAQUILLAS = 2;
        int i;
        Sala salas[] = new Sala[MAX_SALAS];
        Thread taquillas[] = new Thread[MAX_TAQUILLAS];

        for (i = 0; i < MAX_SALAS; i++) {
            salas[i] = new Sala(i + 1);
        }

        for (i = 0; i < MAX_TAQUILLAS; i++) {
            taquillas[i] = new Thread(new Taquilla(salas));
            taquillas[i].start();
        }
    }

}
