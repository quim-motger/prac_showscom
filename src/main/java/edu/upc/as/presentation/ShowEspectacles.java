package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jmotger on 12/01/16.
 */
public class ShowEspectacles extends JFrame {


    private JList list1;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel rootPanel;
    private JLabel errorMessage;

    public ShowEspectacles() {
        super("Comprar Entrada");
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
                errorMessage.setText("Encara no hi ha res fet! :)");
            }
        });
        setVisible(true);
    }
}
