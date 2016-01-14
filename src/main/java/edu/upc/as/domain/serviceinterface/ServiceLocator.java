package edu.upc.as.domain.serviceinterface;

import edu.upc.as.exception.ServeiNoTrobat;

/**
 * Created by jmotger on 12/01/16.
 */
public class ServiceLocator {
    private static ServiceLocator ourInstance = new ServiceLocator();

    private ServiceLocator() {
    }

    public static ServiceLocator getInstance() {
        return ourInstance;
    }

    public Object find(String path) {
        if (path.equals("CurrencyConvertor")) {
           return new SvCurrencyConvertor();
        }
        else if (path.equals("BankService")) {
            return new SvBankService();
        } else return null;
    }

}
