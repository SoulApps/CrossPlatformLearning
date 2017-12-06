package es.saladillo.alejandro.examenmultihilo_alejandro.models;

import java.util.Locale;

/**
 * Created by Alejandro on 01/03/2017.
 */

public class Resultado {

    private Float eur;
    private Float gbp;
    private Float usd;
    private Float jpy;

    //El constructor calcula el cambio de la cantidad y las almacena en sus propias variables.
    public Resultado(Float cantidad, Float eur, Float gbp, Float usd, Float jpy) {
        if (eur != null)
            this.eur = cantidad * eur;
        else
            this.eur = cantidad;

        if (gbp != null)
            this.gbp = cantidad * gbp;
        else
            this.gbp = cantidad;

        if (usd != null)
            this.usd = cantidad * usd;
        else
            this.usd = cantidad;

        if (jpy != null)
            this.jpy = cantidad * jpy;
        else
            this.jpy = cantidad;
    }

    public Float getGBP() {
        return gbp;
    }

    public void setGBP(Float gBP) {
        this.gbp = gBP;
    }

    public Float getJPY() {
        return jpy;
    }

    public void setJPY(Float jPY) {
        this.jpy = jPY;
    }

    public Float getEUR() {
        return eur;
    }

    public void setEUR(Float eUR) {
        this.eur = eUR;
    }

    public Float getUsd() {
        return usd;
    }

    public void setUsd(Float usd) {
        this.usd = usd;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "%.2f EUR\n%.2f GPB\n%.2f USD\n%.2f JPY\n", eur, gbp, usd, jpy);
    }
}
