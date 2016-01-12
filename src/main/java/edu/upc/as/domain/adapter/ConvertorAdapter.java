package edu.upc.as.domain.adapter;

import edu.upc.as.domain.model.Moneda;

/**
 * Created by jmotger on 12/01/16.
 */
public class ConvertorAdapter implements IConvertorAdapter {

    public float conversionRate(String divisa, String moneda) {
        /* TODO
        return ServiceLocator
                .getInstance()
                .find("CurrencyConvertor")
                .conversionRate(divisa, moneda);
         */
        return 0;
    }

}
