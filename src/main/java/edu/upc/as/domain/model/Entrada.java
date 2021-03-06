package edu.upc.as.domain.model;

import edu.upc.as.hibernate.UtilHibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Implementació de la classe Entrada del paquet Domain Model. **/
@Entity(name = Entrada.TABLE)
@Table(name = Entrada.TABLE)
public class Entrada {
    public final static String TABLE = "entrada";

    /** Clau primaria generada automaticament*/
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "identificador")
    private  String identificador;

    @Basic
    @Column(name = "dniclient")
    private  String dniClient;

    @Basic
    @Column(name = "nombreespectadors")
    private int nombEspectadors;

    @Basic
    @Column(name = "data")
    private Date data;

    @Basic
    @Column(name = "preu")
    private float preu;

    /** Relació *->1 amb la classe Representació, navegable en el sentit Entrada->Representació. **/
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "sessio", referencedColumnName = "sessio"), @JoinColumn(name = "nomlocal", referencedColumnName = "nomlocal")})
    private Representacio representacio;

    /** Relació 0..1->1..* amb la classe SeientEnRepresentació, navegable en el sentit Entrada->SeientEnRepresentació. **/
    @OneToMany(mappedBy = "entrada", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<SeientEnRepresentacio> seientsEnRepresentacio;

    public Entrada(String dniClient, int nombEspectadors, Date data, float preu) {
        this.dniClient = dniClient;
        this.nombEspectadors = nombEspectadors;
        this.data = data;
        this.preu = preu;
        UtilHibernate.save(this);
    }

    public Entrada() {
    }

    public void setRepresentacioISeients(Representacio r, List<SeientEnRepresentacio> seientsEnR) {
        setRepresentacio(r);
        setSeientsEnRepresentacio(seientsEnR);
        r.ocupa(seientsEnR.size());
        for (SeientEnRepresentacio s : seientsEnR) {
            s.ocupa();
        }
        UtilHibernate.update(this);
    }


    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }


    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }

    public int getNombEspectadors() {
        return nombEspectadors;
    }

    public void setNombEspectadors(int nombEspectadors) {
        this.nombEspectadors = nombEspectadors;
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

    public Representacio getRepresentacio() {
        return representacio;
    }

    public void setRepresentacio(Representacio representacio) {
        this.representacio = representacio;
    }

    public Set<SeientEnRepresentacio> getSeientsEnRepresentacio() {
        return seientsEnRepresentacio;
    }

    public void setSeientsEnRepresentacio(List<SeientEnRepresentacio> seientsEnRepresentacio) {
        this.seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>(seientsEnRepresentacio);
    }

    public void setSeientsEnRepresentacio(Set<SeientEnRepresentacio> seientsEnRepresentacio) {
        this.seientsEnRepresentacio = seientsEnRepresentacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entrada entrada = (Entrada) o;

        return getIdentificador().equals(entrada.getIdentificador());

    }

    @Override
    public int hashCode() {
        return getIdentificador().hashCode();
    }
}
