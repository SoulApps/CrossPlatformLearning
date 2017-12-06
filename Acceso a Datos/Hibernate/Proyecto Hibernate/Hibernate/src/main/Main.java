package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.Asignatura;

public class Main {
	public static void main(String[] args) {
		SessionFactory sesion = clases.HibernateUtil.getSessionFactory();	
		Session session = sesion.openSession();
		Transaction t = session.beginTransaction();
		
		Asignatura as = new Asignatura();
		as.setCodAsignatura("@A");
		as.setNombre("hola");
		as.setHorasSemanales((byte) 1);
		as.setHorasTotales((short) 5);

		session.save(as);
		t.commit();
		session.close();
		System.exit(0);
	}

}
