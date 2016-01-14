package edu.upc.as.domain.model2;

import edu.upc.as.domain.model.Estat;
import edu.upc.as.domain.model.SeientEnRepresentacioPK;
import edu.upc.as.domain.utils.InfoOcupacio;

import javax.persistence.*;

/**
 * SeientEnRepresentacio in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 13/01/16
 */
@Entity
@Table(name = "seient_en_representacio", schema = "public", catalog = "showscom")
@IdClass(SeientEnRepresentacioPK.class)
public class SeientEnRepresentacio {
    private String sessio;
    private String nomlocal;
    private Integer fila;
    private Integer columna;
    private Estat estat;
    private Entrada entradaByIdentificadorentrada;
    private Representacio representacio;
    private Seient seient;


    public void ocupa() {
        estat = Estat.ocupat;
    }

    public boolean getInfoLliure(InfoOcupacio info) {
        if (estat == Estat.lliure) {
            info.fila = seient.getFila();
            info.columna = seient.getColumna();
            return true;
        }
        else return false;
    }

    @Id
    @Column(name = "sessio")
    public String getSessio() {
        return sessio;
    }

    public void setSessio(String sessio) {
        this.sessio = sessio;
    }

    @Id
    @Column(name = "nomlocal")
    public String getNomlocal() {
        return nomlocal;
    }

    public void setNomlocal(String nomlocal) {
        this.nomlocal = nomlocal;
    }

    @Id
    @Column(name = "fila")
    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    @Id
    @Column(name = "columna")
    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    @Basic
    @Column(name = "estat")
    public String getEstat() {
        return estat.toString();
    }

    public void setEstat(String estat) {
        this.estat = Estat.valueOf(estat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeientEnRepresentacio that = (SeientEnRepresentacio) o;

        if (sessio != null ? !sessio.equals(that.sessio) : that.sessio != null) return false;
        if (nomlocal != null ? !nomlocal.equals(that.nomlocal) : that.nomlocal != null) return false;
        if (fila != null ? !fila.equals(that.fila) : that.fila != null) return false;
        if (columna != null ? !columna.equals(that.columna) : that.columna != null) return false;
        if (estat != null ? !estat.equals(that.estat) : that.estat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessio != null ? sessio.hashCode() : 0;
        result = 31 * result + (nomlocal != null ? nomlocal.hashCode() : 0);
        result = 31 * result + (fila != null ? fila.hashCode() : 0);
        result = 31 * result + (columna != null ? columna.hashCode() : 0);
        result = 31 * result + (estat != null ? estat.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "identificadorentrada", referencedColumnName = "identificador")
    public Entrada getEntradaByIdentificadorentrada() {
        return entradaByIdentificadorentrada;
    }

    public void setEntradaByIdentificadorentrada(Entrada entradaByIdentificadorentrada) {
        this.entradaByIdentificadorentrada = entradaByIdentificadorentrada;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "sessio", referencedColumnName = "sessio", nullable = false), @JoinColumn(name = "nomlocalrep", referencedColumnName = "nomlocal")})
    public Representacio getRepresentacio() {
        return representacio;
    }

    public void setRepresentacio(Representacio representacio) {
        this.representacio = representacio;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "fila", referencedColumnName = "fila", nullable = false), @JoinColumn(name = "columna", referencedColumnName = "columna", nullable = false), @JoinColumn(name = "nomlocal", referencedColumnName = "nomlocal", nullable = false)})
    public Seient getSeient() {
        return seient;
    }

    public void setSeient(Seient seient) {
        this.seient = seient;
    }
}
