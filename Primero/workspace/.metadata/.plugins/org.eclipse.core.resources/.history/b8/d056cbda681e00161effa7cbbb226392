package jugadores;

import excepciones.PosicionNoValidaException;
import globalValues.GlobalValues;
import materiales.Posicion;
import materiales.Tablero;

/**
 * Esta clase representa la inteligencia artificial.
 *
 *
 * Created by Alejandro on 15/04/2016.
 */
public class Bot extends Jugador implements ColocarBot {

    public Bot() {
        super("Bot");
    }

    /**
     * Este m&eacute;todo se encarga de colocar una materiales autom&aacute;ticamente cuando sea su turno.
     * Lo har&aacute; intentando colocar fichas en todas las casillas y luego decidir&aacute; la mejor opci&oacute;n y colocar&aacute; la materiales en esa posici&oacute;n.
     * @param tablero Es el tablero sobre el que se trabajar&aacute;.
     * @param turnoBlancas Sirve para indicar el color de la ficha que se va a colocar.
     * @return Devuelve un valor booleano que indica si ha podido colocar una ficha.
     */
    public boolean colocarFichaBot(Tablero tablero, boolean turnoBlancas) {
        boolean colocado = false;
        int i, j;
        int fichasVolteadas = 0, provisional;
        int x = 0, y = 0;
        Tablero clonTablero = (Tablero) tablero.clone();
        Posicion posicion = new Posicion(0, 0);

        for (i = 0; i < GlobalValues.CASILLAS; i++) {
            for (j = 0; j < GlobalValues.CASILLAS; j++) {
                posicion.setFila(i);
                posicion.setColumna(j);
                try {
                    provisional = colocarFicha(posicion, clonTablero, turnoBlancas); //Coloco la materiales en en esa posici&oacute;n.
                    clonTablero = (Tablero) tablero.clone(); //Dejo el tablero como estaba tras hacer esta prueba.
                    if (provisional > fichasVolteadas) { //Comparo si vale m&aacute;s la pena.
                        colocado = true;
                        fichasVolteadas = provisional;
                        x = i;
                        y = j;
                    }
                } catch (PosicionNoValidaException e) {

                }
            }
        }

        if (colocado) {
            posicion.setFila(x);
            posicion.setColumna(y);
            try {
                colocarFicha(posicion, tablero, turnoBlancas); //Coloco la materiales en la mejor posici&oacute;n.
            } catch (PosicionNoValidaException e) {

            }
        }

        return colocado;
    }
}
