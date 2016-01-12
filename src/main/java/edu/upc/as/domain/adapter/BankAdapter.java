package edu.upc.as.domain.adapter;

import edu.upc.as.domain.serviceinterface.ServiceLocator;
import edu.upc.as.domain.serviceinterface.SvBankService;

import java.util.Date;

/**
 * Created by jmotger on 12/01/16.
 */
public class BankAdapter implements IBankAdapter {

    public boolean autoritza(String dni, int codiB, String numCompte, float imp, int codiBancShows, String numCompteShows, Date avui) throws Exception {
        return ((SvBankService)ServiceLocator
                .getInstance()
                .find("BankService"))
                .autoritza(dni, codiB, numCompte, imp, codiBancShows, numCompteShows, avui);
    }

}
