package edu.upc.as.domain.controllers;

import edu.upc.as.domain.adapter.AdapterFactory;
import edu.upc.as.domain.datainterface.DataFactory;
import edu.upc.as.domain.datainterface.ICtrlSeientsEnRepresentacio;
import edu.upc.as.domain.model.*;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.domain.utils.InfoSeleccioSeients;
import edu.upc.as.exception.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/** Implementació de la classe CtrlComprarEntrada del paquet Domain Controllers. **/

public class CtrlComprarEntrada {

    private String nomLocal;
    private TipusSessio sessio;
    private int nombEspectadors;
    private List<InfoOcupacio> seients;
    private float preu;

    /** Implementació de l'operació obteEspectacles.
     *  Retorna tots els Espectacles registrats en el sistema. **/
    public List<String> obteEspectacles() {
        return FactoriaCasosUs
                .getInstance()
                .getCtrlConsultarRepresentacions()
                .consultaEspectacles();
    }

    /** Implementació de l'operació obteRepresentacions.
     *  Retorna els locals, sessions, el nombre de seients disponibles, la indicació de si és estrena i el preu per totes les representacions per aquell espectacle i data. **/
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

    /** Implementació de l'operació obteOcupacio.
     *  Retorna la fila i columna de tots els seients disponibles per la representació especificada. **/
    public List<InfoOcupacio> obteOcupacio(String nomLocal, TipusSessio sessio, int nombEspectadors) throws SeientsNoDisponibles {
        this.nomLocal = nomLocal;
        this.sessio = sessio;
        this.nombEspectadors = nombEspectadors;
        return FactoriaCasosUs
                .getInstance()
                .getCtrlConsultarOcupacio()
                .consultaOcupacio(nomLocal, sessio.name(), nombEspectadors);
    }

    /** Implementació de l'operació seleccionarSeients.
     *  Retorna el preu total de l’entrada i les monedes en les que pot demanar la conversió. **/
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
        info.canvis = new ArrayList<String>();
        for (Moneda m : Shows.getInstance().getCanvis()) {
            info.canvis.add(String.valueOf(m));
        }
        return info;
    }

    /** Implementació de l'operació obtePreuMoneda.
     *  Retorna el preu amb el canvi de moneda efectuat. **/
    public float obtePreuMoneda(Moneda moneda) throws Exception {
        float preu = AdapterFactory
                .getInstance()
                .getConvertor()
                .conversionRate(Shows.getInstance().getDivisa().name(), moneda.name()) * this.preu;
        return preu;
    }

    /** Implementació de l'operació pagament.
     *  Si la transfarencia del preu total de l'entrada és exitosa, es crea una instància de entrada i de les seves associacions amb la representació i els seients de la representació. **/
    public void pagament(String dni, int codiB, String numCompte) throws PagamentNoAutoritzat, ServeiNoDisponible, NoExisteixDB {
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
