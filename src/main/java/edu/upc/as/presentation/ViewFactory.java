package edu.upc.as.presentation;

/**
 * Created by jmotger on 12/01/16.
 */
public class ViewFactory {
    private static ViewFactory ourInstance = new ViewFactory();

    public static ViewFactory getInstance() {
        return ourInstance;
    }

    private ViewFactory() {
    }

    public ComprarEntradaView getComprarEntradaView() {
        return new ComprarEntradaSistemaView();
    }

}
