package edu.upc.as.domain.controllers;

import edu.upc.as.domain.adapter.AdapterFactory;
import edu.upc.as.domain.datainterface.DataFactory;
import edu.upc.as.domain.datainterface.ICtrlSeientsEnRepresentacio;
import edu.upc.as.domain.model.*;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.domain.utils.InfoSeleccioSeients;
import edu.upc.as.exception.NoExisteixDB;
import edu.upc.as.exception.NoHiHaRepresentacions;
import edu.upc.as.exception.PagamentNoAutoritzat;
import edu.upc.as.exception.SeientsNoDisponibles;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 * @author David
 */
public class CtrlComprarEntrada {

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

    public List<InfoRepresentacio> obteRepresentacions(String titol, Date data) throws NoHiHaRepresentacions {
        List<InfoRepresentacio> inf = null;
        try {
            inf = FactoriaCasosUs
                    .getInstance()
                    .getCtrlConsultarRepresentacions()
                    .consultaRepresentacions(titol, data);
        } catch (NoExisteixDB noExisteixDB) {
            throw new NoHiHaRepresentacions(titol, data);
        }
        if (inf.isEmpty())
            throw new NoHiHaRepresentacions(titol, data);
        return inf;
    }

    public List<InfoOcupacio> obteOcupacio(String nomLocal, TipusSessio sessio, int nombEspectadors) throws SeientsNoDisponibles {
        this.nomLocal = nomLocal;
        this.sessio = sessio;
        this.nombEspectadors = nombEspectadors;
        return FactoriaCasosUs
                .getInstance()
                .getCtrlConsultarOcupacio()
                .consultaOcupacio(nomLocal, sessio.name(), nombEspectadors);
    }

    public InfoSeleccioSeients seleccionarSeients(List<InfoOcupacio> seients) {
        this.seients = seients;
        try {
            preu = DataFactory
                    .getInstance()
                    .getCtrlRepresentacio()
                    .getRepresentacio(nomLocal, sessio)
                    .calcularPreuEntrada() * nombEspectadors;
        } catch (NoExisteixDB noExisteixDB) {
            noExisteixDB.printStackTrace();
        }
        InfoSeleccioSeients info = new InfoSeleccioSeients();
        info.preu = preu;
        info.canvis = Shows.getInstance().getCanvis();
        return info;
    }

    public float obtePreuMoneda(Moneda moneda) throws Exception {
        preu = AdapterFactory
                .getInstance()
                .getConvertor()
                .conversionRate(Shows.getInstance().getDivisa().name(), moneda.name()) * preu;
        return preu;
    }

    public void pagament(String dni, int codiB, String numCompte) throws Exception {
        Date avui = new Date();
        int cbs = Shows.getInstance().getCodiBanc();
        String ncs = Shows.getInstance().getNumCompte();
        boolean autoritzat = AdapterFactory
                .getInstance()
                .getBank()
                .autoritza(dni, codiB, numCompte, preu, cbs, ncs, avui);
        if (!autoritzat)
            throw new PagamentNoAutoritzat(dni, numCompte, codiB, ncs, cbs, preu, avui);


        ICtrlSeientsEnRepresentacio sCtrl = DataFactory
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
