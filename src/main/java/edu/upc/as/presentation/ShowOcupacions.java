package edu.upc.as.presentation;

import edu.upc.as.domain.utils.InfoOcupacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by cpuig on 13/01/2016.
 */
public class ShowOcupacions extends FormView {
    private JPanel rootPanel;
    private JButton cancelButton;
    private JButton OKButton;
    private JLabel errorMessage;
    private JList ocupacioList;
    private ComprarEntradaController c;

    public ShowOcupacions(ComprarEntradaController ctrl, List<InfoOcupacio> ocup) {
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
