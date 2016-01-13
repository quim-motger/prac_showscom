package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cpuig on 13/01/2016.
 */
public class ShowOcupacions extends JFrame {
    private JPanel rootPanel;
    private JButton cancelButton;
    private JTable table1;
    private JButton OKButton;
    private JLabel errorMessage;
    private ComprarEntradaController c;

    public ShowOcupacions(ComprarEntradaController ctrl) {
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
                c.prOkSeleccionaSeients(null);
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
