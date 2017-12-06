package ejercicio08;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Test {
    public int dato=0;
    public static int datostatico=0;
    public void metodo() {this.datostatico++;} //El this no tiene sentido porque es estático.
    public static void metodostatico(){
        //this.datostatico++; //El this se usa en cosas dinámicas, por lo que un this no puede aparecer en un método estático.
        datostatico++;
    }

    public static void main(String [] args){
        //No se ha creado ningún objeto.
        //dato++; //Dato es dinámico.
        datostatico++;
        metodostatico();
        //metodo(); //metodo() es dinámico.
    }
}
