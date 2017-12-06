package ejercicio07;

import ejercicio06.Circulo;
import ejercicio06.Forma;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class TestForma {
    public static void main(String[] args) {
        Forma f=new Circulo();
        f.identidad();
        Circulo c=new Circulo();
        ((Forma)c).identidad(); //Casting innecesario porque ambos tienen identidad y este método no es privado.
        ((Circulo)f).identidad(); //Casting innecesario porque ya es un Circulo.
        //Forma f2=new Forma(); //Forma es abstracto.
        //f2.identidad(); //Forma es abstracto.
        //(Forma)f.identidad(); //Casting inncecesario y faltan paréntesis antes del punto.
        f=c;
        //c=f; //No se puede asignar una forma a un círculo. Se podría con casting y siendo f un Circulo.
    }
}
