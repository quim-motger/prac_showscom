package edu.upc.as.presentation;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

/**
 * Created by jmotger on 14/01/16.
 */
public class MainForm extends JFrame {
    private JPanel panel1;
    private JLabel errorMessage;
    private JPanel mainPanel;

    public MainForm() {
        super("Comprar Entrada");
        setContentPane(panel1);
        pack();
        setVisible(true);
    }

    public void setMainPanel(JPanel mainP, String card) {
        this.mainPanel.add(mainP, card);

        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, card);
       // this.mainPanel.add(mainP, 0);
        //getContentPane().add(mainP, BorderLayout.CENTER);
       // ((CardLayout)this.mainPanel.getLayout()).first(mainPanel);
       // this.mainPanel = mainP;


    }

    public void setErrorMessage(String message) {
        errorMessage.setText(message);
    }

}
