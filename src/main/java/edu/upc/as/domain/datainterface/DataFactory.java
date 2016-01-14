package edu.upc.as.domain.datainterface;

import edu.upc.as.data.CtrlEntrada;
import edu.upc.as.data.CtrlEspectacle;
import edu.upc.as.data.CtrlRepresentacio;

/**
 * Created by jmotger on 12/01/16.
 */
public class DataFactory {
    private static DataFactory ourInstance = new DataFactory();

    private DataFactory() {
    }

    public static DataFactory getInstance() {
        return ourInstance;
    }

    public ICtrlEntrada getCtrlEntrada() {
        return new CtrlEntrada();
    }

    public ICtrlEspectacle getCtrlEspectacle() {
        return new CtrlEspectacle();
    }

    public ICtrlLocal getCtrlLocal() {
        return null;
    }

    public ICtrlRepresentacio getCtrlRepresentacio() {
        return new CtrlRepresentacio();
    }

    public ICtrlSeientsEnRepresentacio getCtrlSeientsEnRepresentacio() {
        return null;
    }

}
