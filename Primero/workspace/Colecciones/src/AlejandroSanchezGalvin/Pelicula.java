package AlejandroSanchezGalvin;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alejandro on 13/05/2016.
 */
public class Pelicula implements Cloneable, Comparable<Pelicula> {
    private Clave clave;
    private String nombre;
    private Date fechaEstreno;
    private Date fechaDVD;
    private static int numComedia = 0, numFiccion = 0, numTerror = 0;

    public Pelicula(String nombre, Genero genero, Date fechaEstreno, Date fechaDVD) {
        this.nombre = nombre;
        clave = asignarClave(genero);
        this.fechaEstreno = fechaEstreno;
        this.fechaDVD = fechaDVD;
    }

    public Clave asignarClave(Genero genero) {
        int numero;

        if (genero == Genero.COMEDIA)
            numero = ++numComedia;
        else if (genero == Genero.FICCION)
            numero = ++numFiccion;
        else
            numero = ++numTerror;

        return new Clave(genero, numero);
    }

    public int diferenciaDias() {
        final int DIA = 1000 * 60 * 60 * 24;
        return (int) (((fechaDVD.getTime() - fechaEstreno.getTime())) / DIA);
    }


    public int compareTo(Pelicula o) {
        int comp = o.diferenciaDias() - diferenciaDias();

        if (comp == 0)
            comp = nombre.compareTo(o.nombre);

        return comp;
    }


    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public Clave getClave() {
        return clave;
    }

    public Object clone() {
        Pelicula p;

        try {
            p = (Pelicula) super.clone();
            p.clave = (Clave) clave.clone();
            p.fechaEstreno = (Date) fechaEstreno.clone();
            p.fechaDVD = (Date) fechaDVD.clone();
        } catch (CloneNotSupportedException e) {
            p = null;
        }

        return p;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Pelicula)
            if (clave.equals(((Pelicula) o).clave) && nombre.equals(((Pelicula) o).nombre) && fechaEstreno.equals(((Pelicula) o).fechaEstreno) && fechaDVD.equals(((Pelicula) o).fechaDVD))
                igual = true;

        return igual;
    }

    public int hashCode() {
        return clave.hashCode() + nombre.hashCode() + fechaEstreno.hashCode() + fechaDVD.hashCode();
    }

    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-10s %-40s Clave: %-5s Fecha estreno: %-15s Fecha DVD: %s", clave.getGenero(), nombre, clave, formato.format(fechaEstreno), formato.format(fechaDVD));
    }
}
