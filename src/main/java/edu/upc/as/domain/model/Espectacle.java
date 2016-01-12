package edu.upc.as.domain.model;

import edu.upc.as.domain.utils.InfoRepresentacio;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class Espectacle {

    private final String titol;
    private int participants;
    private List<Representacio> representacions;

    public Espectacle(String titol, int participants) {
        this.titol = titol;
        this.participants = participants;
        representacions = new LinkedList<Representacio>();
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

    public List<InfoRepresentacio> getRepresentacions(Date data) {
        List<InfoRepresentacio> reps = new LinkedList<InfoRepresentacio>();
        InfoRepresentacio info;
        for (Representacio r : representacions) {
            info = new InfoRepresentacio();
            if (!r.isData(data, info))
                reps.add(info);
        }
        return reps;
    }

}
