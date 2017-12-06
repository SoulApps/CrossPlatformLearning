package clases;

/**
 * Created by Alejandro on 16/02/2017.
 */
public class Articulos {
    int codarti;
    String denom;
    int stock;
    float pvp;

    Articulos(int codarti, String denom, int stock, float pvp) {
        this.codarti = codarti;
        this.denom = denom;
        this.stock = stock;
        this.pvp = pvp;
    }

    public String toString() {
        return "Clientes{" +
                "codarti=" + codarti +
                ", denom='" + denom + '\'' +
                ", stock=" + stock +
                ", pvp=" + pvp +
                '}';
    }
}
