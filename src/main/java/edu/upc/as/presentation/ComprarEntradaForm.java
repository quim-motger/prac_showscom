package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jmotger on 12/01/16.
 */
public class ComprarEntradaForm extends JFrame {


    private JList espectaclesList;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel rootPanel;
    private JLabel errorMessage;
    private JTextField dataField;

    public ComprarEntradaForm() {
        super("Comprar Entrada");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO HOW TO SOLVE THIS?
            }
        });
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO HOW TO SOLVE THIS?
            }
        });
        setVisible(true);
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
        setContentPane(rootPanel);
    }

}
