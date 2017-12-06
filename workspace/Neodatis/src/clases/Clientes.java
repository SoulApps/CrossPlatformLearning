package clases;

/**
 * Created by Alejandro on 16/02/2017.
 */
public class Clientes {
    int numcli;
    String nombre;
    String pobla;

    Clientes(int numcli, String nombre, String pobla) {
        this.numcli = numcli;
        this.nombre = nombre;
        this.pobla = pobla;
    }

    public String toString() {
        return "Clientes{" +
                "numcli=" + numcli +
                ", nombre='" + nombre + '\'' +
                ", pobla='" + pobla + '\'' +
                '}';
    }
}
