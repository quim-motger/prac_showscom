package edu.upc.as.domain.adapter;

import java.util.Date;

/**
 * Created by jmotger on 12/01/16.
 */
public class BankAdapter implements IBankAdapter {

    public boolean autoritza(String dni, int codiB, String numCompte, float imp, int codiBancShows, String numCompteShows, Date avui) {
        /* TODO
        return ServiceLocator
                .getInstance()
                .find("BankService")
                .autoritza(dni, codiB, numCompte, imp, codiBancShows, numCompteShows, avui);
         */
        return false;
    }

}
