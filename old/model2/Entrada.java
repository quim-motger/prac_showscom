package edu.upc.as.domain.model2;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

/**
 * Entrada in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 13/01/16
 */
@Entity(name = Entrada.TABLE)
public class Entrada {
    final static String TABLE = "estrena";

    private String dniclient;
    private Integer nombreespectadors;
    private Date data;
    private Float preu;
    private Integer identificador;
    private Representacio representacio;
    private Collection<SeientEnRepresentacio> seientEnRepresentaciosByIdentificador;

    public Entrada(String dniClient, int nombEspectadors, Date data, float preu) {
        this.dniclient = dniClient;
        this.nombreespectadors = nombEspectadors;
        this.data = data;
        this.preu = preu;
    }

    public Entrada() {

    }

    @Basic
    @Column(name = "dniclient")
    public String getDniclient() {
        return dniclient;
    }

    public void setDniclient(String dniclient) {
        this.dniclient = dniclient;
    }

    @Basic
    @Column(name = "nombreespectadors")
    public Integer getNombreespectadors() {
        return nombreespectadors;
    }

    public void setNombreespectadors(Integer nombreespectadors) {
        this.nombreespectadors = nombreespectadors;
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
    public Float getPreu() {
        return preu;
    }

    public void setPreu(Float preu) {
        this.preu = preu;
    }

    @Id
    @Column(name = "identificador")
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entrada entrada = (Entrada) o;

        if (dniclient != null ? !dniclient.equals(entrada.dniclient) : entrada.dniclient != null) return false;
        if (nombreespectadors != null ? !nombreespectadors.equals(entrada.nombreespectadors) : entrada.nombreespectadors != null)
            return false;
        if (data != null ? !data.equals(entrada.data) : entrada.data != null) return false;
        if (preu != null ? !preu.equals(entrada.preu) : entrada.preu != null) return false;
        if (identificador != null ? !identificador.equals(entrada.identificador) : entrada.identificador != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dniclient != null ? dniclient.hashCode() : 0;
        result = 31 * result + (nombreespectadors != null ? nombreespectadors.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (preu != null ? preu.hashCode() : 0);
        result = 31 * result + (identificador != null ? identificador.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "sessio", referencedColumnName = "sessio"), @JoinColumn(name = "nomlocal", referencedColumnName = "nomlocal")})
    public Representacio getRepresentacio() {
        return representacio;
    }

    public void setRepresentacio(Representacio representacio) {
        this.representacio = representacio;
    }

    @OneToMany
    @JoinColumn(name = "identificador", referencedColumnName = "identificadorentrada")
    public Collection<SeientEnRepresentacio> getSeientEnRepresentaciosByIdentificador() {
        return seientEnRepresentaciosByIdentificador;
    }

    public void setSeientEnRepresentaciosByIdentificador(Collection<SeientEnRepresentacio> seientEnRepresentaciosByIdentificador) {
        this.seientEnRepresentaciosByIdentificador = seientEnRepresentaciosByIdentificador;
    }


    public void setRepresentacioISeients(Representacio r, List<SeientEnRepresentacio> seientsEnR) {
        setRepresentacio(r);
        setSeientEnRepresentaciosByIdentificador(seientsEnR);
        r.ocupa(seientsEnR.size());
        for (SeientEnRepresentacio s : seientsEnR) {
            s.ocupa();
        }
    }
}
