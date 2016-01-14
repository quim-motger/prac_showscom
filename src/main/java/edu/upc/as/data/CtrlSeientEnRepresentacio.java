package edu.upc.as.data;

import edu.upc.as.domain.datainterface.ICtrlSeientsEnRepresentacio;
import edu.upc.as.domain.model.SeientEnRepresentacio;
import edu.upc.as.domain.model.SeientEnRepresentacioPK;
import edu.upc.as.domain.model.TipusSessio;
import edu.upc.as.exception.NoExisteixDB;
import edu.upc.as.hibernate.UtilHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * CtrlSeientEnRepresentacio in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 14/01/16
 */
public class CtrlSeientEnRepresentacio implements ICtrlSeientsEnRepresentacio {
    public SeientEnRepresentacio getSeientEnRepresentacio(String nomLocal, TipusSessio sessio, int columna, int fila) throws NoExisteixDB {
        SessionFactory sf = UtilHibernate.getSessionFactory();
        Session session = sf.openSession();

        SeientEnRepresentacio res = (SeientEnRepresentacio) session.get(SeientEnRepresentacio.class, new SeientEnRepresentacioPK(fila,columna,nomLocal,sessio));
        session.close();
        if(res == null)
            throw new NoExisteixDB("Espectacle no existeix");
        return res;
    }
}
