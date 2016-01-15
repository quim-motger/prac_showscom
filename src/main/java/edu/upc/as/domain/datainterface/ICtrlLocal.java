package edu.upc.as.domain.datainterface;

import edu.upc.as.domain.model.Local;
import edu.upc.as.exception.NoExisteixDB;

/**
 * Created by jmotger on 12/01/16.
 */
public interface ICtrlLocal {

    Local getLocal(String nom) throws NoExisteixDB;

}
