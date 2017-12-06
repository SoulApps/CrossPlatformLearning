package ejercicio02a;

/**
 * Created by Alejandro on 13/01/2016.
 */
public class Clase {
    private String privado = "Privado";
    protected String protegido = "Protegido";
    public String publico = "Público";
    String friendly = "Friendly";

    public static void main(String[] args) {
        Clase c = new Clase();
        System.out.println(c.privado);
        System.out.println(c.protegido);
        System.out.println(c.publico);
        System.out.println(c.friendly);
    }
}
