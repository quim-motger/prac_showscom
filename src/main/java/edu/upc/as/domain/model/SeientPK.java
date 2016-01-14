package edu.upc.as.domain.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * SeientPK in edu.upc.fib.as.domain
 *
 * @author gerard.casas.saez
 * @version 1.0
 *          Creation Date: 25/10/15
 */
@Embeddable
public class SeientPK implements Serializable {
    private Integer fila;
    private Integer columna;
    private String localId;

    public SeientPK() {
    }

    public SeientPK(Integer fila, Integer columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public SeientPK(Integer fila, Integer columna, String nomLocal) {
        this.fila = fila;
        this.columna = columna;
        this.localId = nomLocal;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeientPK seientPK = (SeientPK) o;

        if (fila != null ? !fila.equals(seientPK.fila) : seientPK.fila != null) return false;
        if (columna != null ? !columna.equals(seientPK.columna) : seientPK.columna != null) return false;
        if (localId != null ? !localId.equals(seientPK.localId) : seientPK.localId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fila != null ? fila.hashCode() : 0;
        result = 31 * result + (columna != null ? columna.hashCode() : 0);
        result = 31 * result + (localId != null ? localId.hashCode() : 0);
        return result;
    }
}
