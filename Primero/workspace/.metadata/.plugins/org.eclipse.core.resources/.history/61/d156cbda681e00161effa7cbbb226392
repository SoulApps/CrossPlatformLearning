package jugadores;

import excepciones.PosicionNoValidaException;
import materiales.Posicion;
import materiales.Tablero;

/**
 * Interfaz que hace posible a los juagdores colocar una ficha.
 *
 *
 * Created by Alejandro on 15/04/2016.
 */
public interface Colocar {
    /**
     * Este m&eacute;todo colocar&aacute; la ficha en la fila y columna pasada por par&aacute;metros.
     * Funciona de la siguiente manera:
     *      Teniendo una disposici&oacute;n tal que as&iacute; jugando con fichas negras: [posici&oacute;n libre deseada] B B N
     *      1.- Mirar&aacute; en todas las direcciones si hay una ficha blanca.
     *      1.1- Mirar&aacute; si a la derecha en este caso hay alguna ficha blanca
     *      2.- Al haberla, seguir&aacute; buscando m&aacute;s a la derecha una ficha negra.
     *      3.- Al haberla, colocar&aacute; la ficha en la posici&oacute;n deseada y voltear&aacute; las fichas blancas que hay entre ellas.
     *      3.1.- Si no hay, entonces no har&aacute; nada.
     * @param posicion Es la posici&oacute;n en la que se colocar&aacute; la ficha.
     * @param tablero Es el tablero sobre el que se trabajar&aacute;.
     * @param turnoBlancas Sirve para indicar el color de la ficha que se va a colocar.
     * @return Devuelve un entero que usar&aacute; el m&eacute;todo colocarFichaBot() para elegir la mejor opci&oacute;n.
     * @throws PosicionNoValidaException Lanzar&aacute; la excepci&oacute;n cuando se intente colocar una ficha en un lugar no v&aacute;lido,
     * es decir, encima de otra ficha, o en un lugar donde no voltea.
     */
    int colocarFicha(Posicion posicion, Tablero tablero, boolean turnoBlancas) throws PosicionNoValidaException;
}
