package es.iessaladillo.iessaladillo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alejandro on 28/04/2017.
 */

public class Aula {

    @SerializedName("planta")
    @Expose
    private Byte planta;
    @SerializedName("codAula")
    @Expose
    private Short codAula;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Byte getPlanta() {
        return planta;
    }

    public void setPlanta(Byte planta) {
        this.planta = planta;
    }

    public Short getCodAula() {
        return codAula;
    }

    public void setCodAula(Short codAula) {
        this.codAula = codAula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
