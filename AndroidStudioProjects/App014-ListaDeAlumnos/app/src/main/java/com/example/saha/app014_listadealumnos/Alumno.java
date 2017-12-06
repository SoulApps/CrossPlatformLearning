package com.example.saha.app014_listadealumnos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Saha on 08/11/2016.
 */

public class Alumno implements Parcelable {

    int imagen;
    String nombre;
    int edad ;
    boolean repetidor;

    public Alumno(int imagen,String nombre, int edad,boolean repetidor){
        this.imagen=imagen;
        this.nombre=nombre;
        this.edad=edad;
        this.repetidor=repetidor;
    }

    protected Alumno(Parcel in) {
        imagen = in.readInt();
        nombre = in.readString();
        edad = in.readInt();
        repetidor = in.readByte() != 0;
    }

    public static final Creator<Alumno> CREATOR = new Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel in) {
            return new Alumno(in);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imagen);
        parcel.writeString(nombre);
        parcel.writeInt(edad);
        parcel.writeByte((byte) (repetidor ? 1 : 0));
    }
    public void readFromParcel(Parcel in) {
        imagen=in.readInt();
        nombre = in.readString();
        edad = in.readInt();
        repetidor=in.readByte()!=0;
    }
}
