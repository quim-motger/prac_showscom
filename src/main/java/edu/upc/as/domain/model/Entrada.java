package edu.upc.as.domain.model;

import java.util.Date;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class Entrada {

    private final String dni;
    private final int nombEspectadors;
    private final Date avui;
    private final float preu;
    private Representacio representacio;
    private List<SeientEnRepresentacio> seientsEnRepresentacio;

    public Entrada(String dni, int nombEspectadors, Date avui, float preu) {
        this.dni = dni;
        this.nombEspectadors = nombEspectadors;
        this.avui = avui;
        this.preu = preu;
    }


    public void setRepresentacioISeients(Representacio r, List<SeientEnRepresentacio> seientsEnR) {
        representacio = r;
        seientsEnRepresentacio = seientsEnR;
        r.ocupa(seientsEnR.size());
        for (SeientEnRepresentacio s : seientsEnR) {
            s.ocupa();
        }
    }

}
