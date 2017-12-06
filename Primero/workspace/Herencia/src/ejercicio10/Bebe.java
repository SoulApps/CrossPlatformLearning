package ejercicio10;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Bebe {
    static void pedir(){
        System.out.println(str1 + " , " + str2 + " , " + str3);
    }
    static {
        str2 = "mama pipi";
        str3 = "mama agua";
    }
    Bebe() {
        System.out.println("Nacimiento del bebe"); }
    static String str2,str3,str1 = "papa tengo caca";
    public static void main(String[] args) {
        //Nacimiento de bebe * 3, uno por cada bebé creado;
        System.out.println("El bebe se ha despertado y va a pedir cosas");
        System.out.println("El bebe dice: " + Bebe.str1); //papa tengo caca
        Bebe.pedir(); //papa tengo caca , mama pipi , mama agua
    }
    static Bebe bebe1 = new Bebe();
    static Bebe bebe2 = new Bebe();
    static Bebe bebe3 = new Bebe();
}
