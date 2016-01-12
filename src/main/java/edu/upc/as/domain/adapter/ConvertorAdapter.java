package edu.upc.as.domain.adapter;

import edu.upc.as.domain.serviceinterface.ServiceLocator;
import edu.upc.as.domain.serviceinterface.SvCurrencyConvertor;

/**
 * Created by jmotger on 12/01/16.
 */
public class ConvertorAdapter implements IConvertorAdapter {

    public float conversionRate(String divisa, String moneda) throws Exception {
            return ((SvCurrencyConvertor) ServiceLocator
                    .getInstance()
                    .find("CurrencyConvertor"))
                    .conversionRate(divisa, moneda);
    }

}
