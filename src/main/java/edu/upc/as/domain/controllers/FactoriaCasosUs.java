package edu.upc.as.domain.controllers;

/** Classe resultant de la implementació del patró Factoria, per a l'accés als Casos d'us. **/
public class FactoriaCasosUs {

    /** Implementació del patró Singleton. **/
    private static FactoriaCasosUs ourInstance = new FactoriaCasosUs();
    private CtrlComprarEntrada ctrlComprarEntrada;
    private CtrlConsultarOcupacio ctrlConsultarOcupacio;
    private CtrlConsultarRepresentacions ctrlConsultarRepresentacions;

    private FactoriaCasosUs() {
    }

    /** Getters **/
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
