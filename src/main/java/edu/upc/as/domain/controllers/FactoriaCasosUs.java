package edu.upc.as.domain.controllers;

/**
 * Created by jmotger on 12/01/16.
 */
public class FactoriaCasosUs {
    private static FactoriaCasosUs ourInstance = new FactoriaCasosUs();

    public static FactoriaCasosUs getInstance() {
        return ourInstance;
    }

    private FactoriaCasosUs() {
    }

    public CtrlComprarEntrada getCtrlComprarEntrada() {
        return new CtrlComprarEntrada();
    }

    public CtrlConsultarOcupacio getCtrlConsultarOcupacio() {
        return new CtrlConsultarOcupacio();
    }

    public CtrlConsultarRepresentacions getCtrlConsultarRepresentacions() {
        return new CtrlConsultarRepresentacions();
    }

}
