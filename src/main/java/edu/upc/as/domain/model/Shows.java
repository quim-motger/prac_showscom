package edu.upc.as.domain.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by David on 12/01/2016.
 */
public class Shows {

    private static Shows ourInstance = new Shows();
    private final int codiBanc = -1;
    private final String numCompte = "";
    private final Moneda divisa = Moneda.EUR;
    private final List<Moneda> canvis = new LinkedList<Moneda>();
    private final float comissio = 0.0f;

    private Shows() {
        canvis.add(Moneda.USD);
        canvis.add(Moneda.GBP);

    }

    public static Shows getInstance() {
        return ourInstance;
    }

    public List<Moneda> getCanvis() {
        return canvis;
    }

    public float getComissio() {
        return comissio;
    }

    public Moneda getDivisa() {
        return divisa;
    }

    public int getCodiBanc() {
        return codiBanc;
    }

    public String getNumCompte() {
        return numCompte;
    }

}
