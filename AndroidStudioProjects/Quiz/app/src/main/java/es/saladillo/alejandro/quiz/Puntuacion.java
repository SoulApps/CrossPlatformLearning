package es.saladillo.alejandro.quiz;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Alejandro on 03/12/2016.
 */

public class Puntuacion implements Parcelable {

    private Date fecha;
    private int puntos;

    public Puntuacion(int puntos) {
        fecha = new Date();
        this.puntos = puntos;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.fecha != null ? this.fecha.getTime() : -1);
        dest.writeInt(this.puntos);
    }

    protected Puntuacion(Parcel in) {
        long tmpFecha = in.readLong();
        this.fecha = tmpFecha == -1 ? null : new Date(tmpFecha);
        this.puntos = in.readInt();
    }

    public static final Parcelable.Creator<Puntuacion> CREATOR = new Parcelable.Creator<Puntuacion>() {
        @Override
        public Puntuacion createFromParcel(Parcel source) {
            return new Puntuacion(source);
        }

        @Override
        public Puntuacion[] newArray(int size) {
            return new Puntuacion[size];
        }
    };
}
