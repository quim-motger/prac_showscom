package edu.upc.as.domain.model;

/**
 * Created by jmotger on 12/01/16.
 */
public class Local {

    private String nom;
    private String adreca;

    public Local(String nom, String adreca) {
        this.nom = nom;
        this.adreca = adreca;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }
}
