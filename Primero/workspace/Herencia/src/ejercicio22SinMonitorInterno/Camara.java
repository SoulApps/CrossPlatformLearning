package ejercicio22SinMonitorInterno;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class Camara extends Dispositivo {
    private boolean esReflex;
    private boolean esDigital;

    public Camara(String marca, String modelo, int stock, int capacidad, boolean esReflex, boolean esDigital) {
        super(marca, modelo, stock, capacidad);
        this.esReflex = esReflex;
        this.esDigital = esDigital;
    }


    public boolean isEsReflex() {
        return esReflex;
    }

    public void setEsReflex(boolean esReflex) {
        this.esReflex = esReflex;
    }

    public boolean isEsDigital() {
        return esDigital;
    }

    public void setEsDigital(boolean esDigital) {
        this.esDigital = esDigital;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Camara)
            if (super.equals(o) && esReflex == ((Camara) o).esReflex && esDigital == ((Camara) o).esDigital)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Reflex: %s] [Digital: %s]", super.toString(), esReflex?"Sí":"No", esDigital?"Sí":"No");
    }
}
