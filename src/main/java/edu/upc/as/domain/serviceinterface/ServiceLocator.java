package edu.upc.as.domain.serviceinterface;

/**
 * Created by jmotger on 12/01/16.
 */
public class ServiceLocator {
    private static ServiceLocator ourInstance = new ServiceLocator();

    public static ServiceLocator getInstance() {
        return ourInstance;
    }

    private ServiceLocator() {
    }

}
