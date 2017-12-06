package paquete;

/**
 * Created by Alejandro on 07/11/2016.
 */
public class Persona extends Thread {

    private String nombre;
    private SalaOrdenadores salaOrdenadores;
    private boolean esVago;

    public Persona(String nombre, SalaOrdenadores salaOrdenadores, boolean esVago) {
        this.nombre = nombre;
        this.salaOrdenadores = salaOrdenadores;
        this.esVago = esVago;
        setName(nombre);
    }


    @Override
    public void run() {
        if (!esVago)
            salaOrdenadores.trabajar(nombre);
        else
            salaOrdenadores.intentarTrabajar(nombre);
    }
}
