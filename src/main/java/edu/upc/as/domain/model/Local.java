package edu.upc.as.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jmotger on 12/01/16.
 */

@Entity(name = Local.TABLE)
public class Local {
    final static String TABLE = "local";

    private String nom;
    private String adreca;

    public Local(String nom, String adreca) {
        this.nom = nom;
        this.adreca = adreca;
    }

    public Local() {

    }

    @Id
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "adreça")
    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

}
