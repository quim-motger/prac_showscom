package edu.upc.as.domain.model;

/**
 * Created by jmotger on 12/01/16.
 */
public class Seient {

    private final int fila;
    private final int columna;
    private final Local local;

    public Seient(int fila, int columna, Local local) {
        this.fila = fila;
        this.columna = columna;
        this.local = local;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Local getLocal() {
        return local;
    }

}
