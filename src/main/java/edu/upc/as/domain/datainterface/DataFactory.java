package edu.upc.as.domain.datainterface;

/**
 * Created by jmotger on 12/01/16.
 */
public class DataFactory {
    private static DataFactory ourInstance = new DataFactory();

    public static DataFactory getInstance() {
        return ourInstance;
    }

    private DataFactory() {
    }

    public ICtrlEntrada getCtrlEntrada() {
        return null;
    }

    public ICtrlEspectacle getCtrlEspectacle() {
        return null;
    }

    public ICtrlLocal getCtrlLocal() {
        return null;
    }

    public ICtrlRepresentacio getCtrlRepresentacio() {
        return null;
    }

    public ICtrlSeientsEnRepresentacio getCtrlSeientsEnRepresentacio() {
        return null;
    }

}
