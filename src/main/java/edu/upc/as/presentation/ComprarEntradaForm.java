package edu.upc.as.presentation;

import com.toedter.calendar.JDateChooser;
import edu.upc.as.domain.controllers.FactoriaCasosUs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
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
    private JDateChooser dataField;
    private ComprarEntradaController ctrl;
    private DateFormat data;

    @SuppressWarnings("unchecked")
    public ComprarEntradaForm(ComprarEntradaController c)  {
        super("Comprar Entrada");
        dataField = new JDateChooser(new Date());
        dataField.setDate(new Date());
        this.ctrl = c;
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600,300));

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

                ctrl.prOkConsultaRepresentacions(
                        (String) espectaclesList.getSelectedValue(), dataField.getDate());
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
