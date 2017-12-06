package es.iessaladillo.iessaladillo.models;

import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alejandro on 18/04/2017.
 */

public class Profesor {

    @SerializedName("codProf")
    @Expose
    private Integer codProf;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("tipo")
    @Expose
    private Tipo tipo;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellido1")
    @Expose
    private String apellido1;
    @SerializedName("apellido2")
    @Expose
    private String apellido2;
    @SerializedName("token")
    @Expose
    private String token;

    private Uri foto;

    public Integer getCodProf() {
        return codProf;
    }

    public void setCodProf(Integer codProf) {
        this.codProf = codProf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Uri getFoto() {
        return foto;
    }

    public void setFoto(Uri foto) {
        this.foto = foto;
    }
}
