package edu.upc.as.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 * Created by cpuig on 13/01/2016.
 */
public class ShowCompra extends JFrame{
    private JPanel rootPanel;
    private JList monedesList;
    private JButton canviMonedaButton;
    private JTextField dniField;
    private JTextField codiBancField;
    private JTextField nCompteField;
    private JButton cancelButton;
    private JButton OKButton;
    private JLabel errorMessage;
    private JLabel preu;
    private JLabel canvi;
    private JLabel moneda;
    private ComprarEntradaController ctrl;

    public ShowCompra (ComprarEntradaController c, float preu, List<String> canvis) {
        this.ctrl = c;
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultListModel resultList = new DefaultListModel();
        monedesList.setModel(resultList);

        setMinimumSize(new Dimension(600,300));



        for (String s : canvis) resultList.addElement(s);

        this.preu.setText(String.valueOf(Math.round(preu*100.0)/100.0));

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prCancel();
            }
        });
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dniField.getText().equals("") || codiBancField.getText().equals("") || nCompteField.getText().equals("")) {
                    errorMessage.setText("No s'han introduït totes les dades per realitzar la compra");
                } else {
                    try {
                        int i = Integer.parseInt(codiBancField.getText());
                        ctrl.prOkPagament(dniField.getText(), i, nCompteField.getText());
                    } catch (NumberFormatException e1) {
                        errorMessage.setText("Codi banc ha de ser de format numèric");
                    }
                }
            }
        });
        canviMonedaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = (String) monedesList.getSelectedValue();
                if (s == null) errorMessage.setText("No s'ha seleccionat cap moneda");
                else {
                    ctrl.prObtePreuMoneda((String)monedesList.getSelectedValue());
                }
            }
        });
        setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setErrorMessage(String message) {
        errorMessage.setText(message);
    }

    public void setCanvi(float f, String m) {
        canvi.setText(String.valueOf(Math.round(f*100.0)/100.0));
        moneda.setText(m);
    }

}
