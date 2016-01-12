package edu.upc.as.domain.adapter;

import java.util.Date;

/**
 * Created by jmotger on 12/01/16.
 */
public interface IBankAdapter {

    boolean autoritza(String dni, int codiB, String numCompte, float imp,
                             int codiBancShows, String numCompteShows, Date dAvui);

}
