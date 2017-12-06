package ejercicio22SinMonitorInterno;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class Portatil extends Ordenador {
    private double peso;

    public Portatil(String marca, String modelo, int stock, double procesador, int hdd, double peso) {
        super(marca, modelo, stock, procesador, hdd);
        this.peso = peso;
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Portatil)
            if (super.equals(o) && peso == ((Portatil) o).peso)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Peso: %.2f]", super.toString(), peso);
    }
}
