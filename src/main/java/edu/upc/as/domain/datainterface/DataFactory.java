package edu.upc.as.domain.datainterface;

/**
 * Created by jmotger on 12/01/16.
 */
public class DataFactory {
    private static DataFactory ourInstance = new DataFactory();

    public static DataFactory getInstance() {
        return ourInstance;
    }

    private DataFactory() {
    }
}
