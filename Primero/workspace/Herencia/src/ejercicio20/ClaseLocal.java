package ejercicio20;

/**
 * Created by Alejandro on 01/04/2016.
 */
//Es una clase interna en un método
public class ClaseLocal {
    public int numero=0;
    public ClaseLocal(int numero){
        this.numero=numero;
    }
    public String muestraContenido(){
        class Mostrador{
            public String muestraDato(){
                return "Número = "+numero;
            }
        }
        Mostrador m = new Mostrador();
        return m.muestraDato();
    }
}
