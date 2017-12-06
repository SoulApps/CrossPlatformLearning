package jugadores;

import excepciones.PosicionNoValidaException;
import materiales.Tablero;

/**
 * Clase que hace posible a la inteligencia artificial colocar autom&aacute;ticamente.
 *
 *
 * Created by Alejandro on 15/04/2016.
 */
public interface ColocarBot extends Colocar {
    /**
     * Este m&eacute;todo se encarga de colocar una materiales autom&aacute;ticamente cuando sea su turno.
     * Lo har&aacute; intentando colocar fichas en todas las casillas y luego decidir&aacute; la mejor opci&oacute;n y colocar&aacute; la materiales en esa posici&oacute;n.
     * @param tablero Es el tablero sobre el que se trabajar&aacute;.
     * @param turnoBlancas Sirve para indicar el color de la ficha que se va a colocar.
     * @throws PosicionNoValidaException Lanzar&aacute; la excepci&oacute;n cuando se intente colocar una ficha en un lugar no v&aacute;lido,
     * es decir, encima de otra ficha, o en un lugar donde no voltea.
     * @return Devuelve un valor booleano que indica si ha podido colocar una ficha.
     */
    boolean colocarFichaBot(Tablero tablero, boolean turnoBlancas) throws PosicionNoValidaException;
}
