package ejercicio18;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class Huevo {
    private String nombre;
    private Yema y;
    private Clara c;

    public Huevo() {
        nombre = "Huevo";
        y = new Yema();
        c = new Clara();
    }

    public String toString() {
        return String.format("Hola soy un huevo y me llamo %s, mi yema se llama %s y mi clara se llama %s", this.nombre, y.nombre, c.nombre);
    }

    public class Yema {
        private String nombre = "Yema";

        private Yema() {
            nombre = "Yema";
        }
    }

    public class Clara {
        private String nombre = "Clara";

        private Clara() {
            nombre = "Clara";
        }
    }
}
