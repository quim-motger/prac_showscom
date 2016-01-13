package edu.upc.as.domain.serviceinterface;

import edu.upc.as.domain.exception.ServeiNoTrobat;

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

    public Object find(String path) throws ServeiNoTrobat {
        if (path.equals("CurrencyConvertor")) {
           return new SvCurrencyConvertor();
        }
        else if (path.equals("BankService")) {
            return new SvBankService();
        }
        else throw new ServeiNoTrobat(path);
    }

}
