package edu.upc.as.domain.adapter;

import edu.upc.as.domain.serviceinterface.ServiceLocator;
import edu.upc.as.domain.serviceinterface.SvBankService;
import edu.upc.as.exception.PagamentNoAutoritzat;
import edu.upc.as.exception.ServeiNoDisponible;
import edu.upc.as.exception.ServeiNoTrobat;

import java.util.Date;

/** Implementació de la classe BankAdapter del paquet Adapters. **/
public class BankAdapter implements IBankAdapter {

    /** Implementació de l'operació autoritza.
     *  Retorna cert si el servei fa la trasferencia bancaria correctament. **/
    public boolean autoritza(String dni, int codiB, String numCompte, float imp, int codiBancShows, String numCompteShows, Date avui) throws ServeiNoDisponible, PagamentNoAutoritzat {
        return ((SvBankService)ServiceLocator
                .getInstance()
                .find("BankService"))
                .autoritza(dni, codiB, numCompte, imp, codiBancShows, numCompteShows, avui);
    }

}
