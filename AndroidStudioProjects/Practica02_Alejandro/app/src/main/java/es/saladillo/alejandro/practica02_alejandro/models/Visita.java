package es.saladillo.alejandro.practica02_alejandro.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alejandro on 25/02/2017.
 */

public class Visita implements Parcelable {

    private long id;
    private long idAlumno;
    private long fecha;
    private String horaInicio;
    private String horaFin;
    private String resumen;

    public Visita(long idAlumno, long fecha, String horaInicio, String horaFin, String resumen) {
        this.idAlumno = idAlumno;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.resumen = resumen;
    }

    public Visita(long id, long idAlumno, long fecha, String horaInicio, String horaFin, String resumen) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.resumen = resumen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.idAlumno);
        dest.writeLong(this.fecha);
        dest.writeString(this.horaInicio);
        dest.writeString(this.horaFin);
        dest.writeString(this.resumen);
    }

    protected Visita(Parcel in) {
        this.id = in.readLong();
        this.idAlumno = in.readLong();
        this.fecha = in.readLong();
        this.horaInicio = in.readString();
        this.horaFin = in.readString();
        this.resumen = in.readString();
    }

    public static final Parcelable.Creator<Visita> CREATOR = new Parcelable.Creator<Visita>() {
        @Override
        public Visita createFromParcel(Parcel source) {
            return new Visita(source);
        }

        @Override
        public Visita[] newArray(int size) {
            return new Visita[size];
        }
    };
}
