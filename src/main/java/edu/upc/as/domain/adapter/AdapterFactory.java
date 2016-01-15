package edu.upc.as.domain.adapter;

/** Classe resultant de la implementació del patró Factoria, per a l'accés als Adaptadors. **/
public class AdapterFactory {

    /** Implementació del patró Singleton. **/
    private static AdapterFactory instance = new AdapterFactory();

    /** Getters **/
    public static AdapterFactory getInstance() {
        return instance;
    }

    private AdapterFactory() {
    }

    public IConvertorAdapter getConvertor() {
        return new ConvertorAdapter();
    }

    public IBankAdapter getBank() {
        return new BankAdapter();
    }
}
