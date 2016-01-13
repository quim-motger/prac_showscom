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
    private ComprarEntradaController c;

    public ShowCompra (ComprarEntradaController ctrl) {
        super("Comprar Entrada");
        this.c = ctrl;
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
                c.prOkPagament("", 0, "");
            }
        });
        canviMonedaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.prObtePreuMoneda("");
            }
        });
        setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
