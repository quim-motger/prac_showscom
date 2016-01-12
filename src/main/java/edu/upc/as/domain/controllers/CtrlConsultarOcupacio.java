package edu.upc.as.domain.controllers;

import edu.upc.as.domain.datainterface.DataFactory;
import edu.upc.as.domain.exception.SeientsNoDisponibles;
import edu.upc.as.domain.model.TipusSessio;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;

import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class CtrlConsultarOcupacio {

    public List<InfoRepresentacio> totesRepresentacions() {
        return null;
    }

    public List<InfoOcupacio> consultaOcupacio(String nomLocal, TipusSessio sessio, int nombEspectadors) throws SeientsNoDisponibles {
        return DataFactory
                .getInstance()
                .getCtrlRepresentacio()
                .getRepresentacio(nomLocal, sessio)
                .getSeientsLliures(nombEspectadors);
    }

}
