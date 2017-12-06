package ejercicio24In;

/**
 * Created by Alejandro on 22/02/2016.
 */
public class PuestoFeria {
    public static void main(String[] args) {
        Peluche p1, p2, p1clon;
        Munheca m1, m2, m1clon;
        Chucheria c1, c2, c1clon;

        try {
            System.out.println("--------------------CHUCHERÍAS--------------------");
            c1 = new Chucheria("Chocolate");
            c2 = new Chucheria("Caramelo");
            c1clon = (Chucheria) c1.clone();
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c1clon);
            System.out.println(c1.equals(c2)?"Los productos son iguales":"Los productos no son iguales");
            System.out.println(c1.equals(c1clon)?"Los clones son iguales":"Los clones no son iguales");


            System.out.println("\n\n--------------------PELUCHES--------------------");
            p1 = new Peluche("Ochinchin", "Negro negro", true, Tamanho.GRANDE);
            p2 = new Peluche("Teddy", "Marrón", true, Tamanho.MEDIANO);
            p1clon = (Peluche) p1.clone();
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p1clon);
            System.out.println(p1.equals(p2)?"Los productos son iguales":"Los productos no son iguales");
            System.out.println(p1.equals(p1clon)?"Los clones son iguales":"Los clones no son iguales");


            System.out.println("\n\n--------------------MUÑECAS--------------------");
            m1 = new Munheca("LatinoCaliente", "Latino", false, 2.5f);
            m2 = new Munheca("DEADPOOL", "Rojinegro", false, 3);
            m1clon = (Munheca) m1.clone();
            System.out.println(m1);
            System.out.println(m2);
            //m1clon.b.comer(4);
            System.out.println(m1clon);
            System.out.println(m1.equals(m2)?"Los productos son iguales":"Los productos no son iguales");
            System.out.println(m1.equals(m1clon)?"Los clones son iguales":"Los clones no son iguales");
        } catch (NombreIncorrectoException e) {
            System.out.println(e.getMessage());
        }
    }
}
