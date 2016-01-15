package edu.upc.as;

import edu.upc.as.domain.controllers.FactoriaCasosUs;
import edu.upc.as.domain.model.*;
import edu.upc.as.domain.utils.InfoOcupacio;
import edu.upc.as.domain.utils.InfoRepresentacio;
import edu.upc.as.exception.*;
import edu.upc.as.hibernate.UtilHibernate;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jmotger on 15/01/16.
 */
public class CompraEntradaTest {

    @Test
    public void compraEntrada() {
        UtilHibernate.emptyTable(SeientEnRepresentacio.TABLE);
        UtilHibernate.emptyTable(Entrada.TABLE);
        UtilHibernate.emptyTable(Estrena.TABLE);
        UtilHibernate.emptyTable(Representacio.TABLE);
        UtilHibernate.emptyTable(Espectacle.TABLE);
        UtilHibernate.emptyTable(Sessio.TABLE);
        UtilHibernate.emptyTable(Seient.TABLE);
        UtilHibernate.emptyTable(Local.TABLE);

        Espectacle e1 = new Espectacle("Les Miserables", 38);

        Date d = Calendar.getInstance().getTime();

        Local l1 = new Local("Teatre Musical de Barcelona", "Carrer de la Guàrdia Urbana, 7, 08004 Barcelona");

        Seient s1 = new Seient(1, 1, l1);
        Seient s2 = new Seient(1, 2, l1);
        Seient s3 = new Seient(1, 3, l1);
        Seient s4 = new Seient(1, 4, l1);
        Seient s5 = new Seient(2, 1, l1);

        Sessio mati = new Sessio(TipusSessio.matí);
        Sessio tarda = new Sessio(TipusSessio.tarda);

        Representacio r1 = new Estrena(d, 25.9f, 5, l1, 5.0f, tarda);


        List<Representacio> lr1 = new ArrayList<Representacio>();
        lr1.add(r1);


        e1.setRepresentacions(lr1);
        UtilHibernate.update(e1);

        SeientEnRepresentacio sr1 = new SeientEnRepresentacio(s1, r1,null);
        SeientEnRepresentacio sr2 = new SeientEnRepresentacio(s2, r1, null);
        SeientEnRepresentacio sr3 = new SeientEnRepresentacio(s3, r1, null);
        SeientEnRepresentacio sr4 = new SeientEnRepresentacio(s4,  r1, null);
        SeientEnRepresentacio sr5 = new SeientEnRepresentacio(s5,  r1, null);

        r1.setSeientsEnRepresentacio(Arrays.asList(sr1,sr2, sr3, sr4, sr5));
        UtilHibernate.update(r1);


        //Procés de compra de totes les entrades disponibles d'una representació
        try {
            //Obtenim les representacions de l'espectacle "Les Miserables"
            List<InfoRepresentacio> infoRepresentacions = FactoriaCasosUs.getInstance().getCtrlComprarEntrada().obteRepresentacions("Les Miserables", d);
            assertEquals(infoRepresentacions.size(), 1);
            //Obtenim les ocupacions lliures de la representació
            List<InfoOcupacio> infoOcupacions = FactoriaCasosUs.getInstance().getCtrlComprarEntrada().obteOcupacio(infoRepresentacions.get(0).nomLocal, infoRepresentacions.get(0).sessio, infoRepresentacions.get(0).nombreSeientsLliures);
            assertEquals(5, infoOcupacions.size());
            assertEquals(5, r1.getNombreSeientsLliures());
            //Seleccionem tots els seients disponibles obtinguts a la consulta
            FactoriaCasosUs.getInstance().getCtrlComprarEntrada().seleccionarSeients(infoOcupacions);
            //Realitzem el pagament per la compra de les entrades
            FactoriaCasosUs.getInstance().getCtrlComprarEntrada().pagament("48176082Y", 2100, "21000");
        } catch (NoHiHaRepresentacions noHiHaRepresentacions) {
            noHiHaRepresentacions.printStackTrace();
        } catch (SeientsNoDisponibles seientsNoDisponibles) {
            seientsNoDisponibles.printStackTrace();
        } catch (ServeiNoDisponible serveiNoDisponible) {
            serveiNoDisponible.printStackTrace();
        } catch (PagamentNoAutoritzat pagamentNoAutoritzat) {
            pagamentNoAutoritzat.printStackTrace();
        } catch (NoExisteixDB noExisteixDB) {
            noExisteixDB.printStackTrace();
        }
    }

}
