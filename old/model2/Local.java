package edu.upc.as.domain.model2;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Local in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 13/01/16
 */
@Entity
public class Local {
    private String nom;
    private String adreça;

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
    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Local local = (Local) o;

        if (nom != null ? !nom.equals(local.nom) : local.nom != null) return false;
        if (adreça != null ? !adreça.equals(local.adreça) : local.adreça != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (adreça != null ? adreça.hashCode() : 0);
        return result;
    }
}
