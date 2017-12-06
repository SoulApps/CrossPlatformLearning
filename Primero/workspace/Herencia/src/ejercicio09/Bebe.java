package ejercicio09;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Bebe {
    Bebe(int i){
        this("Soy un bebe consentido");
        System.out.println("Hola, tengo " + i + " meses");
    } Bebe(String s){
        System.out.println(s);
    } void berrea(){
        System.out.println("Buaaaaaaaaa");
    }


    public static void main(String[] args){
        new Bebe(8).berrea(); //Soy un bebe consentido \n Hola, tengo 8 meses \n Buaaaaaaaaa
    }
}
