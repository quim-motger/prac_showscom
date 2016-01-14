package edu.upc.as;

import edu.upc.as.domain.model.*;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * InstanciacioTest in edu.upc.as
 *
 * @author casassg
 * @version 1.0
 *          Creation Date: 14/01/16
 */
public class InstanciacioTest {

    @Test
    public void test() {
        Espectacle e1 = new Espectacle("Les Miserables", 38);
        Espectacle e2 = new Espectacle("La Traviatta", 20);

        Date d = Calendar.getInstance().getTime();

        Local l1 = new Local("Teatre Musical de Barcelona", "Carrer de la Guàrdia Urbana, 7, 08004 Barcelona");
        Local l2 = new Local("El Liceu", "Les Rambles, 51-59, 08002 Barcelona");

        Seient s1 = new Seient(1, 1, l1);
        Seient s2 = new Seient(1, 2, l1);
        Seient s3 = new Seient(1, 3, l1);
        Seient s4 = new Seient(1, 4, l1);
        Seient s5 = new Seient(2, 1, l1);
        Seient s6 = new Seient(2, 1, l2);
        Seient s7 = new Seient(2, 2, l2);
        Seient s8 = new Seient(2, 3, l2);
        Seient s9 = new Seient(2, 4, l2);
        Seient s10 = new Seient(2, 5, l2);

        Sessio mati = new Sessio(TipusSessio.matí);
        Sessio tarda = new Sessio(TipusSessio.tarda);
        Sessio nit = new Sessio(TipusSessio.nit);

        Representacio r1 = new Estrena(d, 25.9f, 5, l1, 5.0f, tarda);
        Representacio r2 = new Representacio(d, 35.9f, 5, l1, nit);
        Representacio r3 = new Estrena(d, 19.9f, 5, l2, 8.0f, mati);
        Representacio r4 = new Representacio(d, 24.9f, 5, l2, tarda);
        Representacio r5 = new Representacio(d, 28.9f, 5, l2, nit);

        SeientEnRepresentacio sr1 = new SeientEnRepresentacio(s1, r1,null);
        SeientEnRepresentacio sr2 = new SeientEnRepresentacio(s2, r2, null);
        SeientEnRepresentacio sr3 = new SeientEnRepresentacio(s3, r1, null);
        SeientEnRepresentacio sr4 = new SeientEnRepresentacio(s4,  r1, null);
        SeientEnRepresentacio sr5 = new SeientEnRepresentacio(s5,  r1, null);
        SeientEnRepresentacio sr6 = new SeientEnRepresentacio(s6, r2, null);
        SeientEnRepresentacio sr7 = new SeientEnRepresentacio(s7,r2, null);
        SeientEnRepresentacio sr8 = new SeientEnRepresentacio(s8,r3, null);
        SeientEnRepresentacio sr9 = new SeientEnRepresentacio(s9, r3, null);
        SeientEnRepresentacio sr10 = new SeientEnRepresentacio(s10,r3, null);

    }
}