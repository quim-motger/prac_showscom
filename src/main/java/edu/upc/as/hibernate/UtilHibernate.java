package edu.upc.as.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Classe d'utilitats de Hibernate, emmagatzema la factory
 */
public class UtilHibernate {

private static final SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory() {

            Configuration configuration = new Configuration().configure();

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

            return configuration.buildSessionFactory(serviceRegistry);
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        // Inserta un objecte, si ja existeix tira exec
        public static Object save(Object o) {
            SessionFactory sf = UtilHibernate.getSessionFactory();
            Session session = sf.openSession();

            session.beginTransaction();

            session.save(o);

            session.getTransaction().commit();

            session.close();

            return o;
        }

        // Actualitza un objecte, si no existeix tira exec
        public static Object update(Object o) {
            SessionFactory sf = UtilHibernate.getSessionFactory();
            Session session = sf.openSession();

            session.beginTransaction();

            session.merge(o);

            session.getTransaction().commit();

            session.close();
            return o;

        }

        // Esborra un objecte, si no existeix tira exec
        public static void delete(Object o) {
            SessionFactory sf = UtilHibernate.getSessionFactory();
            Session session = sf.openSession();

            session.beginTransaction();

            session.delete(o);

            session.getTransaction().commit();

            session.close();

        }

        //Buida taula -> usat pel test de creació d'instanciació
        public static int emptyTable(String myTable){
            SessionFactory sf = UtilHibernate.getSessionFactory();
            Session session = sf.openSession();

            session.beginTransaction();

            String hql = String.format("delete from %s",myTable);
            Query query = session.createQuery(hql);
            int res =  query.executeUpdate();
            session.getTransaction().commit();

            session.close();

            return res;

        }
}