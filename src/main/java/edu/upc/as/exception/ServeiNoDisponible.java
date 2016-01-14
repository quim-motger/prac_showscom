package edu.upc.as.exception;

import java.util.Date;

/**
 * Created by jmotger on 14/01/16.
 */
public class ServeiNoDisponible extends Exception {

    private static final String MESSAGE_FORMAT = "El servei no està disponible";

    public ServeiNoDisponible() {
        super(String.format(MESSAGE_FORMAT));
    }

}
