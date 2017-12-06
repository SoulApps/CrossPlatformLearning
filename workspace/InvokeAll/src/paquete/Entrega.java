package paquete;

/**
 * Created by Alejandro on 29/11/2016.
 */
public class Entrega {

    private Alumno alumno;
    private int dinero;

    public Entrega(Alumno alumno, int dinero) {
        this.alumno = alumno;
        this.dinero = dinero;
    }

    public int getDinero() {
        return dinero;
    }

    @Override
    public String toString() {
        return String.format("%s [Dinero: %d]", alumno, dinero);
    }
}
