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
    private String sessio;
    private String nomLocal;


    public String getSessio() {
        return sessio;
    }

    public void setSessio(String sessio) {
        this.sessio = sessio;
    }

    public String getNomLocal() {
        return nomLocal;
    }

    public void setNomLocal(String nomlocal) {
        this.nomLocal = nomlocal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepresentacioPK that = (RepresentacioPK) o;

        if (sessio != null ? !sessio.equals(that.sessio) : that.sessio != null) return false;
        if (nomLocal != null ? !nomLocal.equals(that.nomLocal) : that.nomLocal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessio != null ? sessio.hashCode() : 0;
        result = 31 * result + (nomLocal != null ? nomLocal.hashCode() : 0);
        return result;
    }
}
