package edu.upc.as.domain.controllers;

/**
 * Created by jmotger on 12/01/16.
 */
public class FactoriaCasosUs {
    private static FactoriaCasosUs ourInstance = new FactoriaCasosUs();
    private CtrlComprarEntrada ctrlComprarEntrada;
    private CtrlConsultarOcupacio ctrlConsultarOcupacio;
    private CtrlConsultarRepresentacions ctrlConsultarRepresentacions;

    private FactoriaCasosUs() {
    }

    public static FactoriaCasosUs getInstance() {
        return ourInstance;
    }

    public CtrlComprarEntrada getCtrlComprarEntrada() {
        if(ctrlComprarEntrada==null) ctrlComprarEntrada = new CtrlComprarEntrada();
        return ctrlComprarEntrada;
    }

    public CtrlConsultarOcupacio getCtrlConsultarOcupacio() {
        if(ctrlConsultarOcupacio==null) ctrlConsultarOcupacio = new CtrlConsultarOcupacio();
        return ctrlConsultarOcupacio;
    }

    public CtrlConsultarRepresentacions getCtrlConsultarRepresentacions() {
        if(ctrlConsultarRepresentacions==null) ctrlConsultarRepresentacions = new CtrlConsultarRepresentacions();
        return ctrlConsultarRepresentacions;
    }

}
