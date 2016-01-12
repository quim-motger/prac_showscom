package edu.upc.as.domain.exception;

import edu.upc.as.domain.model.Local;
import edu.upc.as.domain.model.Sessio;

import java.util.Date;
/**
 * Created by David on 12/01/2016.
 * @author David
 */
public class SeientsNoDisponibles extends Exception {

    private static final String MESSAGE_FORMAT = "S'han demanat %d$1 seients per a l'espectacle" +
            " del local %s$2 a la sessió %s$3 del dia %s$4," +
            " però només hi ha %d$5 seients lliures.";

    public SeientsNoDisponibles(int nombEspectadors, Local local, Sessio sessio, Date data, int nombreSeientsLliures) {
        super(String.format(MESSAGE_FORMAT, nombEspectadors, local, sessio, data.toString(), nombreSeientsLliures));

    }
}
