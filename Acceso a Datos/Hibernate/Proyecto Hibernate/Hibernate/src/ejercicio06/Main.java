package ejercicio06;

import clases.Asignatura;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alejandro on 19/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        final String HQL = "FROM Asignatura WHERE horasSemanales IN(:numeros)";
        SessionFactory sessionFactory = clases.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        ArrayList<Byte> numeros = new ArrayList<>();
        Asignatura asignatura;
        Query q;
        Iterator<Asignatura> it;

        numeros.add((byte) 3);
        numeros.add((byte) 4);
        numeros.add((byte) 6);

        //Código
        q = session.createQuery(HQL);
        q.setParameterList("numeros", numeros);
        it = q.iterate();
        while (it.hasNext()) {
            asignatura = it.next();
            System.out.printf("%s%n", asignatura.getCodAsignatura());
        }

        session.close();
        System.exit(0);
    }
}
