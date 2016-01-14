package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jmotger on 14/01/16.
 */
public class EndErrorView extends JFrame {
    private JPanel rootPanel;
    private JButton okButton;
    private JLabel message;
    private ComprarEntradaController c;

    public EndErrorView(ComprarEntradaController ctrl) {
        super("Comprar Entrada");
        this.c = ctrl;
        setContentPane(rootPanel);
        pack();

        setMinimumSize(new Dimension(600,300));

        message.setText("La transferència no s'ha pogut realitzar correctament");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.prOkMissatgeFi();
            }
        });

        setVisible(true);
    }

}
