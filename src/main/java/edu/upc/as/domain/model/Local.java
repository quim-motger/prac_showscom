package edu.upc.as.domain.model;

import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jmotger on 12/01/16.
 */

@Entity(name = Local.TABLE)
public class Local {
    public final static String TABLE = "local";

    private String nom;
    private String adreca;

    public Local(String nom, String adreca) {
        this.nom = nom;
        this.adreca = adreca;
        UtilHibernate.save(this);
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
