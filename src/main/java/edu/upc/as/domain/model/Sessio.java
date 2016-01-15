package edu.upc.as.domain.model;

import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.*;

/** Implementació de la classe Sessió del paquet Domain Model. **/
@Entity(name = Sessio.TABLE)
@Table(name = Sessio.TABLE)
public class Sessio {

    public static final String TABLE = "sessio";

    private TipusSessio sessio;

    public Sessio(TipusSessio sessio) {
        this.sessio = sessio;
        UtilHibernate.save(this);
    }

    public Sessio() {
    }

    @Transient
    public TipusSessio getSessio() {
        return sessio;
    }

    @Id
    @Column(name = "sessio")
    public String getSessioString() {
        return sessio.toString();
    }

    public void setSessioString(String sessio) {
        this.sessio = TipusSessio.valueOf(sessio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sessio sessio1 = (Sessio) o;

        return getSessio() == sessio1.getSessio();

    }

    @Override
    public int hashCode() {
        return getSessio().hashCode();
    }
}
