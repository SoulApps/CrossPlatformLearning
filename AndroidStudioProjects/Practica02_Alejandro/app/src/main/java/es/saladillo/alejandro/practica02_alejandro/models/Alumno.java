package es.saladillo.alejandro.practica02_alejandro.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alejandro on 25/02/2017.
 */

public class Alumno implements Parcelable {

    private long id;
    private String nombre;
    private String telefono;
    private String email;
    private String empresa;
    private String tutor;
    private String horario;
    private String direccion;
    private String imagen;

    public Alumno(long id, String nombre, String telefono, String email, String empresa, String tutor, String horario, String direccion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.empresa = empresa;
        this.tutor = tutor;
        this.horario = horario;
        this.direccion = direccion;
        this.imagen = imagen;
    }

    public Alumno(String nombre, String telefono, String email, String empresa, String tutor, String horario, String direccion, String imagen) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.empresa = empresa;
        this.tutor = tutor;
        this.horario = horario;
        this.direccion = direccion;
        this.imagen = imagen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.nombre);
        dest.writeString(this.telefono);
        dest.writeString(this.email);
        dest.writeString(this.empresa);
        dest.writeString(this.tutor);
        dest.writeString(this.horario);
        dest.writeString(this.direccion);
        dest.writeString(this.imagen);
    }

    protected Alumno(Parcel in) {
        this.id = in.readLong();
        this.nombre = in.readString();
        this.telefono = in.readString();
        this.email = in.readString();
        this.empresa = in.readString();
        this.tutor = in.readString();
        this.horario = in.readString();
        this.direccion = in.readString();
        this.imagen = in.readString();
    }

    public static final Parcelable.Creator<Alumno> CREATOR = new Parcelable.Creator<Alumno>() {
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
