package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jmotger on 12/01/16.
 */
public class ComprarEntradaForm extends JFrame {


    private JList list1;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel rootPanel;
    private JLabel errorMessage;
    private ComprarEntradaController c;

    public ComprarEntradaForm(ComprarEntradaController ctrl) {
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
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.prOkConsultaRepresentacions("", null);
            }
        });
        setVisible(true);
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
        setContentPane(rootPanel);
    }

}
