package edu.upc.as.domain.model;

import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
@Entity(name = Espectacle.TABLE)
@Table(name = Espectacle.TABLE)
public class Espectacle {
    public final static String TABLE = "espectacle";

    private String titol;
    private int participants;
    private List<Representacio> representacions;

    public Espectacle(String titol, int participants) {
        this.titol = titol;
        this.participants = participants;
        representacions = new LinkedList<Representacio>();
        UtilHibernate.save(this);
    }

    public Espectacle() {
    }

    @Basic
    @Column(name = "participants")
    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    @Id
    @Column(name = "titol")
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    @OneToMany
    @JoinColumn(name = "titol", referencedColumnName = "titol")
    public List<Representacio> getRepresentacions() {
        return representacions;
    }

    public void setRepresentacions(List<Representacio> representacions) {
        this.representacions = representacions;
    }

    public List<InfoRepresentacio> getRepresentacions(Date data) {
        List<InfoRepresentacio> reps = new LinkedList<InfoRepresentacio>();
        InfoRepresentacio info;
        for (Representacio r : getRepresentacions()) {
            info = new InfoRepresentacio();
            if (!r.isData(data, info))
                reps.add(info);
        }
        return reps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Espectacle that = (Espectacle) o;

        return getTitol().equals(that.getTitol());

    }

    @Override
    public int hashCode() {
        return getTitol().hashCode();
    }
}
