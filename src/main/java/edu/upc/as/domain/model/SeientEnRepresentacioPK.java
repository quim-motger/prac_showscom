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
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "fila", referencedColumnName = "fila"), @JoinColumn(name = "columna", referencedColumnName = "columna"), @JoinColumn(name = "nomlocalseient", referencedColumnName = "nomlocal")})
    private Seient seient;

    private String sessio;

    public SeientEnRepresentacioPK(Seient seient) {
        this.seient = seient;
    }

    public SeientEnRepresentacioPK(Seient seient, Representacio representacio) {
        this.seient = seient;
        this.sessio = representacio.getSessio().getSessioString();
    }

    public SeientEnRepresentacioPK(Integer fila, Integer columna, String nomLocal, TipusSessio sessio){
        this.seient = new Seient(fila,columna,nomLocal);
        this.sessio = sessio.toString();
    }

    public SeientEnRepresentacioPK() {
    }

    public Seient getSeient() {
        return seient;
    }


    public void setSeient(Seient seient) {
        this.seient = seient;
    }

    public String getSessio() {
        return sessio;
    }

    public void setSessio(String sessio) {
        this.sessio = sessio;
    }
}
