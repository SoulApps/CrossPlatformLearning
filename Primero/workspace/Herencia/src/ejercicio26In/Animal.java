package ejercicio26In;

import java.util.Arrays;

/**
 * Created by Alejandro on 23/02/2016.
 */
public abstract class Animal implements Cloneable, Comunicarse {
    protected String nombre;
    protected double cuota;
    protected String raza;
    protected boolean enfadado;
    protected String codigo;
    protected Cria crias[] = new Cria[5];

    public Animal(String nombre, double cuota, String raza, boolean enfadado) {
        this.nombre = nombre;
        this.cuota = cuota;
        this.raza = raza;
        this.enfadado = enfadado;
    }


    public void enfadarse() {
        enfadado = true;
    }

    public void analizar() {
        if (enfadado)
            enfadado = false;
    }


    public class Cria implements Cloneable {
        private String nombre;

        public Cria(String nombre) {
            this.nombre = nombre;
        }


        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }


        public Object clone() {
            Cria c;

            try {
                c = (Cria) super.clone();
            } catch (CloneNotSupportedException e) {
                c = null;
            }

            return c;
        }

        public boolean equals(Object o) {
            boolean igual = false;

            if (o instanceof Cria)
                if (nombre.equals(((Cria) o).nombre))
                    igual = true;

            return igual;
        }


        public String toString() {
            return String.format("[Nombre: %s]", nombre);
        }
    }


    public Object clone() {
        int i;
        Animal a;

        try {
            a = (Animal) super.clone();
            a.crias = crias.clone();

            for (i = 0; i < crias.length; i++)
                a.crias[i] = (Cria) crias[i].clone();
        } catch (CloneNotSupportedException e) {
            a = null;
        }

        return a;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Animal)
            if (nombre.equals(((Animal) o).nombre) && cuota == ((Animal) o).cuota && raza.equals(((Animal) o).raza) &&
                    Arrays.equals(crias, ((Animal) o).crias) && codigo.equals(((Animal) o).codigo))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Nombre: %s] [Cuota: %.2f] [Raza: %s]", codigo, nombre, cuota, raza);
    }
}
