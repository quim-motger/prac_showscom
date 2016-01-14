package edu.upc.as.domain.model;

import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.*;

/**
 * Created by jmotger on 12/01/16.
 */
@Entity(name = SeientEnRepresentacio.TABLE)
@Table(name = SeientEnRepresentacio.TABLE)
public class SeientEnRepresentacio {
    public final static String TABLE = "seient_en_representacio";
    @EmbeddedId
    SeientEnRepresentacioPK id;

    @Basic
    @Column(name = "estat")
    private Estat estat;

    @ManyToOne
    @JoinColumn(name = "identificadorentrada", referencedColumnName = "identificador")
    private Entrada entrada;

    public SeientEnRepresentacio(Seient seient, Representacio representacio, Entrada entrada) {
        id = new SeientEnRepresentacioPK(seient,representacio);
        this.entrada = entrada;
        estat = Estat.lliure;
        UtilHibernate.save(this);
    }

    public SeientEnRepresentacio() {
        id = new SeientEnRepresentacioPK();
    }

    public void ocupa() {
        estat = Estat.ocupat;
        UtilHibernate.update(this);
    }

    public Estat getEstat() {
        return estat;
    }

    public void setEstat(Estat estat) {
        this.estat = estat;
    }

    public boolean getInfoLliure(InfoOcupacio info) {
        if (estat == Estat.lliure) {
            info.fila = id.getSeient().getFila();
            info.columna = id.getSeient().getColumna();
            return true;
        }
        else return false;
    }

   @Transient
    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }


}
