package edu.upc.as;

import edu.upc.as.domain.model.*;
import edu.upc.as.hibernate.UtilHibernate;
import org.junit.Test;

import java.util.*;

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
        UtilHibernate.emptyTable(SeientEnRepresentacio.TABLE);
        UtilHibernate.emptyTable(Entrada.TABLE);
        UtilHibernate.emptyTable(Estrena.TABLE);
        UtilHibernate.emptyTable(Representacio.TABLE);
        UtilHibernate.emptyTable(Espectacle.TABLE);
        UtilHibernate.emptyTable(Sessio.TABLE);
        UtilHibernate.emptyTable(Seient.TABLE);
        UtilHibernate.emptyTable(Local.TABLE);



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

        Sessio mati = new Sessio(TipusSessio.matí);
        Sessio tarda = new Sessio(TipusSessio.tarda);
        Sessio nit = new Sessio(TipusSessio.nit);

        Representacio r1 = new Estrena(d, 25.9f, 5, l1, 5.0f, tarda);
        Representacio r2 = new Representacio(d, 35.9f, 5, l1, nit);
        Representacio r3 = new Estrena(d, 19.9f, 5, l2, 8.0f, mati);

        List<Representacio> lr1 = new ArrayList<Representacio>();
        lr1.add(r1);
        lr1.add(r2);
        List<Representacio> lr2 = new ArrayList<Representacio>();
        lr2.add(r3);

        e1.setRepresentacions(lr1);
        e2.setRepresentacions(lr2);
        UtilHibernate.update(e1);
        UtilHibernate.update(e2);

        SeientEnRepresentacio sr1 = new SeientEnRepresentacio(s1, r1,null);
        SeientEnRepresentacio sr2 = new SeientEnRepresentacio(s2, r1, null);
        SeientEnRepresentacio sr3 = new SeientEnRepresentacio(s3, r1, null);
        SeientEnRepresentacio sr4 = new SeientEnRepresentacio(s4,  r1, null);
        SeientEnRepresentacio sr5 = new SeientEnRepresentacio(s5,  r1, null);

        SeientEnRepresentacio sr6 = new SeientEnRepresentacio(s1, r2,null);
        SeientEnRepresentacio sr7 = new SeientEnRepresentacio(s2, r2, null);
        SeientEnRepresentacio sr8 = new SeientEnRepresentacio(s3, r2, null);
        SeientEnRepresentacio sr9 = new SeientEnRepresentacio(s4,  r2, null);
        SeientEnRepresentacio sr10 = new SeientEnRepresentacio(s5,  r2, null);

        SeientEnRepresentacio sr11 = new SeientEnRepresentacio(s1, r3,null);
        SeientEnRepresentacio sr12 = new SeientEnRepresentacio(s2, r3, null);
        SeientEnRepresentacio sr13 = new SeientEnRepresentacio(s3, r3, null);
        SeientEnRepresentacio sr14 = new SeientEnRepresentacio(s4,  r3, null);
        SeientEnRepresentacio sr15 = new SeientEnRepresentacio(s5,  r3, null);



        r1.setSeientsEnRepresentacio(Arrays.asList(sr1,sr2, sr3, sr4, sr5));
        r2.setSeientsEnRepresentacio(Arrays.asList(sr6,sr7, sr8, sr9, sr10));
        r3.setSeientsEnRepresentacio(Arrays.asList(sr11,sr12,sr13,sr14,sr15));
        UtilHibernate.update(r1);
        UtilHibernate.update(r2);
        UtilHibernate.update(r3);
//        r2.setSeientsEnRepresentacio(Arrays.asList(sr2, sr6, sr7));
//        UtilHibernate.update(r2);
//        r3.setSeientsEnRepresentacio(Arrays.asList(sr8, sr9, sr10));
//        UtilHibernate.update(r3);



    }
}
