package edu.upc.as.presentation;

import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;

import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class ComprarEntradaSistemaView implements ComprarEntradaView {

    ComprarEntradaForm c;
    ComprarEntradaController ctrl;

    public void init(ComprarEntradaController ctrl) {
        c = new ComprarEntradaForm(ctrl);
        this.ctrl = ctrl;
    }

    public void mostraRepresentacions(List<InfoRepresentacio> repre) {

    }

    public void mostraOcupacions(List<InfoOcupacio> ocup) {

    }

    public void mostraPreu(float preu, List<String> canvis) {

    }

    public void mostraPreuMoneda(float preu, String moneda) {

    }

    public void mostraMissatge(String missatge) {

    }

    public void mostraMissatgeFi() {

    }

    public void mostraMissatgeFiError() {

    }

}
