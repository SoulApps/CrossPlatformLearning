package alejandroSanchezGalvinFicheros;

import java.io.Serializable;

/**
 * Created by Alejandro on 17/11/2016.
 */
public class Empleado implements Serializable {

    private String codigo;
    private String nombre;
    private int edad;
    private float salario;

    public Empleado(String codigo, String nombre, int edad, float salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String toString() {
        return String.format("[Codigo: %s] [Nombre: %s] [Edad: %d] [Salario: %.2f]", codigo, nombre, edad, salario);
    }
}
