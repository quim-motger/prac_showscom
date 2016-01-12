package edu.upc.as.domain.model;

import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class Espectacle {

    private String titol;
    private int participants;

    public Espectacle(String titol, int participants) {
        this.titol = titol;
        this.participants = participants;
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


}
