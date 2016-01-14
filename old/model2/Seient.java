package edu.upc.as.domain.model2;

import edu.upc.as.domain.model.SeientPK;

import javax.persistence.*;

/**
 * Seient in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 13/01/16
 */
@Entity
@IdClass(SeientPK.class)
public class Seient {
    private Integer fila;
    private Integer columna;
    private String nomlocal;
    private Local localByNomlocal;

    @Id
    @Column(name = "fila")
    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    @Id
    @Column(name = "columna")
    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    @Id
    @Column(name = "nomlocal")
    public String getNomlocal() {
        return nomlocal;
    }

    public void setNomlocal(String nomlocal) {
        this.nomlocal = nomlocal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seient seient = (Seient) o;

        if (fila != null ? !fila.equals(seient.fila) : seient.fila != null) return false;
        if (columna != null ? !columna.equals(seient.columna) : seient.columna != null) return false;
        if (nomlocal != null ? !nomlocal.equals(seient.nomlocal) : seient.nomlocal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fila != null ? fila.hashCode() : 0;
        result = 31 * result + (columna != null ? columna.hashCode() : 0);
        result = 31 * result + (nomlocal != null ? nomlocal.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "nomlocal", referencedColumnName = "nom", nullable = false)
    public Local getLocalByNomlocal() {
        return localByNomlocal;
    }

    public void setLocalByNomlocal(Local localByNomlocal) {
        this.localByNomlocal = localByNomlocal;
    }
}
