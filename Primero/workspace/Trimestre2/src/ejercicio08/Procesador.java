package ejercicio08;

/**
 * Created by Alejandro on 15/01/2016.
 */
public enum Procesador {
    INTEL((byte) 8), AMD((byte) 4);

    private byte gb;
    Procesador(byte gb) {
        this.gb = gb;
    }

    public byte getGb() {
        return gb;
    }
}
