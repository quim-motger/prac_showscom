package edu.upc.as.domain.model2;

import javax.persistence.*;

/**
 * Estrena in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 13/01/16
 */
@Entity(name = Estrena.TABLE)
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name = "nomlocal", referencedColumnName = "sessio"), @PrimaryKeyJoinColumn(name = "sessio", referencedColumnName = "nomlocal")})
public class Estrena extends Representacio {
    final static String TABLE = "estrena";
    private Integer recarrec;

    @Basic
    @Column(name = "recarrec")
    public Integer getRecarrec() {
        return recarrec;
    }

    public void setRecarrec(Integer recarrec) {
        this.recarrec = recarrec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estrena estrena = (Estrena) o;

        if (recarrec != null ? !recarrec.equals(estrena.recarrec) : estrena.recarrec != null) return false;

        return super.equals(o);
    }

    @Transient
    @Override
    public boolean isEstrena() {
        return true;
    }

}
