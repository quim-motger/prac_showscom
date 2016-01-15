package edu.upc.as.domain.controllers;

import edu.upc.as.domain.datainterface.DataFactory;
import edu.upc.as.domain.model.TipusSessio;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.exception.NoExisteixDB;
import edu.upc.as.exception.SeientsNoDisponibles;

import java.util.List;

/** Implementació de la classe CtrlConsultarOcupacio del paquet Domain Controllers. **/
public class CtrlConsultarOcupacio {

    /** Implementació de l'operació totesRepresentacions.
     *  Retorna el títol, la data, els locals, sessions, el nombre de seients disponibles, la indicació de si és estrena i el preu de totes les representacions. **/
    public List<InfoRepresentacio> totesRepresentacions() {
        return null;
    }

    /** Implementació de l'operació consultaOcupacio.
     *  Retorna la fila i columna de tots els seients disponibles per a aquella representació. **/
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
