package ejercicio13;

/**
 * Created by Alejandro on 04/02/2016.
 */
public abstract class Vehiculo {
    private int peso;
    public final void setPeso(int p){peso=p;}
    public abstract int getVelocidadActual();
    //Sí; no, porque setPeso es final y además peso es privado.
}
