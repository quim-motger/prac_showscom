package edu.upc.as.domain.model;

import edu.upc.as.domain.utils.InfoRepresentacio;

import java.util.Date;

/**
 * Created by jmotger on 12/01/16.
 */
public class Representacio {

    private Date data;
    private float preu;
    private int nombreSeientsLliures;
    private Local local;
    private Sessio sessio;

    public Representacio(Date data, float preu, int nombreSeientsLliures, Local local) {
        this.data = data;
        this.preu = preu;
        this.nombreSeientsLliures = nombreSeientsLliures;
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public int getNombreSeientsLliures() {
        return nombreSeientsLliures;
    }

    public void setNombreSeientsLliures(int nombreSeientsLliures) {
        this.nombreSeientsLliures = nombreSeientsLliures;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public int calcularPreuEntrada() {
        //TODO calcularPreuEntrada
        return 0;
    }

    /*
    TODO getSeientsLliures
     */

    public int getRecarrec() {
        return 0;
    }

    public void ocupa(int nOcupants) {
        //TODO ocupa
    }

    public boolean isEstrena() {
        return false;
    }

    public boolean isData(Date data, InfoRepresentacio info) {
        if (data.equals(this.data))
            return false;
        info.nomLocal = local.getNom();
        info.sessio = sessio.getSessio();
        info.nombreSeientsLliures = nombreSeientsLliures;
        info.estrena = isEstrena();
        info.preu = preu;
        return true;
    }


    /*
    TODO isData
     */

}
