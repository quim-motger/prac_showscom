package edu.upc.as.domain.controllers;

import edu.upc.as.domain.model.TipusSessio;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.domain.utils.InfoSeleccioSeients;
import javafx.util.Pair;

import java.util.Date;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class CtrlComprarEntrada {

    private String titol;
    private Date data;
    private String nomLocal;
    private TipusSessio sessio;
    private int nombEspectadors;
    private List<Pair<Integer, Integer>> seients;
    private float preu;

    public List<String> obteEspectacles() {
        return FactoriaCasosUs
                .getInstance()
                .getCtrlConsultarRepresentacions()
                .consultaEspectacles();
    }

    public List<InfoRepresentacio> obteRepresentacions(String titol, Date data) {
        this.titol = titol;
        this.data = data;
        List<InfoRepresentacio> inf = FactoriaCasosUs
                .getInstance()
                .getCtrlConsultarRepresentacions()
                .consultaRepresentacions(titol, data);
        if (inf.isEmpty()) /*throw new noHiHaRepresentacions()*/; //TODO
        return inf;
    }

    public List<InfoOcupacio> obteOcupacio(String nomLocal, String sessio, int nombEspectadors) {
        //TODO
        return null;
    }

    public List<InfoSeleccioSeients> seleccionarSeients(List<InfoOcupacio> seients) {
        //TODO
        return null;
    }

    public float obtePreuMoneda(String moneda) {
        //TODO
        return 0;
    }

    public void pagament(String dni, int codiB, String numCompte) {
        //TODO
    }

}
