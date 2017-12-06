package es.iessaladillo.iessaladillo.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alejandro on 08/05/2017.
 */

public class Hardware implements Parcelable {

    @SerializedName("codBarras")
    @Expose
    private String codBarras;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("unidadesTotales")
    @Expose
    private Short unidadesTotales;

    @SerializedName("unidadesEnUso")
    @Expose
    private Short unidadesEnUso;

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getUnidadesTotales() {
        return unidadesTotales;
    }

    public void setUnidadesTotales(Short unidadesTotales) {
        this.unidadesTotales = unidadesTotales;
    }

    public Short getUnidadesEnUso() {
        return unidadesEnUso;
    }

    public void setUnidadesEnUso(Short unidadesEnUso) {
        this.unidadesEnUso = unidadesEnUso;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.codBarras);
        dest.writeString(this.descripcion);
        dest.writeValue(this.unidadesTotales);
        dest.writeValue(this.unidadesEnUso);
    }

    public Hardware() {
    }

    protected Hardware(Parcel in) {
        this.codBarras = in.readString();
        this.descripcion = in.readString();
        this.unidadesTotales = (Short) in.readValue(Short.class.getClassLoader());
        this.unidadesEnUso = (Short) in.readValue(Short.class.getClassLoader());
    }

    public static final Creator<Hardware> CREATOR = new Creator<Hardware>() {
        @Override
        public Hardware createFromParcel(Parcel source) {
            return new Hardware(source);
        }

        @Override
        public Hardware[] newArray(int size) {
            return new Hardware[size];
        }
    };
}
