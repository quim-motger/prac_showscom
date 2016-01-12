package edu.upc.as.domain.datainterface;

import edu.upc.as.domain.model.Representacio;
import edu.upc.as.domain.model.TipusSessio;

/**
 * Created by jmotger on 12/01/16.
 */
public interface CtrlRepresentacio {

    Representacio getRepresentacio(String nomL, TipusSessio sessio);

}
