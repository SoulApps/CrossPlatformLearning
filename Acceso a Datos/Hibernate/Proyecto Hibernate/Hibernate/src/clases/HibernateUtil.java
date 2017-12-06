package clases;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		//Crea una SessionFactory de hibernate.cfg.xml.
		try {
			java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
			return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		} catch(Throwable e) {
			System.err.println("Creación inicial de SessionFactory ha fallado. " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;	
	}
}
