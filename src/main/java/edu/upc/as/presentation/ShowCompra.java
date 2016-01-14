package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cpuig on 13/01/2016.
 */
public class ShowCompra extends JFrame{
    private JPanel rootPanel;
    private JList monedesList;
    private JTextField totalPreuField;
    private JTextField canviPreuField;
    private JButton canviMonedaButton;
    private JTextField dniField;
    private JTextField codiBancField;
    private JTextField nCompteField;
    private JButton cancelButton;
    private JButton OKButton;
    private JLabel errorMessage;
    private ComprarEntradaController ctrl;

    public ShowCompra (ComprarEntradaController c) {
        this.ctrl = c;
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prOkPagament(dniField.getText(),Integer.parseInt(codiBancField.getText()), nCompteField.getText());
            }
        });
        canviMonedaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prObtePreuMoneda((String)monedesList.getSelectedValue());
            }
        });
        setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
