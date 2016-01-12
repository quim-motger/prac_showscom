package edu.upc.as.domain.model;

/**
 * Created by jmotger on 12/01/16.
 */
public class Seient {

    private int fila;
    private int columna;
    private Local local;

    public Seient(int fila, int columna, Local local) {
        this.fila = fila;
        this.columna = columna;
        this.local = local;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
