package ejercicio14;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Iterator;

/**
 * Created by Alejandro on 23/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        final String HQL = "SELECT c.id.codOe, c.id.codCurso, h.tramohorario.dia, a.nombre, COUNT(a.codAsignatura) " +
                "FROM Horario h JOIN h.curso c JOIN h.asignatura a " +
                "GROUP BY a.codAsignatura, h.tramohorario.dia, c.id " +
                "HAVING COUNT(a.codAsignatura) > 1 " +
                "ORDER BY c.id.codOe, c.id.codCurso, h.tramohorario.dia";

        SessionFactory sessionFactory = clases.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query q;
        Iterator it;
        Object[] o;

        //Código
        q = session.createQuery(HQL);
        it = q.iterate();
        while (it.hasNext()) {
            o = (Object[]) it.next();
            System.out.printf("[Curso: %s %s] [Día: %s] [Asignatura: %s] [Horas: %d]%n", o[0], o[1], o[2], o[3], o[4]);
        }

        session.close();
        System.exit(0);
    }
}
