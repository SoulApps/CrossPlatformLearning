package es.saladillo.alejandro.examen_alejandro.models;

/**
 * Created by Alejandro on 25/02/2017.
 */

public class Libro {

   private long id;
   private String titulo;
   private String autor;
   private int publicacion;
   private String portada;
   private String sinopsis;

   public Libro(long id, String titulo, String autor, int publicacion, String portada, String sinopsis) {
      this.id = id;
      this.titulo = titulo;
      this.autor = autor;
      this.publicacion = publicacion;
      this.portada = portada;
      this.sinopsis = sinopsis;
   }

    public Libro(String titulo, String autor, int publicacion, String portada, String sinopsis) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.portada = portada;
        this.sinopsis = sinopsis;
    }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String getAutor() {
      return autor;
   }

   public void setAutor(String autor) {
      this.autor = autor;
   }

   public int getPublicacion() {
      return publicacion;
   }

   public void setPublicacion(int publicacion) {
      this.publicacion = publicacion;
   }

   public String getPortada() {
      return portada;
   }

   public void setPortada(String portada) {
      this.portada = portada;
   }

   public String getSinopsis() {
      return sinopsis;
   }

   public void setSinopsis(String sinopsis) {
      this.sinopsis = sinopsis;
   }
}
