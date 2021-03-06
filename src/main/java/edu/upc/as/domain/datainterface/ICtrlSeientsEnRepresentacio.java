package edu.upc.as.domain.datainterface;

import edu.upc.as.domain.model.SeientEnRepresentacio;
import edu.upc.as.domain.model.TipusSessio;
import edu.upc.as.exception.NoExisteixDB;

/**
 * Created by jmotger on 12/01/16.
 */
public interface ICtrlSeientsEnRepresentacio {

    SeientEnRepresentacio getSeientEnRepresentacio(String nomLocal, TipusSessio sessio, int columna, int fila) throws NoExisteixDB;

}
