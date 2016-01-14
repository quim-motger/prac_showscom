package edu.upc.as.domain.model;

import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.*;

/**
 * Created by jmotger on 12/01/16.
 */
@Entity
public class Seient {
    @EmbeddedId
    private SeientPK id;

    @MapsId("localId")
    @JoinColumn(name = "nomLocal", referencedColumnName = "nom", nullable = false)
    @ManyToOne
    private Local local;

    public Seient() {
        id = new SeientPK();
    }

    public Seient(Integer fila, Integer columna, Local local) {
        id = new SeientPK(fila, columna);
        this.local = local;
        UtilHibernate.save(this);
    }

    public Seient(Integer fila, Integer columna, String nomLocal){
        id = new SeientPK(fila,columna,nomLocal);
    }

    public Integer getFila() {
        return id.getFila();
    }

    public void setFila(Integer fila) {
        id.setFila(fila);
    }

    public Integer getColumna() {
        return id.getColumna();
    }

    public void setColumna(Integer columna) {
        id.setColumna(columna);
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

}
