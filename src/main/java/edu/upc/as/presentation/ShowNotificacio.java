package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cpuig on 13/01/2016.
 */
public class ShowNotificacio extends JFrame{
    private JPanel rootPanel;
    private JTextField messageNotif;
    private JButton OKButton;

    public ShowNotificacio () {
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
