package edu.upc.as.domain.datainterface;

import edu.upc.as.domain.model.Representacio;
import edu.upc.as.domain.model.TipusSessio;
import edu.upc.as.exception.NoExisteixDB;

/**
 * Created by jmotger on 12/01/16.
 */
public interface ICtrlRepresentacio {

    Representacio getRepresentacio(String nomL, TipusSessio sessio) throws NoExisteixDB;

}
