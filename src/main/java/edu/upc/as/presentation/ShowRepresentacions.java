package edu.upc.as.presentation;

import javax.swing.*;

/**
 * Created by jmotger on 13/01/16.
 */
public class ShowRepresentacions extends JFrame {
    private JPanel rootPanel;

    public ShowRepresentacions() {
        setContentPane(rootPanel);
        setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
