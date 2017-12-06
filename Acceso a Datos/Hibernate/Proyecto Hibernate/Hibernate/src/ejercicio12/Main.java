package ejercicio12;

import clases.Curso;
import clases.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Alejandro on 21/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        final String HQL = "SELECT p, c FROM Profesor p LEFT JOIN p.cursos c";
        SessionFactory sessionFactory = clases.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query q;
        List<Object[]> lista;

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

        Profesor profesor;
        Curso curso;

        //Código
        q = session.createQuery(HQL);
        lista = q.list();
        for (Object[] o : lista) {
            profesor = (Profesor) o[0];
            curso = (Curso) o[1];
            System.out.printf("[Profesor: %s] [Nombre: %s] [Apellidos: %s] [Fecha de alta: %s] ", profesor.getCodProf(), profesor.getNombre(), profesor.getApellidos(), formato.format(profesor.getFechaAlta()));
            if (curso != null)
                System.out.printf("[Curso: %s] [Oferta educativa: %s]%n", curso.getId().getCodCurso(), curso.getId().getCodOe());
            else
                System.out.println("[Este profesor no es tutor]");
        }

        session.close();
        System.exit(0);
    }
}
