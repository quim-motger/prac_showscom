package edu.upc.as.data;

import edu.upc.as.domain.datainterface.ICtrlRepresentacio;
import edu.upc.as.domain.model.Representacio;
import edu.upc.as.domain.model.RepresentacioPK;
import edu.upc.as.domain.model.TipusSessio;
import edu.upc.as.exception.NoExisteixDB;
import edu.upc.as.hibernate.UtilHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * CtrlRepresentacio in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 14/01/16
 */
public class CtrlRepresentacio implements ICtrlRepresentacio {
    public Representacio getRepresentacio(String nomL, TipusSessio sessio) throws NoExisteixDB {
        SessionFactory sf = UtilHibernate.getSessionFactory();
        Session session = sf.openSession();

        Representacio res = (Representacio) session.get(Representacio.class, new RepresentacioPK(nomL,sessio));
        session.close();
        if(res == null)
            throw new NoExisteixDB("Espectacle no existeix");
        return res;
    }
}
