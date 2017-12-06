package AlejandroSanchezGalvin;

/**
 * Created by Alejandro on 13/05/2016.
 */
public enum Genero {
    FICCION('F'), TERROR('T'), COMEDIA('C');

    private char codigo;

    Genero(char codigo) {
        this.codigo = codigo;
    }

    public char getCodigo() {
        return codigo;
    }
}
