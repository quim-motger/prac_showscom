package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jmotger on 14/01/16.
 */
public class EndView extends JFrame{
    private JPanel rootPanel;
    private JButton okButton;
    private JLabel message;
    private ComprarEntradaController c;

    public EndView(ComprarEntradaController ctrl) {
        super("Comprar Entrada");
        this.c = ctrl;
        setContentPane(rootPanel);
        pack();

        message.setText("Pagament i emissió d'entrada realitzats correctament. Passi a recollir-la per la seva entitat bancària");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.prOkMissatgeFi();
            }
        });

        setVisible(true);
    }
}
