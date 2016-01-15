package edu.upc.as.domain.adapter;

/** Implementació de la interficie IConvertorAdapter del paquet Adapters. **/
public interface IConvertorAdapter {

    float conversionRate(String divisa, String moneda) throws Exception;

}
