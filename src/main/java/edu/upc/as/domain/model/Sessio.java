package edu.upc.as.domain.model;

/**
 * Created by jmotger on 12/01/16.
 */
public class Sessio {

    private final TipusSessio sessio;

    public Sessio(TipusSessio sessio) {
        this.sessio = sessio;
    }

    public TipusSessio getSessio() {
        return sessio;
    }

}
