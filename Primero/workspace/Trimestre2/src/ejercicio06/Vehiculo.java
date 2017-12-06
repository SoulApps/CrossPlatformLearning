package ejercicio06;

/**
 * Created by Alejandro on 14/01/2016.
 */
public class Vehiculo {
    private String modelo;
    private double potencia;
    private boolean cRuedas;

    public Vehiculo(String modelo) {
        this.modelo = modelo;
    }

    public double getPotencia() {
        return potencia;
    }
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public boolean getcRuedas() {
        return cRuedas;
    }
    public void setcRuedas(boolean cRuedas) {
        this.cRuedas = cRuedas;
    }

    public String toString() {
        return String.format("[Modelo %s] [Potencia: %.2f] [Tracción a las 4 ruedas: %s]", modelo, getPotencia(), (getcRuedas())?"Sí":"No");
    }
}
