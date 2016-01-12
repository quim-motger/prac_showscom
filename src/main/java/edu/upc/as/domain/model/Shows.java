package edu.upc.as.domain.model;

import java.util.List;

/**
 * Created by David on 12/01/2016.
 */
public class Shows {

    private int codiBanc;
    private String numCompte;
    private Moneda divisa;
    private List<Moneda> canvis;
    private float comissio;

    private static Shows ourInstance = new Shows();

    public static Shows getInstance() {
        return ourInstance;
    }

    private Shows() {
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
