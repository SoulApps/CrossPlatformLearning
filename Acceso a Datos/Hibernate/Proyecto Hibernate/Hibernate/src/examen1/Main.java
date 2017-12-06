package examen1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Alejandro on 01/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        final String HQL = "SELECT p.codProf, p.nombre, p.apellidos, c.id.codCurso, c.id.codOe, o.nombre, o.tipo, COUNT(DISTINCT r.id.codAsignatura), COUNT(DISTINCT r.curso.id.codOe), COUNT(DISTINCT r.curso.id) " +
                "FROM Profesor p LEFT JOIN p.cursos c LEFT JOIN c.ofertaeducativa o LEFT JOIN p.repartos r " +
                "GROUP BY p.codProf";

        SessionFactory sessionFactory = clases.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String cursoAux, nombreAux, tipoAux;

        Query q;
        List<Object[]> lista;

        //Código
        q = session.createQuery(HQL);
        lista = q.list();
        for (Object[] o:lista) {
            //Compruebo si es tutor y le asigno los valores a mis variables auxiliares.
            if (o[3] != null) { //Es tutor.
                cursoAux = String.format("%s %s", o[3], o[4]);
                nombreAux = (String) o[5];
                tipoAux = (String) o[6];
            }
            else { //No es tutor.
                cursoAux = "No es tutor";
                nombreAux = "----";
                tipoAux = "----";
            }

            System.out.printf("[Código profesor: %s] [Nombre profesor: %s] [Apellidos profesor: %s] [Curso: %s] [Nombre oferta: %s] [Tipo oferta: %s] [Asignaturas: %d] [Ofertas: %d] [Cursos: %d]%n", o[0], o[1], o[2], cursoAux, nombreAux, tipoAux, o[7], o[8], o[9]);
        }

        session.close();
        System.exit(0);
    }
}
