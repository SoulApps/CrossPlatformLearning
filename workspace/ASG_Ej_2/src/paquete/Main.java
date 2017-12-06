package paquete;

import java.util.Random;

/**
 * Created by Alejandro on 14/12/2016.
 */
public class Main {

    public static final Random RND = new Random();
    public static final int NUM_MUNHECAS = 50;

    public static void main(String[] args) {
        //Cestas.
        Cesta cabezasPuestas = new Cesta("cabezas puestas");
        Cesta brazosPuestos = new Cesta("brazos puestos");
        Cesta piernasPuestas = new Cesta("piernas puestas");

        //Trabajadores.
        ElCabezas elCabezas = new ElCabezas(cabezasPuestas);
        ElBrazos elBrazos = new ElBrazos(cabezasPuestas, brazosPuestos);
        ElPiernas elPiernas = new ElPiernas(brazosPuestos, piernasPuestas);
        ElVestiditos elVestiditos = new ElVestiditos(piernasPuestas);

        //Start.
        elCabezas.start();
        elBrazos.start();
        elPiernas.start();
        elVestiditos.start();
    }
}
