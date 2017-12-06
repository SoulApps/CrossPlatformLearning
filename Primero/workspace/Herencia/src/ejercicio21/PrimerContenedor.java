package ejercicio21;

/**
 * Created by Alejandro on 01/04/2016.
 */
//Es una clase interna estática
public class PrimerContenedor {
    public int numero=0;
    static public int numero3=13;
    public PrimerContenedor(int numero){
        this.numero=numero;
    }
    public String muestraContenedor(Contenido refCont){
        return "Nº contenedor= "+numero+"Nº contenido= "+refCont.numero2;
    }
    static class Contenido{
        public int numero2;
        public Contenido(int numero){
            numero2=numero;
        } public String muestraContenido(){
            return "Nº contenedor= "+numero3+" Nº contenido= "+numero2;
        }
    }
}
