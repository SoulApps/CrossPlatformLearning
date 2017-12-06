package ejercicio24In;

/**
 * Created by Alejandro on 22/02/2016.
 */
public enum Tamanho {
    PEQUENHO(2), MEDIANO(5), GRANDE(7);


    private float valor;

    Tamanho(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }
}
