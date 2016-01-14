package edu.upc.as;

import edu.upc.as.domain.model.*;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;

/**
 * Created by jmotger on 13/01/16.
 */
public class PersistenceTest {


    @Test
    public void testLocal() {
        Local l1 = new Local("Teatre Apolo", "Av. Paralel");
        Local l2 = new Local("Teatre Borras", "Pl. Urquinaona");
        Local l3 = new Local("Razzmatazz", "Poblenou");
    }

    @Test
    public void testSeients() {
        Local l1 = new Local("Teatre Jove Regina", "Carrer de Sèneca, 22, 08006 Barcelona");
        Local l2 = new Local("Cine Alexandra", "Rambla de Catalunya, 90, 08008 Barcelona");
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
    }

    @Test
    public void testEntrada() {
        Entrada entrada =new Entrada("test",6,new Date(),0);
        Sessio tarda = new Sessio(TipusSessio.tarda);
        Local l1 = new Local("Teatre Jove Regina 2", "Carrer de Sèneca, 22, 08006 Barcelona");

        Representacio r = new Representacio(new Date(),5,2,l1,tarda);


        Seient s1 = new Seient(1,2,l1);

        SeientEnRepresentacio sr = new SeientEnRepresentacio(s1,entrada);

        entrada.setRepresentacioISeients(r, Collections.singletonList(sr));

        Entrada entrada2 =new Entrada("test2",6,new Date(),0);
        Entrada entrada3 =new Entrada("test3",6,new Date(),0);

    }

}
