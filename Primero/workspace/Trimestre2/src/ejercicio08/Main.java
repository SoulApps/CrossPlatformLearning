package ejercicio08;

/**
 * Created by Alejandro on 15/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Producto p = new Producto("111-KKKK", Procesador.INTEL, 5, 9.99f);
            System.out.println(p);
            p.setModelo("222-AAAA");
            p.disminuirStock();
            p.setProcesador(Procesador.AMD);
            System.out.println(p);
            p.setModelo("s");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
