package edu.upc.as.domain.model;

import edu.upc.as.domain.utils.InfoOcupacio;

import javax.persistence.*;

/**
 * Created by jmotger on 12/01/16.
 */
@Entity(name = SeientEnRepresentacio.TABLE)
@Table(name = SeientEnRepresentacio.TABLE, schema = "public", catalog = "showscom")
@IdClass(SeientEnRepresentacioPK.class)
public class SeientEnRepresentacio {
    final static String TABLE = "seient_en_representacio";
    @EmbeddedId
    SeientEnRepresentacioPK id;
    private Estat estat;

    public SeientEnRepresentacio(Seient seient) {
        id.setSeient(seient);
        estat = Estat.lliure;
    }

    public SeientEnRepresentacio() {
    }

    public void ocupa() {
        estat = Estat.ocupat;
    }

    public Estat getEstat() {
        return estat;
    }

    public void setEstat(Estat estat) {
        this.estat = estat;
    }

    @Basic
    @Column(name = "estat")
    public String getEstatString() {
        return estat.toString();
    }

    public boolean getInfoLliure(InfoOcupacio info) {
        if (estat == Estat.lliure) {
            info.fila = id.getSeient().getFila();
            info.columna = id.getSeient().getColumna();
            return true;
        }
        else return false;
    }

}
