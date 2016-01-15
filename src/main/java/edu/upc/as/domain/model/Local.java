package edu.upc.as.domain.model;

import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/** Implementació de la classe Local del paquet Domain Model. **/
@Entity(name = Local.TABLE)
public class Local {
    public final static String TABLE = "local";

    @Id
    @Column(name = "nom")
    private String nom;

    @Basic
    @Column(name = "adreça")
    private String adreca;

    public Local(String nom, String adreca) {
        this.nom = nom;
        this.adreca = adreca;
        UtilHibernate.save(this);
    }

    public Local() {

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
