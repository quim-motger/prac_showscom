package edu.upc.as.presentation;

import edu.upc.as.domain.controllers.FactoriaCasosUs;
import edu.upc.as.domain.model.TipusSessio;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.domain.utils.InfoSeleccioSeients;
import edu.upc.as.exception.NoHiHaRepresentacions;
import edu.upc.as.exception.SeientsNoDisponibles;
import edu.upc.as.exception.NoExisteixDB;

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
        else {
            List<InfoRepresentacio> infoRepresentacios = null;
            try {
                infoRepresentacios = FactoriaCasosUs.getInstance().getCtrlComprarEntrada().obteRepresentacions(titol, data);
                view.mostraRepresentacions(infoRepresentacios);
            } catch (NoHiHaRepresentacions noHiHaRepresentacions) {
                view.mostraMissatge("Espectacle seleccionat no té representacions");
                return;
            }
        }
    }

    public void prOkConsultaOcupacions(String nomLocal, String sessio, int nombEspectador) {
        if (nombEspectador < 1) {
            view.mostraMissatge("El nombre d'espectadors ha de ser major que 0");
        } else {
            try {
                nEspec = nombEspectador;
                List<InfoOcupacio> ocupacions = FactoriaCasosUs.getInstance().getCtrlComprarEntrada().obteOcupacio(nomLocal, TipusSessio.valueOf(sessio), nombEspectador);
                view.mostraOcupacions(ocupacions);
            } catch (SeientsNoDisponibles e) {
                view.mostraMissatge("El nombre d'espectadors supera els seients lliures");
            }
        }
    }

    public void prOkSeleccionaSeients(List<InfoOcupacio> seients) {
        if (seients.size() != nEspec) {
            view.mostraMissatge("El nombre de seients seleccionats no coincideix amb el nombre d'espectadors");
        }
        else {
            InfoSeleccioSeients i = FactoriaCasosUs.getInstance().getCtrlComprarEntrada().seleccionarSeients(seients);
            view.mostraPreu(i.preu, i.canvis);
        }
    }

    public void prObtePreuMoneda(String moneda) {

    }

    public void prOkPagament(String dni, int codiB, String numCompte) {

    }

    public void prCancel() {
        System.exit(0);
    }

}
