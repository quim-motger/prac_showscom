package edu.upc.as.data;

import edu.upc.as.domain.datainterface.ICtrlLocal;
import edu.upc.as.domain.model.Local;
import edu.upc.as.exception.NoExisteixDB;
import edu.upc.as.hibernate.UtilHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * CtrlLocal in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 15/01/16
 */
public class CtrlLocal implements ICtrlLocal {
    public Local getLocal(String nom) throws NoExisteixDB {

        SessionFactory sf = UtilHibernate.getSessionFactory();
        Session session = sf.openSession();

        Local res = (Local) session.get(Local.class, nom);
        session.close();
        if(res == null)
            throw new NoExisteixDB("Espectacle no existeix");
        return res;
    }
}
