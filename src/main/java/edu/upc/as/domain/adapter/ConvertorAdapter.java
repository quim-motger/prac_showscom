package edu.upc.as.domain.adapter;

import edu.upc.as.domain.serviceinterface.ServiceLocator;
import edu.upc.as.domain.serviceinterface.SvCurrencyConvertor;
import edu.upc.as.exception.ServeiNoDisponible;

/** Implementació de la classe BankAdapter del paquet Adapters. **/
public class ConvertorAdapter implements IConvertorAdapter {

    /** Implementació de l'operació conversionRate.
     *  Retorna el preu convertit a partir de la moneda escollida gracies a un servei de conversions. **/
    public float conversionRate(String divisa, String moneda) throws ServeiNoDisponible {
            return ((SvCurrencyConvertor) ServiceLocator
                    .getInstance()
                    .find("CurrencyConvertor"))
                    .conversionRate(divisa, moneda);
    }

}
