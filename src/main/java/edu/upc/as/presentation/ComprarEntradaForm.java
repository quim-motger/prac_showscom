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
    private ComprarEntradaController ctrl;

    public ComprarEntradaForm(ComprarEntradaController c) {
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
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prOkConsultaRepresentacions("", null);
            }
        });
        setVisible(true);
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
        setContentPane(rootPanel);
    }

}
