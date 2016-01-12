package edu.upc.as.domain.model;

import edu.upc.as.domain.exception.SeientsNoDisponibles;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class Representacio {

    private final Date data;
    private final float preu;
    private int nombreSeientsLliures;
    private final Local local;
    private final Sessio sessio;
    private final List<SeientEnRepresentacio> seientsEnRepresentacio;

    public Representacio(Date data, float preu, int nombreSeientsLliures, Local local, Sessio sessio) {
        this.data = data;
        this.preu = preu;
        this.nombreSeientsLliures = nombreSeientsLliures;
        this.local = local;
        this.sessio = sessio;
        seientsEnRepresentacio = new LinkedList<SeientEnRepresentacio>();
    }

    public Date getData() {
        return data;
    }

    public float getPreu() {
        return preu;
    }

    public int getNombreSeientsLliures() {
        return nombreSeientsLliures;
    }

    public Local getLocal() {
        return local;
    }

    public float calcularPreuEntrada() {
        return preu + getRecarrec() + Shows.getInstance().getComissio();
    }

    public List<InfoOcupacio> getSeientsLliures(int nombEspectadors) throws SeientsNoDisponibles {
        if (nombreSeientsLliures < nombEspectadors)
            throw new SeientsNoDisponibles(nombEspectadors, local, sessio, data, nombreSeientsLliures);
        List<InfoOcupacio> seients = new LinkedList<InfoOcupacio>();
        InfoOcupacio info;
        for (SeientEnRepresentacio sr : seientsEnRepresentacio) {
            info = new InfoOcupacio();
            if(sr.getInfoLliure(info))
                seients.add(info);
        }
        return seients;
    }

    public float getRecarrec() {
        return 0;
    }

    public void ocupa(int nOcupants) {
        nombreSeientsLliures -= nOcupants;
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

}
