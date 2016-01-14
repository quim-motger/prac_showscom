package edu.upc.as.data;

import edu.upc.as.domain.datainterface.ICtrlEntrada;
import edu.upc.as.domain.model.Entrada;
import edu.upc.as.exception.NoExisteixDB;
import edu.upc.as.hibernate.UtilHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * CtrlEntrada in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 14/01/16
 */
public class CtrlEntrada implements ICtrlEntrada {
    public Entrada getEntrada(String id) throws NoExisteixDB {
        SessionFactory sf = UtilHibernate.getSessionFactory();
        Session session = sf.openSession();

        Entrada res = (Entrada) session.get(Entrada.class, id);
        session.close();
        if(res == null)
            throw new NoExisteixDB("entrada no existeix");
        return res;
    }
}
