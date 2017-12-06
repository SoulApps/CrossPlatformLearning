package examen2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import teclado.Teclado;

import java.util.List;

/**
 * Created by Alejandro on 01/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        final String HQL = "SELECT h.id.codCurso, h.id.codOe, h.tramohorario.dia, COUNT(DISTINCT h.id.codAsignatura) " +
                "FROM Horario h " +
                "WHERE h.id.codAsignatura NOT LIKE '@%' " +
                "GROUP BY h.id.codCurso, h.id.codOe, h.tramohorario.dia " +
                "HAVING COUNT(DISTINCT h.id.codAsignatura) > (SELECT COUNT(DISTINCT hor.id.codAsignatura) FROM Horario hor WHERE hor.id.codAsignatura NOT LIKE '@%' AND hor.id.codCurso = :curso AND hor.id.codOe = :oe AND hor.tramohorario.dia = :dia GROUP BY hor.id.codCurso, hor.id.codOe, hor.tramohorario.dia) " +
                "ORDER BY h.id.codCurso, h.id.codOe, h.tramohorario.dia";

        SessionFactory sessionFactory = clases.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query q;
        List<Object[]> lista;

        String curso = Teclado.next("Introduce un curso");
        String oe = Teclado.next("Introduce una oferta educativa");
        String dia = Teclado.next("Introduce un día");

        //Código
        q = session.createQuery(HQL);
        q.setParameter("curso", curso);
        q.setParameter("oe", oe);
        q.setParameter("dia", dia);
        lista = q.list();
        for (Object[] o:lista)
            System.out.printf("[Curso: %s %s] [Día: %s] [Asignaturas: %d]%n", o[0], o[1], o[2], o[3]);

        session.close();
        System.exit(0);
    }
}
