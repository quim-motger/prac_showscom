package edu.upc.as.domain.datainterface;

import edu.upc.as.domain.model.Espectacle;
import edu.upc.as.exception.NoExisteixDB;

import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public interface ICtrlEspectacle {

    Espectacle getEspectacle(String nom) throws NoExisteixDB;
    List<Espectacle> getAll();

}
