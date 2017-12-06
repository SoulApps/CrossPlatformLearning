package ejercicio05;

/**
 * Created by Alejandro on 13/01/2016.
 */
public class Alimento {
    private String nombre;
    private float lipidos = 0;
    private float carbono = 0;
    private float proteinas = 0;
    private boolean animal = false;
    private Nivel vitaminas = Nivel.MEDIO;
    private Nivel minerales = Nivel.MEDIO;

    public Alimento(String nombre) {
        this.nombre = nombre;
    }

    public Alimento(String nombre, float lipidos, float carbono, float proteinas, boolean animal, Nivel vitaminas, Nivel minerales) {
        this.nombre = nombre;
        this.lipidos = lipidos;
        this.carbono = carbono;
        this.proteinas = proteinas;
        this.animal = animal;
        this.vitaminas = vitaminas;
        this.minerales = minerales;
    }

    public boolean esDietetico() {
        boolean dietetico = false;
        if (lipidos < 20 && vitaminas != Nivel.BAJO)
            dietetico = true;
        return dietetico;
    }

    public float calculaContenidoEnergetico() {
        float kcal = 0;
        kcal = (lipidos / 100 * 9.4f) + (carbono / 100 * 4.1f) + (proteinas / 100 * 5.3f);
        return kcal;
    }

    public boolean esRecomendableParaDeportistas() {
        boolean recomendable = false;
        if (proteinas >= 10 && proteinas <= 15 && lipidos >= 30 && lipidos <= 35 && carbono >= 55 && carbono <= 65)
            recomendable = true;
        return  recomendable;
    }

    public String toString() {
        return String.format("[Nombre: %s][Lípidos: %.2f] [Hidratos de carbono: %.2f] [ Proteínas: %.2f] [Origen animal: %s] [Vitaminas: %c] [Minerales: %c]", nombre, lipidos, carbono, proteinas, animal?"Sí":"No", vitaminas.getNivel(), minerales.getNivel());
    }

}
