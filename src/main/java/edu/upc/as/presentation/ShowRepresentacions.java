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
    private ComprarEntradaController ctrl;

    public ShowRepresentacions(ComprarEntradaController c) {
        super("Comprar Entrada");
        this.ctrl = c;
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prCancel();
            }
        });
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prOkConsultaOcupacions("","",0);
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
