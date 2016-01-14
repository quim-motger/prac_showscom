package edu.upc.as.domain.model;

import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by David on 12/01/2016.
 */
@Entity(name =Estrena.TABLE)
@Table(name =Estrena.TABLE)
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name = "nomlocal", referencedColumnName = "sessio"), @PrimaryKeyJoinColumn(name = "sessio", referencedColumnName = "nomlocal")})
public class Estrena extends Representacio {
    final static String TABLE = "estrena";
    private float recarrec;

    public Estrena(Date data, float preu, int nombreSeientsLliures, Local local, float recarrec, Sessio sessio) {
        super(data, preu, nombreSeientsLliures, local, sessio);
        this.recarrec = recarrec;
        UtilHibernate.save(this);
    }

    public Estrena() {

    }

    @Transient
    @Override
    public boolean isEstrena() {
        return true;
    }

    @Basic
    @Column(name = "recarrec")
    @Override
    public float getRecarrec() {
        return recarrec;
    }

    public void setRecarrec(float recarrec) {
        this.recarrec = recarrec;
    }

}
