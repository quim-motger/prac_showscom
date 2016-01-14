package edu.upc.as.domain.datainterface;

import edu.upc.as.domain.model.Entrada;
import edu.upc.as.exception.NoExisteixDB;

/**
 * Created by jmotger on 12/01/16.
 */
public interface ICtrlEntrada {

    Entrada getEntrada(String id) throws NoExisteixDB;

}
