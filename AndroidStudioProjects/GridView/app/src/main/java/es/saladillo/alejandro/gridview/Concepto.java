package es.saladillo.alejandro.gridview;

/**
 * Created by Alejandro on 11/11/2016.
 */

public class Concepto {

    private final int foto;
    private final String spanish;
    private final String english;

    public Concepto(int foto, String spanish, String english) {
        this.foto = foto;
        this.spanish = spanish;
        this.english = english;
    }

    public int getFoto() {
        return foto;
    }

    public String getSpanish() {
        return spanish;
    }

    public String getEnglish() {
        return english;
    }
}
