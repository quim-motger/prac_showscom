package edu.upc.as.domain.controllers;

import edu.upc.as.domain.adapter.AdapterFactory;
import edu.upc.as.domain.datainterface.CtrlSeientsEnRepresentacio;
import edu.upc.as.domain.datainterface.DataFactory;
import edu.upc.as.domain.model.*;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.domain.utils.InfoSeleccioSeients;
import javafx.util.Pair;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.LinkedList;
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
    private List<InfoOcupacio> seients;
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

    public InfoSeleccioSeients seleccionarSeients(List<InfoOcupacio> seients) {
        this.seients = seients;
        preu = DataFactory
                .getInstance()
                .getCtrlRepresentacio()
                .getRepresentacio(nomLocal, sessio)
                .calcularPreuEntrada() * nombEspectadors;
        InfoSeleccioSeients info = new InfoSeleccioSeients();
        info.preu = preu;
        info.canvis = Shows.getInstance().getCanvis();
        return info;
    }

    public float obtePreuMoneda(Moneda moneda) {
        preu = AdapterFactory
                .getInstance()
                .getConvertor()
                .conversionRate(Shows.getInstance().getDivisa(), moneda) * preu;
        return preu;
    }

    public void pagament(String dni, int codiB, String numCompte) {
        Date avui = new Date();
        int cbs = Shows.getInstance().getCodiBanc();
        String ncs = Shows.getInstance().getNumCompte();
        boolean autoritzat = AdapterFactory
                .getInstance()
                .getBank()
                .autoritza(dni, codiB, numCompte, preu, cbs, ncs, avui);
        if (!autoritzat) /*throw new pagamentNoAutoritzat()*/; //TODO


        CtrlSeientsEnRepresentacio sCtrl = DataFactory
                .getInstance()
                .getCtrlSeientsEnRepresentacio();

        List<SeientEnRepresentacio> seientsEnR = new LinkedList<SeientEnRepresentacio>();

        for (InfoOcupacio seient : seients) {
            seientsEnR.add(sCtrl.getSeientEnRepresentacio(nomLocal, sessio, seient.columna, seient.fila));
        }

        Entrada entrada = new Entrada(dni, nombEspectadors, avui, preu);

        Representacio r = DataFactory
                .getInstance()
                .getCtrlRepresentacio()
                .getRepresentacio(nomLocal, sessio);
        entrada.setRepresentacioISeients(r, seientsEnR);
    }

}
