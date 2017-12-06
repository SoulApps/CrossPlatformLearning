package paquete;

/**
 * Created by Alejandro on 14/12/2016.
 */
public class Resultado {

    private int numTarea;
    private String instante;

    public Resultado(int numTarea, String instante) {
        this.numTarea = numTarea;
        this.instante = instante;
    }

    @Override
    public String toString() {
        return String.format("La tarea %d se terminó a las %s", numTarea, instante);
    }
}
