package edu.upc.as.domain.model2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Sessio in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 13/01/16
 */
@Entity
public class Sessio {
    private String sessio;

    @Id
    @Column(name = "sessio")
    public String getSessio() {
        return sessio;
    }

    public void setSessio(String sessio) {
        this.sessio = sessio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sessio sessio1 = (Sessio) o;

        if (sessio != null ? !sessio.equals(sessio1.sessio) : sessio1.sessio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return sessio != null ? sessio.hashCode() : 0;
    }
}
