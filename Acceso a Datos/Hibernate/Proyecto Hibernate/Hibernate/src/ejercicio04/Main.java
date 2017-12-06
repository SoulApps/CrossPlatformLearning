package ejercicio04;

import clases.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Alejandro on 19/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        final String HQL = "FROM Profesor";
        SessionFactory sessionFactory = clases.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Profesor profesor;
        List<Profesor> lista;
        Iterator<Profesor> it;
        Query q = session.createQuery(HQL);

        System.out.println("--------------------------------list()--------------------------------");
        lista = q.list();
        for (Profesor o : lista) {
            System.out.printf("%s - %s%n", o.getCodProf(), o.getNombre());
        }

        System.out.println("--------------------------------iterate()--------------------------------");
        q.setFetchSize(3);
        it = q.iterate();
        while (it.hasNext()) {
            profesor = it.next();
            System.out.printf("%s - %s%n", profesor.getCodProf(), profesor.getNombre());
        }

        session.close();
        System.exit(0);
    }
}
