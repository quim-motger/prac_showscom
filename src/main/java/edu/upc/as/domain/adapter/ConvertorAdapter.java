package edu.upc.as.domain.adapter;

import edu.upc.as.domain.serviceinterface.ServiceLocator;
import edu.upc.as.domain.serviceinterface.SvCurrencyConvertor;
import edu.upc.as.exception.ServeiNoDisponible;

/**
 * Created by jmotger on 12/01/16.
 */
public class ConvertorAdapter implements IConvertorAdapter {

    public float conversionRate(String divisa, String moneda) throws ServeiNoDisponible {
            return ((SvCurrencyConvertor) ServiceLocator
                    .getInstance()
                    .find("CurrencyConvertor"))
                    .conversionRate(divisa, moneda);
    }

}
