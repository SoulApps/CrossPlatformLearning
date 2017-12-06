package ejercicio22SinMonitorInterno;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class Tienda {
    public static void main(String[] args) {
        Sobremesa s1, s2, s1clon;
        Portatil p1, p2, p1clon;
        Movil m1, m2, m1clon;
        Camara c1, c2, c1clon;

        System.out.println("---------SOBREMESAS---------");
        s1 = new Sobremesa("Latino", "Caliente", 1, 6.9, 6969696, "Ochinchin Daisuki Plus", 4096);
        s2 = new Sobremesa("HP", "Pavilion", 5, 2.3, 1024, "BenQ", 1080);
        s1clon = (Sobremesa) s1.clone();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1clon);
        System.out.println(s1.equals(s2)? "Los productos son iguales":"Los productos no son iguales");
        System.out.println(s1.equals(s1clon)?"Los clones son iguales":"Los clones no son iguales");
        s1clon.getMonitor().setMarcaMonitor("Charmander"); //Solo cambio la marca del monitor
        System.out.println(s1);
        System.out.println(s1clon);
        System.out.println(s1.equals(s1clon)?"Los clones son iguales":"Los clones no son iguales");

        System.out.println("\n\n---------PORTÁTILES---------");
        p1 = new Portatil("HP", "Pavilion", 5, 2.3, 1024, 2);
        p2 = new Portatil("HP", "Pavilion", 10, 2.3, 1024, 2);
        p1clon = (Portatil) p1.clone();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1clon);
        p1clon = (Portatil) p1.clone();
        System.out.println(p1.equals(p2)?"Los productos son iguales":"Los productos no son iguales");
        System.out.println(p1.equals(p1clon)?"Los clones son iguales":"Los clones no son iguales");
        p1clon.setMarca("Derp");
        System.out.println(p1);
        System.out.println(p1clon);
        System.out.println(p1.equals(p1clon)?"Los clones son iguales":"Los clones no son iguales");

        System.out.println("\n\n---------MÓVILES---------");
        m1 = new Movil("Samsung", "Galaxy", 5, 16, true);
        m2 = new Movil("Apple", "iPhone", 10, 64, true);
        m1clon = (Movil) m1.clone();
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m1clon);
        m1clon = (Movil) m1.clone();
        System.out.println(m1.equals(m2)?"Los productos son iguales":"Los productos no son iguales");
        System.out.println(m1.equals(m1clon)?"Los clones son iguales":"Los clones no son iguales");
        m1clon.setMarca("Ladrillo");
        m1clon.setModelo("Chuck Norris©");
        System.out.println(m1);
        System.out.println(m1clon);
        System.out.println(m1.equals(m1clon)?"Los clones son iguales":"Los clones no son iguales");

        System.out.println("\n\n---------CÁMARAS---------");
        c1 = new Camara("Nikon", "N400", 5, 8, true, true);
        c2 = new Camara("Canon", "C250F", 10, 4, true, true);
        c1clon = (Camara) c1.clone();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1clon);
        c1clon = (Camara) c1.clone();
        System.out.println(c1.equals(c2)?"Los productos son iguales":"Los productos no son iguales");
        System.out.println(c1.equals(c1clon)?"Los clones son iguales":"Los clones no son iguales");
        c1clon.setMarca("Kamara de juguete der Xino");
        System.out.println(c1);
        System.out.println(c1clon);
        System.out.println(c1.equals(m1clon)?"Los clones son iguales":"Los clones no son iguales");

    }
}
