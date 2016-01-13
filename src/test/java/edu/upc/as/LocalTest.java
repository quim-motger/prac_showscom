package edu.upc.as;

import edu.upc.as.domain.model.Local;
import edu.upc.as.domain.model.Seient;
import edu.upc.as.hibernate.UtilHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by jmotger on 13/01/16.
 */
public class LocalTest {

    private static Session session;

    @BeforeClass
    public static void start() {
        SessionFactory sessionFactory = UtilHibernate.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @AfterClass
    public static void end() {
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testLocal() {
        Local l1 = new Local("Teatre Apolo", "Av. Paralel");
        Local l2 = new Local("Teatre Borras", "Pl. Urquinaona");
        Local l3 = new Local("Razzmatazz", "Poblenou");
        session.save(l1);
        session.save(l2);
        session.save(l3);
    }

    @Test
    public void testSeientsWithLocal() {
        Local l1 = new Local("Teatre Jove Regina", "Carrer de Sèneca, 22, 08006 Barcelona");
        Local l2 = new Local("Cine Alexandra", "Rambla de Catalunya, 90, 08008 Barcelona");
        Seient s1 = new Seient(1, 1, l1);
        Seient s2 = new Seient(1, 2, l1);
        Seient s3 = new Seient(1, 3, l1);
        Seient s4 = new Seient(1, 4, l1);
        Seient s5 = new Seient(2, 1, l1);
        Seient s6 = new Seient(2, 1, l2);
        Seient s7 = new Seient(2, 2, l2);
        Seient s8 = new Seient(2, 3, l2);
        Seient s9 = new Seient(2, 4, l2);
        Seient s10 = new Seient(2, 5, l2);

        session.save(l1);
        session.save(l2);
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);
        session.save(s6);
        session.save(s7);
        session.save(s8);
        session.save(s9);
        session.save(s10);
    }

}
