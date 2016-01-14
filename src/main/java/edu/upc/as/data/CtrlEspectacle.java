package edu.upc.as.data;

import edu.upc.as.domain.datainterface.ICtrlEspectacle;
import edu.upc.as.domain.model.Espectacle;
import edu.upc.as.exception.NoExisteixDB;
import edu.upc.as.hibernate.UtilHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * CtrlEspectacle in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 14/01/16
 */
public class CtrlEspectacle implements ICtrlEspectacle {
    public Espectacle getEspectacle(String nom) throws NoExisteixDB {
        SessionFactory sf = UtilHibernate.getSessionFactory();
        Session session = sf.openSession();

        Espectacle res = (Espectacle) session.get(Espectacle.class, nom);
        session.close();
        if(res == null)
            throw new NoExisteixDB("Espectacle no existeix");
        return res;
    }

    @SuppressWarnings("unchecked")
    public List<Espectacle> getAll() {
        SessionFactory sf = UtilHibernate.getSessionFactory();
        Session session = sf.openSession();

        List<Espectacle> res = (List<Espectacle>)session.createQuery("from "+Espectacle.TABLE).list();
        session.close();
        return res;
    }

}
