package edu.upc.as;

import edu.upc.as.domain.model.*;
import edu.upc.as.hibernate.UtilHibernate;
import edu.upc.as.presentation.ComprarEntradaController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by jmotger on 12/01/16.
 */
public class Main {

    public static void main(String[] args) {
        //init(); -> no fa falta ja que hem posat que la instanciació es mantingui
        ComprarEntradaController c = new ComprarEntradaController();
        //c.init();
        //ComprarEntradaForm form = new ComprarEntradaForm(c);
    }



}
