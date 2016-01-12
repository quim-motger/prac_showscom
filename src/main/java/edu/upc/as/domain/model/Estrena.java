package edu.upc.as.domain.model;

import java.util.Date;

/**
 * Created by David on 12/01/2016.
 */
public class Estrena extends Representacio {

    private final int recarrec;

    public Estrena(Date data, float preu, int nombreSeientsLliures, Local local, int recarrec) {
        super(data, preu, nombreSeientsLliures, local);
        this.recarrec = recarrec;
    }

    @Override
    public boolean isEstrena() {
        return true;
    }

    @Override
    public int getRecarrec() {
        return recarrec;
    }

}
