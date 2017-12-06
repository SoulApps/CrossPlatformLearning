package ejercicio15;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        Producto a = new Alfareria(2, "Alfo", false, "Cartón", 10.45);
        Producto p = new Planta(1, "\"Hierbas medicinales\"", true, false, true);

        dameDatos(a);
        dameDatos(p);
    }

    public static void dameDatos(Mercancia producto) {
        System.out.printf("[Descripción: %s] [Precio: %.2f] ", producto.dameDescripcion(), producto.damePrecio());
        if (producto instanceof MercanciaViva)
            System.out.printf("[Regada: %s] [Hambre: %s]%n", ((MercanciaViva) producto).necesitaRiego()?"Sí":"No", ((MercanciaViva) producto).necesitaComida()?"Necesita comida":"No necesita comida");
        if (producto instanceof MercanciaFragil)
            System.out.printf("[Embalaje: %s] [Peso: %f]%n", ((MercanciaFragil) producto).dameEmbalaje(), ((MercanciaFragil) producto).damePeso());
    }
}
