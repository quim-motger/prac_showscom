package edu.upc.as.domain.exception;

/**
 * Created by jmotger on 12/01/16.
 */
public class ServeiNoTrobat extends Exception {

    private static final String MESSAGE_FORMAT = "No s'ha trobat el servei definit amb path %s$1";

    public ServeiNoTrobat(String path) {
        super(String.format(MESSAGE_FORMAT, path));

    }

}
