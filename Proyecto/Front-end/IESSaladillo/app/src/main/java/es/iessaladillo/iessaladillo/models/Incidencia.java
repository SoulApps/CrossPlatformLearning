package es.iessaladillo.iessaladillo.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alejandro on 08/05/2017.
 */

public class Incidencia implements Parcelable {

    @SerializedName("codIncidencia")
    @Expose
    private Integer codIncidencia;

    @SerializedName("planta")
    @Expose
    private Byte planta;

    @SerializedName("codAula")
    @Expose
    private Short codAula;

    @SerializedName("codMaterial")
    @Expose
    private Integer codMaterial;

    @SerializedName("codProf")
    @Expose
    private Integer codProf;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("apellido1")
    @Expose
    private String apellido1;

    @SerializedName("fecha")
    @Expose
    private Date fecha;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("historial")
    @Expose
    private String historial;

    @SerializedName("estado")
    @Expose
    private EstadoIncidencia estado;

    public Incidencia() {
    }

    public Incidencia(Integer codProf, Integer codMaterial, String descripcion) {
        this.codProf = codProf;
        this.codMaterial = codMaterial;
        this.descripcion = descripcion;
        this.fecha = new Date();
    }

    public Integer getCodIncidencia() {
        return codIncidencia;
    }

    public void setCodIncidencia(Integer codIncidencia) {
        this.codIncidencia = codIncidencia;
    }

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

    public Integer getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Integer codMaterial) {
        this.codMaterial = codMaterial;
    }

    public Integer getCodProf() {
        return codProf;
    }

    public void setCodProf(Integer codProf) {
        this.codProf = codProf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public EstadoIncidencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidencia estado) {
        this.estado = estado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.codIncidencia);
        dest.writeValue(this.planta);
        dest.writeValue(this.codAula);
        dest.writeValue(this.codMaterial);
        dest.writeValue(this.codProf);
        dest.writeString(this.nombre);
        dest.writeString(this.apellido1);
        dest.writeValue(this.fecha);
        dest.writeString(this.descripcion);
        dest.writeString(this.historial);
        dest.writeInt(this.estado == null ? -1 : this.estado.ordinal());
    }

    protected Incidencia(Parcel in) {
        this.codIncidencia = (Integer) in.readValue(Integer.class.getClassLoader());
        this.planta = (Byte) in.readValue(Byte.class.getClassLoader());
        this.codAula = (Short) in.readValue(Short.class.getClassLoader());
        this.codMaterial = (Integer) in.readValue(Integer.class.getClassLoader());
        this.codProf = (Integer) in.readValue(Integer.class.getClassLoader());
        this.nombre = in.readString();
        this.apellido1 = in.readString();
        this.fecha = (Date) in.readValue(Date.class.getClassLoader());
        this.descripcion = in.readString();
        this.historial = in.readString();
        int tmpEstado = in.readInt();
        this.estado = tmpEstado == -1 ? null : EstadoIncidencia.values()[tmpEstado];
    }

    public static final Parcelable.Creator<Incidencia> CREATOR = new Parcelable.Creator<Incidencia>() {
        @Override
        public Incidencia createFromParcel(Parcel source) {
            return new Incidencia(source);
        }

        @Override
        public Incidencia[] newArray(int size) {
            return new Incidencia[size];
        }
    };
}
