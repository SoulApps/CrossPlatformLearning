package examenHerencia;

/**
 * Created by Alejandro on 07/03/2016.
 */
public class Profesor extends Persona implements Profesorable {
    private static int numeroProfesoresCreados = 0;
    private double sueldo;
    private int numeroProfesor;

    public Profesor(String nombre, double sueldo) throws NombreIncorrectoException {
        super(nombre);
        this.sueldo = sueldo;
        numeroProfesoresCreados++;
        numeroProfesor = numeroProfesoresCreados;
    }

    public String tipo_numero() {
        return String.format("Soy el profesor número %d", numeroProfesor);
    }


    public void subirSueldo(double cantidadAumentar) {
        sueldo += cantidadAumentar;
    }


    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Profesor)
            if (super.equals(o) && sueldo == ((Profesor) o).sueldo)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Sueldo: %.2f]", super.toString(), sueldo);
    }
}
