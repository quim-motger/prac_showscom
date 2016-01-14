package edu.upc.as.domain.controllers;

import edu.upc.as.domain.datainterface.DataFactory;
import edu.upc.as.domain.model.TipusSessio;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.exception.NoExisteixDB;
import edu.upc.as.exception.SeientsNoDisponibles;

import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class CtrlConsultarOcupacio {

    public List<InfoRepresentacio> totesRepresentacions() {
        return null;
    }

    public List<InfoOcupacio> consultaOcupacio(String nomLocal, String sessio, int nombEspectadors) throws SeientsNoDisponibles {
        try {
            return DataFactory
                    .getInstance()
                    .getCtrlRepresentacio()
                    .getRepresentacio(nomLocal, TipusSessio.valueOf(sessio))
                    .getSeientsLliures(nombEspectadors);
        } catch (NoExisteixDB noExisteixDB) {
            noExisteixDB.printStackTrace();
        }
        return null;
    }

}
