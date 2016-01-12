package edu.upc.as.domain.adapter;

import edu.upc.as.domain.model.Moneda;

/**
 * Created by jmotger on 12/01/16.
 */
public interface IConvertorAdapter {

    float conversionRate(String divisa, String moneda);

}
