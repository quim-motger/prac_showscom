package edu.upc.as.domain.adapter;

/**
 * Created by jmotger on 12/01/16.
 */
public class AdapterFactory {

    private static AdapterFactory instance = new AdapterFactory();

    public static AdapterFactory getInstance() {
        return instance;
    }

    private AdapterFactory() {
    }
}
