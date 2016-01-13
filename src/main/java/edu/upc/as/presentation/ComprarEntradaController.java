package edu.upc.as.presentation;

import edu.upc.as.domain.utils.InfoOcupacio;

import javax.swing.text.View;
import java.util.Date;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class ComprarEntradaController {

    private int nEspec;

    public void init() {
        ViewFactory.getInstance().getComprarEntradaView().init(this);
    }

    public void prOkConsultaRepresentacions(String titol, Date data) {

    }

    public void prOkConsultaOcupacions(String nomLocal, String sessio, int nombEspectador) {

    }

    public void prOkSeleccionaSeients(List<InfoOcupacio> seients) {

    }

    public void prObtePreuMoneda(String moneda) {

    }

    public void prOkPagament(String dni, int codiB, String numCompte) {

    }

}
