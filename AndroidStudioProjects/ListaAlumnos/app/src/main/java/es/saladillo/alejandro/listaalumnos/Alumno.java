package es.saladillo.alejandro.listaalumnos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alejandro on 25/10/2016.
 */

public class Alumno implements Parcelable {

    private String nombre;
    private int edad;
    private boolean repetidor;
    private int imagen;

    public Alumno(String nombre, int edad, boolean repetidor, int imagen) {
        this.nombre = nombre;
        this.edad = edad;
        this.repetidor = repetidor;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", repetidor=" + repetidor +
                '}';
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

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.edad);
        dest.writeByte(this.repetidor ? (byte) 1 : (byte) 0);
        dest.writeInt(this.imagen);
    }

    protected Alumno(Parcel in) {
        this.nombre = in.readString();
        this.edad = in.readInt();
        this.repetidor = in.readByte() != 0;
        this.imagen = in.readInt();
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
