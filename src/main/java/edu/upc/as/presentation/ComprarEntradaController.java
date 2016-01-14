package edu.upc.as.presentation;

import edu.upc.as.domain.controllers.FactoriaCasosUs;
import edu.upc.as.domain.model.Representacio;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;

import javax.swing.text.View;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class ComprarEntradaController {

    ComprarEntradaView view;

    private int nEspec;

    public ComprarEntradaController() {
        view = ViewFactory.getInstance().getComprarEntradaView();
        view.init(this);
    }

    public void prOkConsultaRepresentacions(String titol, Date data) /*throws ParseException*/ {
        if (titol == null || titol.equals("") || data == null || data.equals("")) {
            view.mostraMissatge("Informació no seleccionada");
        }
        else if (FactoriaCasosUs.getInstance().getCtrlConsultarRepresentacions().consultaRepresentacions(titol, data).size() == 0) {
            view.mostraMissatge("Espectacle seleccionat no té representacions");
        } else {
            view.mostraRepresentacions(FactoriaCasosUs.getInstance().getCtrlConsultarRepresentacions().consultaRepresentacions(titol, data));
        }
    }

    public void prOkConsultaOcupacions(String nomLocal, String sessio, int nombEspectador) {
        view.mostraOcupacions(null);
    }

    public void prOkSeleccionaSeients(List<InfoOcupacio> seients) {
        view.mostraPreu(0, null);
    }

    public void prObtePreuMoneda(String moneda) {

    }

    public void prOkPagament(String dni, int codiB, String numCompte) {

    }

    public void prCancel() {
        System.exit(0);
    }

}
