package ejercicio01;

import clases.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by Alejandro on 16/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = clases.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Profesor profesor = new Profesor();
        profesor.setCodProf("JC");
        profesor.setNombre("Juan Carlos");
        profesor.setApellidos("Nose Nose");
        profesor.setFechaAlta(new Date());

        session.save(profesor);
        t.commit();
        session.close();
        System.exit(0);
    }
}
