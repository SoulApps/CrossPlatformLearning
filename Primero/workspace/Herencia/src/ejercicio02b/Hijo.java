package ejercicio02b;

import ejercicio02a.Padre;

/**
 * Created by Alejandro on 25/01/2016.
 */
public class Hijo extends Padre {
    private String privadoHijoOtroPaquete = "Privado Hijo Otro Paquete";
    protected String protegidoHijoOtroPaquete = "Protegido Hijo Otro Paquete";
    public String publicoHijoOtroPaquete = "Público Hijo Otro Paquete";
    String amigableHijoOtroPaquete = "Amigable Hijo Otro Paquete";
}
