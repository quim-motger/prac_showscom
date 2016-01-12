package edu.upc.as.domain.exception;

import java.util.Date;

/**
 * Created by David on 12/01/2016.
 * @author David
 */
public class NoHiHaRepresentacions extends Exception {

    private static final String MESSAGE_FORMAT = "No hi ha cap representació amb títol %s$1 i data %s$2";

    public NoHiHaRepresentacions(String titol, Date data) {
        super(String.format(MESSAGE_FORMAT, titol, data.toString()));
    }

}
