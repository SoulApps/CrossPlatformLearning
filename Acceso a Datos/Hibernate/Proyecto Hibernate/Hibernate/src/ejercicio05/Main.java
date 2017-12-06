package ejercicio05;

import clases.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import teclado.Teclado;

/**
 * Created by Alejandro on 19/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        final String HQL_COD = "FROM Profesor WHERE codProf = ?";
        final String HQL_NOMBRE = "FROM Profesor WHERE nombre = :nombre";
        SessionFactory sessionFactory = clases.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String cod = Teclado.next("Introduce un código");
        String nombre = Teclado.next("Introduce un nombre");

        Profesor profesor;
        Query q;

        //Código
        q = session.createQuery(HQL_COD);
        q.setParameter(0, cod);
        profesor = (Profesor) q.uniqueResult();
        System.out.printf("%s %s %s %s%n", profesor.getCodProf(), profesor.getNombre(), profesor.getApellidos(), profesor.getFechaAlta());

        //Nombre
        q = session.createQuery(HQL_NOMBRE);
        q.setParameter("nombre", nombre);
        profesor = (Profesor) q.uniqueResult();
        System.out.printf("%s %s %s %s%n", profesor.getCodProf(), profesor.getNombre(), profesor.getApellidos(), profesor.getFechaAlta());

        session.close();
        System.exit(0);
    }
}
