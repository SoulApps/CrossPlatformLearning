package ejercicio19;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class VerClaseInterna {
    public static void main(String args[]){
        Contenedor c1 = new Contenedor(34);
        Contenedor.Contenido i1 = c1.new Contenido(23);
        System.out.println(c1.muestraContenedor(i1)); //34, 23
        c1.numero=50;
        System.out.println(i1.muestraContenido()); //50, 23
        i1.numero2=25;
        System.out.println(c1.muestraContenedor(i1)); // 50, 25
        i1.numero2=65;
        System.out.println(i1.muestraContenido()); //50, 65
        //Se puede acceder directamente a los atributos de Contenido al ser públicos
    }
}
