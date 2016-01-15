package edu.upc.as.domain.adapter;

import edu.upc.as.exception.PagamentNoAutoritzat;
import edu.upc.as.exception.ServeiNoDisponible;
import edu.upc.as.exception.ServeiNoTrobat;

import java.util.Date;

/** Implementació de la interficie IBankAdapter del paquet Adapters. **/
public interface IBankAdapter {

    boolean autoritza(String dni, int codiB, String numCompte, float imp, int codiBancShows, String numCompteShows, Date avui) throws ServeiNoDisponible, PagamentNoAutoritzat;

}
