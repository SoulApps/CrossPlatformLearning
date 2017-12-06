package examenHerencia;


/**
 * Created by Alejandro on 07/03/2016.
 */
public abstract class Persona implements Cloneable, Personable {
    protected String nombre;
    protected boolean validado;

    public Persona(String nombre) throws NombreIncorrectoException {
        setNombre(nombre);
        validado = false;
    }


    public abstract String tipo_numero();

    public void validar() {
        validado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreIncorrectoException {
        if (nombre.matches("([A-ZÑÁÉÍÓÚ][a-zñáéíóú]+( [a-zñáéíóú]+)*[ ]?){3}"))
            this.nombre = nombre;
        else
            throw new NombreIncorrectoException("¡ERROR! ¡Nombre incorrecto!");
    }


    public Object clone() {
        Persona p;

        try {
            p = (Persona) super.clone();
        } catch (CloneNotSupportedException e) {
            p = null;
        }

        return p;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if  (o instanceof Persona)
            if (nombre.equals(((Persona) o).nombre))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("[Nombre: %s] [Validado: %s]", nombre, validado?"Sí":"No");
    }
}
