package ejercicio05;

/**
 * Created by Alejandro on 13/01/2016.
 */
public enum Nivel {
    ALTO('A'), MEDIO('M'), BAJO('B');

    private char c;
    Nivel(char c) {
        this.c = c;
    } //Constructor
    public char getNivel() {
        return c;
    }
}
