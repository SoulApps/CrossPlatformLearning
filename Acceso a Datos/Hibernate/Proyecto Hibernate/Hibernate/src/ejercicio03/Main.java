package ejercicio03;

import clases.Historico;
import clases.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Created by Alejandro on 18/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = clases.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        //Session
        /*Profesor profesor = session.get(Profesor.class, "JC");
        Historico historico;

        if (profesor != null) {
            historico = new Historico();

            historico.setCodProf(profesor.getCodProf());
            historico.setNombre(profesor.getNombre());
            historico.setApellidos(historico.getApellidos());
            historico.setFechaAlta(profesor.getFechaAlta());

            session.save(historico);
            session.delete(profesor);
            t.commit();
        }*/

        //HQL
        final String HQL_INSERT = "INSERT INTO Historico(codProf, nombre, apellidos, fechaAlta) SELECT codProf, nombre, apellidos, fechaAlta FROM Profesor WHERE codProf = 'JC'";
        final String HQL_DELETE = "DELETE FROM Profesor WHERE codProf = 'JC'";
        session.createQuery(HQL_INSERT).executeUpdate();
        session.createQuery(HQL_DELETE).executeUpdate();
        t.commit();

        session.close();
        System.exit(0);
    }
}
