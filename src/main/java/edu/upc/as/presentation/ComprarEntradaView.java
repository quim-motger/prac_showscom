package edu.upc.as.presentation;

import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.domain.utils.InfoSeleccioSeients;

import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public interface ComprarEntradaView {

    void init(ComprarEntradaController c);
    void mostraRepresentacions(List<InfoRepresentacio> repre);
    void mostraOcupacions(List<InfoOcupacio> ocup);
    void mostraPreu(float preu, List<String> canvis);
    void mostraPreuMoneda(float preu, String moneda);
    void mostraMissatge(String missatge);
    void mostraMissatgeFi();
    void mostraMissatgeFiError();

}
