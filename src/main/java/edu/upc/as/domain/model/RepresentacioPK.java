package edu.upc.as.domain.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * RepresentacioPK in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 13/01/16
 */
@Embeddable
public class RepresentacioPK implements Serializable {
    private String sessioId;
    private String localId;

    public RepresentacioPK (String nomLocal, TipusSessio tipusSessio){
        sessioId=tipusSessio.toString();
        localId=nomLocal;
    }

    public RepresentacioPK() {
    }


    public String getSessioId() {
        return sessioId;
    }

    public void setSessioId(String sessio) {
        this.sessioId = sessio;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String nomlocal) {
        this.localId = nomlocal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepresentacioPK that = (RepresentacioPK) o;

        if (sessioId != null ? !sessioId.equals(that.sessioId) : that.sessioId != null) return false;
        if (localId != null ? !localId.equals(that.localId) : that.localId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessioId != null ? sessioId.hashCode() : 0;
        result = 31 * result + (localId != null ? localId.hashCode() : 0);
        return result;
    }
}
