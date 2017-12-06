package es.saladillo.alejandro.examenmultihilo_alejandro.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alejandro on 01/03/2017.
 */

public class Rates {
    @SerializedName("GBP")
    @Expose
    private Float gBP;
    @SerializedName("JPY")
    @Expose
    private Float jPY;
    @SerializedName("EUR")
    @Expose
    private Float eUR;
    @SerializedName("USD")
    @Expose
    private Float uSD;

    public Float getGBP() {
        return gBP;
    }

    public void setGBP(Float gBP) {
        this.gBP = gBP;
    }

    public Float getJPY() {
        return jPY;
    }

    public void setJPY(Float jPY) {
        this.jPY = jPY;
    }

    public Float getEUR() {
        return eUR;
    }

    public void setEUR(Float eUR) {
        this.eUR = eUR;
    }

    public Float getUSD() {
        return uSD;
    }

    public void setUSD(Float uSD) {
        this.uSD = uSD;
    }
}
