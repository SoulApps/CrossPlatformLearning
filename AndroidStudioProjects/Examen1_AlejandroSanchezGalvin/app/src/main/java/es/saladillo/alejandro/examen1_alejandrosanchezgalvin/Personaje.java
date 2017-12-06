package es.saladillo.alejandro.examen1_alejandrosanchezgalvin;

/**
 * Created by Alejandro on 13/12/2016.
 */

public class Personaje {

    private String nombre;
    private String interprete;
    private String urlPoster;
    private boolean principal;
    private int aparicion;
    private String descripcion;

    public Personaje(String nombre, String interprete, String urlPoster, boolean principal, int aparicion, String descripcion) {
        this.nombre = nombre;
        this.interprete = interprete;
        this.urlPoster = urlPoster;
        this.principal = principal;
        this.aparicion = aparicion;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInterprete() {
        return interprete;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public int getAparicion() {
        return aparicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public void setUrlPoster(String urlPoster) {
        this.urlPoster = urlPoster;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public void setAparicion(int aparicion) {
        this.aparicion = aparicion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
