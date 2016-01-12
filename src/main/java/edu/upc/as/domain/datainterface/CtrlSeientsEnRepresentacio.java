package edu.upc.as.domain.datainterface;

import edu.upc.as.domain.model.SeientEnRepresentacio;
import edu.upc.as.domain.model.TipusSessio;

/**
 * Created by jmotger on 12/01/16.
 */
public interface CtrlSeientsEnRepresentacio {

    SeientEnRepresentacio getSeientEnRepresentacio(String nomLocal, TipusSessio sessio, int columna, int fila);

}
