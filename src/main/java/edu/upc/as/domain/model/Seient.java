package edu.upc.as.domain.model;

import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.*;

/** Implementació de la classe Seient del paquet Domain Model. **/
@Entity(name = Seient.TABLE)
@Table(name = Seient.TABLE)
public class Seient {
    public static final String TABLE = "seient";
    @EmbeddedId
    private SeientPK id;

    /** Relació 1..*->1 amb la classe Local, no es navega. **/
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
