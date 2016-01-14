package edu.upc.as.domain.model2;

import edu.upc.as.domain.utils.InfoRepresentacio;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Espectacle in edu.upc.as.data
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 13/01/16
 */
@Entity(name = Espectacle.TABLE)
public class Espectacle {
    final static String TABLE = "espectacle";

    private String titol;
    private Integer participants;
    private Collection<Representacio> representaciosByTitol;


    public Espectacle(String titol, int participants) {
        this.titol = titol;
        this.participants = participants;
    }

    public Espectacle() {
    }

    @Id
    @Column(name = "titol")
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    @Basic
    @Column(name = "participants")
    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Espectacle that = (Espectacle) o;

        if (titol != null ? !titol.equals(that.titol) : that.titol != null) return false;
        if (participants != null ? !participants.equals(that.participants) : that.participants != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = titol != null ? titol.hashCode() : 0;
        result = 31 * result + (participants != null ? participants.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "espectacleByTitolespectacle")
    public Collection<Representacio> getRepresentaciosByTitol() {
        return representaciosByTitol;
    }

    public void setRepresentaciosByTitol(Collection<Representacio> representaciosByTitol) {
        this.representaciosByTitol = representaciosByTitol;
    }


    public List<InfoRepresentacio> getRepresentacions(Date data) {
        List<InfoRepresentacio> reps = new LinkedList<InfoRepresentacio>();
        InfoRepresentacio info;
        for (Representacio r : getRepresentaciosByTitol()) {
            info = new InfoRepresentacio();
            if (!r.isData(data, info))
                reps.add(info);
        }
        return reps;
    }
}
