package ejercicio24;

/**
 * Created by Alejandro on 22/02/2016.
 */
public class Peluche extends Juguete {
    boolean habla;
    private Tamanho tamanho;

    public Peluche(String nombre, String color, boolean habla, Tamanho tamanho) throws NombreIncorrectoException {
        super(nombre, color);
        this.habla = habla;
        this.tamanho = tamanho;
    }


    public float calcuarValorEconomico() {
        return tamanho.getValor();
    }


    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Peluche)
            if (super.equals(o) && habla == ((Peluche) o).habla && tamanho == ((Peluche) o).tamanho)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Tamaño: %s] [Valor económico: %.2f]", super.toString(), tamanho, calcuarValorEconomico());
    }
}
