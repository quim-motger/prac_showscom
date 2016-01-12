package edu.upc.as.domain.model;

import edu.upc.as.domain.utils.InfoOcupacio;

/**
 * Created by jmotger on 12/01/16.
 */
public class SeientEnRepresentacio {

    private Estat estat;
    private final Seient seient;

    public SeientEnRepresentacio(Seient seient) {
        this.seient = seient;
        estat = Estat.lliure;
    }

    public void ocupa() {
        estat = Estat.ocupat;
    }

    public boolean getInfoLliure(InfoOcupacio info) {
        if (estat == Estat.lliure) {
            info.fila = seient.getFila();
            info.columna = seient.getColumna();
            return true;
        }
        else return false;
    }

}
