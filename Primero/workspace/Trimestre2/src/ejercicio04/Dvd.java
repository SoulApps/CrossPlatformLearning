package ejercicio04;

/**
 * Created by Alejandro on 13/01/2016.
 */
public class Dvd {

    private String tituloTrad;
    private String tituloOrig;
    private String director;
    private String actoresDestacados;
    private Genero g;
    private int duracion;
    private String resumen;
    private boolean miedo;


    public Dvd(String tituloTrad, String tituloOrig, String director, String actoresDestacados, Genero g, int duracion, String resumen, boolean miedo) {
        this.tituloTrad = tituloTrad;
        this.tituloOrig = tituloOrig;
        this.director = director;
        this.actoresDestacados = actoresDestacados;
        this.g = g;
        this.duracion = duracion;
        this.resumen = resumen;
        this.miedo = miedo;
    }

    public boolean esThriller() {
        boolean thriller = false;
        if (miedo)
            thriller = true;
        else
            thriller = false;
        return thriller;
    }

    public boolean tieneResumen() {
        return !resumen.trim().equals("");
    }

    public String muestraDuracion() {
        return duracion + " min";
    }

    public String toString() {
        return String.format("%s (%s)%nDe: %s%nCon: %s%n%s-%s%s%n%s%n%s", tituloTrad, tituloOrig, director, actoresDestacados, g, muestraDuracion(), tieneResumen()?"\nResumen: " + resumen:"", esThriller()?"Es thriller":"No es thriller", tieneResumen()?"Tiene resumen":"No tiene resumen");
    }
}
