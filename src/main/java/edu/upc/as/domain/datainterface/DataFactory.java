package edu.upc.as.domain.datainterface;

import edu.upc.as.data.*;

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
        return new CtrlLocal();
    }

    public ICtrlRepresentacio getCtrlRepresentacio() {
        return new CtrlRepresentacio();
    }

    public ICtrlSeientsEnRepresentacio getCtrlSeientsEnRepresentacio() {
        return new CtrlSeientEnRepresentacio();
    }

}
