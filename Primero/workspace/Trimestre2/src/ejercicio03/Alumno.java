package ejercicio03;

/**
 * Created by Alejandro on 13/01/2016.
 */
public class Alumno {
    private String nombre;
    private int matricula;
    private double nota1;
    private double nota2;

    public Alumno(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public void ponNota(double nota1, double nota2) {
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double dameMedia() {
        return (nota1 + nota2) / 2;
    }

    public String toString() {
        return String.format("[Nombre: %s] [Matrícula: %d] [Media: %.1f]", nombre, matricula, dameMedia());
    }
}
