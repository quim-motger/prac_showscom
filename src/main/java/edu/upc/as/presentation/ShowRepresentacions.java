package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jmotger on 13/01/16.
 */
public class ShowRepresentacions extends JFrame {
    private JPanel rootPanel;
    private JButton cancelButton;
    private JButton OKButton;
    private JLabel errorMessage;
    private JTable representacionsTable;
    private JTextField nEspectadorsField;
    private ComprarEntradaController c;

    public ShowRepresentacions(ComprarEntradaController ctrl) {
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
                c.prOkConsultaOcupacions("", "", 0);
            }
        });
        setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
