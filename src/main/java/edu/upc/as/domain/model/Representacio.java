package edu.upc.as.domain.model;

import edu.upc.as.domain.exception.SeientsNoDisponibles;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
@Entity(name = Representacio.TABLE)
@Table(name = Representacio.TABLE)
@Inheritance(strategy= InheritanceType.JOINED)
public class Representacio {
    final static String TABLE = "representacio";

    private  Date data;
    private float preu;
    private int nombreSeientsLliures;
    private Local local;
    private Sessio sessio;
    private List<SeientEnRepresentacio> seientsEnRepresentacio;

    @EmbeddedId
    private RepresentacioPK id;

    public Representacio(Date data, float preu, int nombreSeientsLliures, Local local, Sessio sessio) {
        this.data = data;
        this.preu = preu;
        this.nombreSeientsLliures = nombreSeientsLliures;
        this.local = local;
        this.sessio = sessio;
        seientsEnRepresentacio = new LinkedList<SeientEnRepresentacio>();
    }

    public Representacio() {
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
    @Column(name = "preu")
    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    @MapsId("sessio")
    @ManyToOne
    @JoinColumn(name = "sessio", referencedColumnName = "sessio")
    public Sessio getSessio() {
        return sessio;
    }

    public void setSessio(Sessio sessio) {
        this.sessio = sessio;
    }

    @OneToMany
    @JoinColumns({@JoinColumn(name = "sessio", referencedColumnName = "sessio", nullable = false), @JoinColumn(name = "nomlocal", referencedColumnName = "nomlocal")})
    public List<SeientEnRepresentacio> getSeientsEnRepresentacio() {
        return seientsEnRepresentacio;
    }

    public void setSeientsEnRepresentacio(List<SeientEnRepresentacio> seientsEnRepresentacio) {
        this.seientsEnRepresentacio = seientsEnRepresentacio;
    }

    public RepresentacioPK getId() {
        return id;
    }

    public void setId(RepresentacioPK id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombreseienslliures")
    public int getNombreSeientsLliures() {
        return nombreSeientsLliures;
    }

    public void setNombreSeientsLliures(int nombreSeientsLliures) {
        this.nombreSeientsLliures = nombreSeientsLliures;
    }

    @MapsId("nomLocal")
    @ManyToOne
    @JoinColumn(name = "nomlocal", referencedColumnName = "nom", nullable = false)
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public float calcularPreuEntrada() {
        return preu + getRecarrec() + Shows.getInstance().getComissio();
    }

    public List<InfoOcupacio> getSeientsLliures(int nombEspectadors) throws SeientsNoDisponibles {
        if (getNombreSeientsLliures() < nombEspectadors)
            throw new SeientsNoDisponibles(
                    nombEspectadors,
                    getLocal(),
                    getSessio(),
                    getData(),
                    getNombreSeientsLliures()
            );
        List<InfoOcupacio> seients = new LinkedList<InfoOcupacio>();
        InfoOcupacio info;
        for (SeientEnRepresentacio sr : getSeientsEnRepresentacio()) {
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
        nombreSeientsLliures -= nOcupants;
    }

    public boolean isEstrena() {
        return false;
    }

    public boolean isData(Date data, InfoRepresentacio info) {
        if (data.equals(this.data))
            return false;
        info.nomLocal = getLocal().getNom();
        info.sessio = getSessio().getSessio();
        info.nombreSeientsLliures = getNombreSeientsLliures();
        info.estrena = isEstrena();
        info.preu = getPreu();
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Representacio that = (Representacio) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
