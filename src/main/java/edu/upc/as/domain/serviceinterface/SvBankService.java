package edu.upc.as.domain.serviceinterface;

import java.util.Date;

/**
 * Created by jmotger on 12/01/16.
 */
public class SvBankService {

    public boolean autoritza(String dni, int codiB, String numCompte, float imp, int codiBancShows, String numCompteShows, Date dAvui) {
        if (dni.length() != 9) {
            return false;
        } else {
            try {
                String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKET";
                String s = dni.substring(0, 8);
                int modulo = Integer.parseInt(s) % 23;
                String letra = String.valueOf(juegoCaracteres.charAt(modulo));
                if (letra.equals(dni.substring(8, 9))) return true;
                else return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

}
