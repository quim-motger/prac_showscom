package edu.upc.as.domain.datainterface;

import edu.upc.as.domain.model.Espectacle;

import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public interface ICtrlEspectacle {

    Espectacle getEspectacle(String nom);
    List<Espectacle> getAll();

}
