package edu.upc.as.domain.controllers;

import edu.upc.as.domain.datainterface.DataFactory;
import edu.upc.as.domain.model.Espectacle;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.exception.NoExisteixDB;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/** Implementació de la classe CtrlConsultarRepresentacions del paquet Domain Controllers. **/
public class CtrlConsultarRepresentacions {

    /** Implementació de l'operació consultaEspectacles.
     *  Retorna el títol de tots els espectacles existents al sistema. **/
    public List<String> consultaEspectacles() {
        List<String> titols = new LinkedList<String>();

        List<Espectacle> espec = DataFactory
                .getInstance()
                .getCtrlEspectacle()
                .getAll();

        for (Espectacle esp : espec) {
            titols.add(esp.getTitol());
        }

        return titols;
    }

    /** Implementació de l'operació consultaRepresentacions.
     *  Retorna els locals, sessions, el nombre de seients disponibles, la indicació de si és estrena i el preu per totes les representacions per aquell espectacle i data. **/
    public List<InfoRepresentacio> consultaRepresentacions(String titol, Date data) throws NoExisteixDB{
            return DataFactory
                    .getInstance()
                    .getCtrlEspectacle()
                    .getEspectacle(titol)
                    .getRepresentacions(data);

    }

}
