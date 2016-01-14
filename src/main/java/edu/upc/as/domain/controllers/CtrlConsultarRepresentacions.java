package edu.upc.as.domain.controllers;

import edu.upc.as.domain.datainterface.DataFactory;
import edu.upc.as.domain.model.Espectacle;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.exception.NoExisteixDB;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 * @author David
 */
public class CtrlConsultarRepresentacions {

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

    public List<InfoRepresentacio> consultaRepresentacions(String titol, Date data) {
        try {
            return DataFactory
                    .getInstance()
                    .getCtrlEspectacle()
                    .getEspectacle(titol)
                    .getRepresentacions(data);
        } catch (NoExisteixDB noExisteixDB) {
            noExisteixDB.printStackTrace();
        }
        return null;
    }

}
