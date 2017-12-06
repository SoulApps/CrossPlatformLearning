package ejercicio02;

import clases.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Created by Alejandro on 16/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = clases.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        //Session
        /*Profesor profesor = session.get(Profesor.class, "JC");

        if (profesor != null) {
            System.out.println(profesor.getNombre());
            profesor.setNombre("Session");
            session.update(profesor);
            t.commit();
        }
        */

        //HQL
        final String HQL = "UPDATE Profesor SET nombre = 'HQL' WHERE codProf = 'JC'";
        Query q = session.createQuery(HQL);
        q.executeUpdate();
        t.commit();

        session.close();
        System.exit(0);
    }
}
