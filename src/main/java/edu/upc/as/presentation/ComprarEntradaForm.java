package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


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
    private DateFormat data;

    public ComprarEntradaForm(ComprarEntradaController c) {
        super("Comprar Entrada");
        this.ctrl = c;
        setContentPane(rootPanel);
        pack();
        data = new SimpleDateFormat("MM/dd/yyyy");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prCancel();
            }
        });
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prOkConsultaRepresentacions(
                        (String)espectaclesList.getSelectedValue(),
                        /*data.parse(dataField.getText())*/ null);
            }
        });
        setVisible(true);
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
        setContentPane(rootPanel);
    }

}
