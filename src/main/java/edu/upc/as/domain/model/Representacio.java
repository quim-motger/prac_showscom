package edu.upc.as.domain.model;

import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.exception.SeientsNoDisponibles;
import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.*;
import java.util.*;

/**
 * Created by jmotger on 12/01/16.
 */
@Entity(name = Representacio.TABLE)
@Table(name = Representacio.TABLE)
@Inheritance(strategy= InheritanceType.JOINED)
public class Representacio {
    public final static String TABLE = "representacio";

    @Basic
    @Column(name = "data")
    private  Date data;

    @Basic
    @Column(name = "preu")
    private float preu;

    @Basic
    @Column(name = "nombreseienslliures")
    private int nombreSeientsLliures;

    @MapsId("localId")
    @ManyToOne
    @JoinColumn(name = "nomlocal", referencedColumnName = "nom", nullable = false)
    private Local local;

    @MapsId("sessioId")
    @ManyToOne
    @JoinColumn(name = "sessio", referencedColumnName = "sessio")
    private Sessio sessio;


    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumns({@JoinColumn(name = "sessio", referencedColumnName = "sessio"), @JoinColumn(name = "nomlocal", referencedColumnName = "nomlocal")})
    private Set<SeientEnRepresentacio> seientsEnRepresentacio;

    @EmbeddedId
    private RepresentacioPK id;

    public Representacio(Date data, float preu, int nombreSeientsLliures, Local local, Sessio sessio) {
        id = new RepresentacioPK();
        this.data = data;
        this.preu = preu;
        this.nombreSeientsLliures = nombreSeientsLliures;
        this.local = local;
        this.sessio = sessio;
        seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
        UtilHibernate.save(this);
    }

    public Representacio(Date data, float preu, int nombreSeientsLliures, Local local, Sessio sessio,boolean save) {
        id = new RepresentacioPK();
        this.data = data;
        this.preu = preu;
        this.nombreSeientsLliures = nombreSeientsLliures;
        this.local = local;
        this.sessio = sessio;
        seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
        if(save)UtilHibernate.save(this);
    }

    public Representacio() {
        id = new RepresentacioPK();
    }

    private static boolean sameDay(Date d1, Date d2){
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)&&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }

    public void setNomLocal(String nomLocal){
        id.setLocalId(nomLocal);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public Sessio getSessio() {
        return sessio;
    }

    public void setSessio(Sessio sessio) {
        this.sessio = sessio;
    }

    public Set<SeientEnRepresentacio> getSeientsEnRepresentacio() {
        return seientsEnRepresentacio;
    }

    public void setSeientsEnRepresentacio(Set<SeientEnRepresentacio> seientsEnRepresentacio) {
        this.seientsEnRepresentacio = seientsEnRepresentacio;
    }

    public void setSeientsEnRepresentacio(Set<SeientEnRepresentacio> seientsEnRepresentacio) {
        this.seientsEnRepresentacio = seientsEnRepresentacio;
    }    public void setSeientsEnRepresentacio(List<SeientEnRepresentacio> seientsEnRepresentacio) {
        this.seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>(seientsEnRepresentacio);
    }

    public RepresentacioPK getId() {
        return id;
    }

    public void setId(RepresentacioPK id) {
        this.id = id;
    }

    public int getNombreSeientsLliures() {
        return nombreSeientsLliures;
    }

    public void setNombreSeientsLliures(int nombreSeientsLliures) {
        this.nombreSeientsLliures = nombreSeientsLliures;
    }

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
        for (SeientEnRepresentacio sr : getSeientsEnRepresentacio()) {
            InfoOcupacio info = new InfoOcupacio();
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
        UtilHibernate.update(this);
    }

    public boolean isEstrena() {
        return false;
    }

    public boolean isData(Date data, InfoRepresentacio info) {
        info.nomLocal = getLocal().getNom();
        info.sessio = getSessio().getSessio();
        info.nombreSeientsLliures = getNombreSeientsLliures();
        info.estrena = isEstrena();
        info.preu = getPreu();
        if (sameDay(this.data,data))
            return false;
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
