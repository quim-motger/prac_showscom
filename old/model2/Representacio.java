package edu.upc.as.domain.model2;

import edu.upc.as.domain.exception.SeientsNoDisponibles;
import edu.upc.as.domain.model.RepresentacioPK;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Representacio in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 13/01/16
 */
@Entity

@Inheritance(strategy=InheritanceType.JOINED)
public class Representacio {
    private Sessio sessio;
    private String nomlocal;
    private Float preu;
    private Date data;
    private Integer nombreseienslliures;
    private Espectacle espectacleByTitolespectacle;
    private Local localByNomlocal;
    private Collection<SeientEnRepresentacio> seientEnRepresentacios;

    @EmbeddedId
    private RepresentacioPK id;

    public Representacio() {
        id = new RepresentacioPK();
    }


    @Basic
    @Column(name = "preu")
    public Float getPreu() {
        return preu;
    }

    public void setPreu(Float preu) {
        this.preu = preu;
    }

    @Basic
    @Column(name = "data")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Basic
    @Column(name = "nombreseienslliures")
    public Integer getNombreseienslliures() {
        return nombreseienslliures;
    }

    public void setNombreseienslliures(Integer nombreseienslliures) {
        this.nombreseienslliures = nombreseienslliures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Representacio that = (Representacio) o;

        if (sessio != null ? !sessio.equals(that.sessio) : that.sessio != null) return false;
        if (nomlocal != null ? !nomlocal.equals(that.nomlocal) : that.nomlocal != null) return false;
        if (preu != null ? !preu.equals(that.preu) : that.preu != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (nombreseienslliures != null ? !nombreseienslliures.equals(that.nombreseienslliures) : that.nombreseienslliures != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessio != null ? sessio.hashCode() : 0;
        result = 31 * result + (nomlocal != null ? nomlocal.hashCode() : 0);
        result = 31 * result + (preu != null ? preu.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (nombreseienslliures != null ? nombreseienslliures.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "titolespectacle", referencedColumnName = "titol")
    public Espectacle getEspectacleByTitolespectacle() {
        return espectacleByTitolespectacle;
    }

    public void setEspectacleByTitolespectacle(Espectacle espectacleByTitolespectacle) {
        this.espectacleByTitolespectacle = espectacleByTitolespectacle;
    }

    @MapsId("nomLocal")
    @ManyToOne
    @JoinColumn(name = "nomlocal", referencedColumnName = "nom", nullable = false)
    public Local getLocalByNomlocal() {
        return localByNomlocal;
    }

    public void setLocalByNomlocal(Local localByNomlocal) {
        this.localByNomlocal = localByNomlocal;
    }

    @OneToMany(mappedBy = "representacio")
    public Collection<SeientEnRepresentacio> getSeientEnRepresentacios() {
        return seientEnRepresentacios;
    }

    public void setSeientEnRepresentacios(Collection<SeientEnRepresentacio> seientEnRepresentacios) {
        this.seientEnRepresentacios = seientEnRepresentacios;
    }
    public List<InfoOcupacio> getSeientsLliures(int nombEspectadors) throws SeientsNoDisponibles {
        if (getNombreseienslliures() < nombEspectadors)
            throw new SeientsNoDisponibles(nombEspectadors, getLocalByNomlocal(), sessio, data, getNombreseienslliures());
        List<InfoOcupacio> seients = new LinkedList<InfoOcupacio>();
        InfoOcupacio info;
        for (SeientEnRepresentacio sr : getSeientEnRepresentacios()) {
            info = new InfoOcupacio();
            if(sr.getInfoLliure(info))
                seients.add(info);
        }
        return seients;
    }

    public float getRecarrec() {
        return 0;
    }

    public void ocupa(int nOcupants) {
        nombreseienslliures -= nOcupants;
    }

    public boolean isEstrena() {
        return false;
    }

    public boolean isData(java.util.Date data, InfoRepresentacio info) {
        if (data.equals(this.data))
            return false;
        info.nomLocal = getLocalByNomlocal().getNom();
        info.sessio = sessio.getSessio();
        info.nombreSeientsLliures = getNombreseienslliures();
        info.estrena = isEstrena();
        info.preu = preu;
        return true;
    }

    @MapsId("sessioRep")
    @ManyToOne
    @JoinColumn(name = "sessio", referencedColumnName = "sessio")
    public Sessio getSessio() {
        return sessio;
    }

    public void setSessio(Sessio sessioBysessio) {
        this.sessio = sessioBysessio;
    }
}
