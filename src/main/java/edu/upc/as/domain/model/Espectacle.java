package edu.upc.as.domain.model;

import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.hibernate.UtilHibernate;

import javax.persistence.*;
import java.util.*;

/** Implementació de la classe Espectacle del paquet Domain Model. **/
@Entity(name = Espectacle.TABLE)
@Table(name = Espectacle.TABLE)
public class Espectacle {
    public final static String TABLE = "espectacle";

    @Id
    @Column(name = "titol")
    private String titol;

    @Basic
    @Column(name = "participants")
    private int participants;

    /** Relació 1->* amb la classe Representació, navegable en el sentit Espectacle->Representació. **/
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "titol", referencedColumnName = "titol")
    private Set<Representacio> representacions;

    public Espectacle(String titol, int participants) {
        this.titol = titol;
        this.participants = participants;
        representacions = new HashSet<Representacio>();
        UtilHibernate.save(this);
    }

    public Espectacle() {
    }


    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public Set<Representacio> getRepresentacions() {
        return representacions;
    }

    public void setRepresentacions(Set<Representacio> representacions) {
        this.representacions = representacions;
    }

    public void setRepresentacions(List<Representacio> representacions) {
        this.representacions = new HashSet<Representacio>(representacions);
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
