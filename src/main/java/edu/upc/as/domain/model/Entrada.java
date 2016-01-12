package edu.upc.as.domain.model;

import java.util.Date;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class Entrada {

    private final String identificador;
    private final String dniClient;
    private final int nombEspectadors;
    private final Date data;
    private final float preu;
    private Representacio representacio;
    private List<SeientEnRepresentacio> seientsEnRepresentacio;

    public Entrada(String dniClient, int nombEspectadors, Date data, float preu) {
        this.dniClient = dniClient;
        this.nombEspectadors = nombEspectadors;
        this.data = data;
        this.preu = preu;
        identificador = "";
    }

    public void setRepresentacioISeients(Representacio r, List<SeientEnRepresentacio> seientsEnR) {
        representacio = r;
        seientsEnRepresentacio = seientsEnR;
        r.ocupa(seientsEnRepresentacio.size());
        for (SeientEnRepresentacio s : seientsEnRepresentacio) {
            s.ocupa();
        }
    }

    public int getNombEspectadors() {
        return nombEspectadors;
    }

    public Date getData() {
        return data;
    }

    public float getPreu() {
        return preu;
    }
}
