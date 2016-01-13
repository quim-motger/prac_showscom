package edu.upc.as.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * SeientEnRepresentacioPK in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 13/01/16
 */
@Embeddable
public class SeientEnRepresentacioPK implements Serializable {
    private Seient seient;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "fila", referencedColumnName = "fila", nullable = false), @JoinColumn(name = "columna", referencedColumnName = "columna", nullable = false), @JoinColumn(name = "nomlocal", referencedColumnName = "nomlocal", nullable = false)})
    public Seient getSeient() {
        return seient;
    }

    public void setSeient(Seient seient) {
        this.seient = seient;
    }
}
