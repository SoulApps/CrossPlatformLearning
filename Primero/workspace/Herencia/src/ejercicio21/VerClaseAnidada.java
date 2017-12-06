package ejercicio21;

/**
 * Created by Alejandro on 01/04/2016.
 */
public class VerClaseAnidada {
    public static void main(String args[]){
        PrimerContenedor.Contenido i1=new PrimerContenedor.Contenido(29);
        i1.numero2=25;
        System.out.println(i1.muestraContenido());
        PrimerContenedor c1 = new PrimerContenedor(34);
        System.out.println(c1.muestraContenedor(i1));
    }
}
