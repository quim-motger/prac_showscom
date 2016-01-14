package edu.upc.as.presentation;

import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;

import javax.swing.*;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class ComprarEntradaSistemaView implements ComprarEntradaView {

    JFrame c;
    ComprarEntradaController ctrl;

    int i = 0;

    public void init(ComprarEntradaController ctrl) {
        c = new ComprarEntradaForm(ctrl);
        this.ctrl = ctrl;
    }

    public void mostraRepresentacions(List<InfoRepresentacio> repre) {
        ++i;
        c.setVisible(false);
        c = new ShowRepresentacions(ctrl, repre);
    }

    public void mostraOcupacions(List<InfoOcupacio> ocup) {
        ++i;
        c.setVisible(false);
        c = new ShowOcupacions(ctrl, ocup);
    }

    public void mostraPreu(float preu, List<String> canvis) {
        ++i;
        c.setVisible(false);
        c = new ShowCompra(ctrl, preu, canvis);
    }

    public void mostraPreuMoneda(float preu, String moneda) {
        ((ShowCompra) c).setCanvi(preu, moneda);
    }

    public void mostraMissatge(String missatge) {
        if (i == 0) ((ComprarEntradaForm) c).setErrorMessage(missatge);
        else if (i == 1) ((ShowRepresentacions) c).setErrorMessage(missatge);
        else if (i == 2) ((ShowOcupacions) c).setErrorMessage(missatge);
        else if (i == 3) ((ShowCompra) c).setErrorMessage(missatge);
    }

    public void mostraMissatgeFi() {
        c.setVisible(false);
        c = new EndView(this.ctrl);
    }

    public void mostraMissatgeFiError() {
        c.setVisible(false);
        c = new EndErrorView(this.ctrl);
    }

}
