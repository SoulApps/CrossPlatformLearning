package ejercicio01;

/**
 * Created by Alejandro on 19/01/2016.
 */
public class Profesor extends Persona {
    private float sueldo;


    public Profesor() {
        //this("Sin nombre", 0, Sexo.HOMBRE, "Española"); //El this no se puede
        super("Sin nombre", (byte) 0, Sexo.HOMBRE, "Española"); //El super sí
    }

    //Constructor que usa el de por defecto
    public Profesor(float sueldo) {
        this.sueldo = sueldo;
    }

    public Profesor(String nombre, byte edad, Sexo sexo, String nacionalidad, float sueldo) {
        super(nombre, edad, sexo, nacionalidad);
        this.sueldo = sueldo;
    }

    public String toString() {
        return String.format("%s [Sueldo: %.2f]", super.toString(), sueldo);
    }
}
