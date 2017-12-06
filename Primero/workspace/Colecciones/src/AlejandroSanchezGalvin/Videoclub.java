package AlejandroSanchezGalvin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alejandro on 13/05/2016.
 */
public class Videoclub {
    public static void main(String[] args) {
        //Colecciones
        LinkedHashSet<Pelicula> apartado1 = new LinkedHashSet<Pelicula>();
        TreeSet<Pelicula> apartado2 = new TreeSet<Pelicula>();
        TreeSet<Pelicula> apartado3 = new TreeSet<>(new Comparator<Pelicula>() {
                    public int compare(Pelicula o1, Pelicula o2) {
                        return o1.getFechaEstreno().compareTo(o2.getFechaEstreno());
                    }
        });
        TreeMap<Clave, Pelicula> apartado4 = new TreeMap<Clave, Pelicula>(new ComparadorClavePelicula());
        ListIterator<Pelicula> apartado5ListIterator;
        ArrayList<Pelicula> apartado5Lista;

        //Películas
        Pelicula p1, p2, p3, p4, p5, p6, p7, p8;
        p1 = new Pelicula("Poltergeist, juegos diabólicos", Genero.TERROR, convertirFecha("22/05/2015"), convertirFecha("22/09/2015"));
        p2 = new Pelicula("La cumbre escarlata", Genero.TERROR, convertirFecha("09/10/2015"), convertirFecha("12/02/2016"));
        p3 = new Pelicula("Ocho apellidos catalanes", Genero.COMEDIA, convertirFecha("20/11/2015"), convertirFecha("18/03/2016"));
        p4 = new Pelicula("Padres por desigual", Genero.COMEDIA, convertirFecha("01/01/2016"), convertirFecha("11/05/2016"));
        p5 = new Pelicula("Star Wars: El despertar de la Fuerza", Genero.FICCION, convertirFecha("18/12/2015"), convertirFecha("20/04/2016"));
        p6 = new Pelicula("Mad Max: Furia en la carretera", Genero.FICCION, convertirFecha("15/05/2015"), convertirFecha("01/09/2015"));
        p7 = (Pelicula) p1.clone();
        p8 = (Pelicula) p5.clone();

        //Apartado 1
        System.out.println("1. Lista sin duplicados que consigue mantener el orden en el que los datos fueron insertados\n");
        apartado1.add(p1);
        apartado1.add(p2);
        apartado1.add(p3);
        apartado1.add(p4);
        apartado1.add(p5);
        apartado1.add(p6);
        apartado1.add(p7);
        apartado1.add(p8);

        for (Pelicula p:apartado1)
            System.out.println(p);
        
        
        //Apartado 2
        System.out.println("\n\n2. Árbol ordenado descendemente por días que ha tardado en salir en DVD desde que se estrenó\n");
        apartado2.add(p1);
        apartado2.add(p2);
        apartado2.add(p3);
        apartado2.add(p4);
        apartado2.add(p5);
        apartado2.add(p6);
        apartado2.add(p7);
        apartado2.add(p8);

        for (Pelicula p:apartado2)
            System.out.printf("%s Días: %d%n", p, p.diferenciaDias());
        
        //Apartado 3
        System.out.println("\n\n3. Árbol ordenado ascendentemente por fecha de estreno\n");
        apartado3.add(p1);
        apartado3.add(p2);
        apartado3.add(p3);
        apartado3.add(p4);
        apartado3.add(p5);
        apartado3.add(p6);
        apartado3.add(p7);
        apartado3.add(p8);

        for (Pelicula p:apartado3)
            System.out.println(p);

        //Apartado 4
        System.out.println("\n\n4. Mapa ordenado por clave\n");
        apartado4.put(p1.getClave(), p1);
        apartado4.put(p2.getClave(), p2);
        apartado4.put(p3.getClave(), p3);
        apartado4.put(p4.getClave(), p4);
        apartado4.put(p5.getClave(), p5);
        apartado4.put(p6.getClave(), p6);
        apartado4.put(p7.getClave(), p7);
        apartado4.put(p8.getClave(), p8);

        for (Pelicula p:apartado4.values())
            System.out.println(p);

        //Apartado 5
        System.out.println("\n\n5. Mapa anterior mostrado al revés\n");
        apartado5Lista = new ArrayList<Pelicula>(apartado4.values());
        apartado5ListIterator = apartado5Lista.listIterator(apartado5Lista.size());
        while (apartado5ListIterator.hasPrevious())
            System.out.println(apartado5ListIterator.previous());
    }


    public static Date convertirFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaConvertida = null;

        try {
            fechaConvertida = formato.parse(fecha);
        } catch (ParseException e) {

        }

        return fechaConvertida;
    }
}
