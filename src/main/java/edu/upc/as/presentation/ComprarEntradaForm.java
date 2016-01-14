package edu.upc.as.presentation;

import edu.upc.as.domain.controllers.FactoriaCasosUs;
import edu.upc.as.domain.model.Espectacle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


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

    public ComprarEntradaForm(ComprarEntradaController c)  {
        super("Comprar Entrada");
        this.ctrl = c;
        setContentPane(rootPanel);
        pack();
        data = new SimpleDateFormat("MM/dd/yyyy");
        dataField.setText("MM/DD/yyyy");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultListModel resultList = new DefaultListModel();
        espectaclesList.setModel(resultList);

        List<String> l = FactoriaCasosUs.getInstance().getCtrlComprarEntrada().obteEspectacles();
        for (String s : l) resultList.addElement(s);

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prCancel();
            }
        });
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    Date d = data.parse(dataField.getText());
                    ctrl.prOkConsultaRepresentacions(
                            (String) espectaclesList.getSelectedValue(), data.parse(dataField.getText()));
                } catch (ParseException e1) {
                    errorMessage.setText("Format de data incorrecte (MM/dd/yyyy)");
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



}
