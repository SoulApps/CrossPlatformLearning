package es.saladillo.alejandro.arrayadapter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alejandro on 25/10/2016.
 */

public class Alumno implements Parcelable {

    private String nombre;
    private int edad;
    private boolean repetidor;

    public Alumno(String nombre, int edad, boolean repetidor) {
        this.nombre = nombre;
        this.edad = edad;
        this.repetidor = repetidor;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", repetidor=" + repetidor +
                '}';
    }

    public Alumno(Parcel in) {
        this.nombre = in.readString();
        this.edad = in.readInt();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isRepetidor() {
        return repetidor;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.edad);
    }

    public static final Creator<Alumno> CREATOR = new Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel source) {
            return new Alumno(source);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };
}
