package edu.upc.as.domain.exception;

import java.util.Date;

/**
 * Created by David on 12/01/2016.
 * @author David
 */
public class PagamentNoAutoritzat extends Exception {

    private static final String MESSAGE_FORMAT =
            "El pagament de l'usuari amb DNI %s$1 i número de compte %s$2 del banc %d$3 a la compta %s$4 del banc %d$5 per valor de %f$6 i amb data %s$7 no ha estat autoritzat.";

    public PagamentNoAutoritzat(String dni, String numCompte, int codiB, String ncs, int cbs, float preu, Date avui) {
        super(String.format(MESSAGE_FORMAT, dni, numCompte, codiB, ncs, cbs, preu, avui.toString()));
    }

}
