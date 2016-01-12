package edu.upc.as.domain.model;

/**
 * Created by jmotger on 12/01/16.
 */
public class Local {

    private final String nom;
    private final String adreca;

    public Local(String nom, String adreca) {
        this.nom = nom;
        this.adreca = adreca;
    }

    public String getNom() {
        return nom;
    }

    public String getAdreca() {
        return adreca;
    }

}
