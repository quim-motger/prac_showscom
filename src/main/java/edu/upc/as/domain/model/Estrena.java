package edu.upc.as.domain.model;

import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.*;
import java.util.Date;

/** Implementació de la classe Estrena del paquet Domain Model. **/
@Entity(name =Estrena.TABLE)
@Table(name =Estrena.TABLE)
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name = "nomlocal", referencedColumnName = "sessio"), @PrimaryKeyJoinColumn(name = "sessio", referencedColumnName = "nomlocal")})
public class Estrena extends Representacio {
    public final static String TABLE = "estrena";

    @Basic
    @Column(name = "recarrec")
    private float recarrec;

    public Estrena(Date data, float preu, int nombreSeientsLliures, Local local, float recarrec, Sessio sessio) {
        super(data, preu, nombreSeientsLliures, local, sessio,false);
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


    @Override
    public float getRecarrec() {
        return recarrec;
    }

    public void setRecarrec(float recarrec) {
        this.recarrec = recarrec;
    }

}
