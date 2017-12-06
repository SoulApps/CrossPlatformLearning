package ejercicio01;

/**
 * Created by Alejandro on 19/01/2016.
 */
public class Alumno extends Persona {
    private boolean esRepetidor;

    public Alumno() {
        //this("Sin nombre", 0, Sexo.HOMBRE, "Española"); //El this no se puede
        super("Sin nombre", (byte) 0, Sexo.HOMBRE, "Española"); //El super sí
    }

    //Constructor que usa el de por defecto
    public Alumno(boolean esRepetidor) {
        this.esRepetidor = esRepetidor;
    }

    public Alumno(String nombre, byte edad, Sexo sexo, String nacionalidad, boolean esRepetidor) {
        super(nombre, edad, sexo, nacionalidad);
        this.esRepetidor = esRepetidor;
    }

    public String toString() {
        return String.format("%s [Es repetidor: %s]", super.toString(), esRepetidor?"Sí":"No");
    }
}
