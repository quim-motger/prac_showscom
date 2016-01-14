package edu.upc.as.presentation;

import edu.upc.as.domain.utils.InfoRepresentacio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jmotger on 13/01/16.
 */
public class ShowRepresentacions extends JFrame {
    private final List<InfoRepresentacio> repre;
    private JPanel rootPanel;
    private JButton cancelButton;
    private JButton OKButton;
    private JLabel errorMessage;
    private JSpinner nEspectadors;
    private JTable representacions;
    private ComprarEntradaController ctrl;

    public ShowRepresentacions(ComprarEntradaController c, final List<InfoRepresentacio> repre) {
        this.repre = repre;
        this.ctrl = c;
        setContentPane(rootPanel);
        pack();
        setMinimumSize(new Dimension(600, 300));
        List<String> headers = Arrays.asList("Nom local", "Sessio", "Seients lliures", "Estrena", "Preu");

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers.toArray());
        representacions.setModel(tableModel);

        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
        spinnerNumberModel.setValue(1);
        nEspectadors.setModel(spinnerNumberModel);

        for (InfoRepresentacio r : repre) {
            String s;
            if (r.estrena) s = "Estrena";
            else s = "No estrena";
            tableModel.addRow(Arrays.asList(r.nomLocal, r.sessio, r.nombreSeientsLliures, s, r.preu).toArray());
        }

        representacions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prCancel();
            }
        });
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = representacions.getSelectedColumn()-2;
                if (i <0) {
                    errorMessage.setText("No s'ha seleccionat la representació");
                } else {
                    int n = (Integer) nEspectadors.getValue();

                    ctrl.prOkConsultaOcupacions(repre.get(i).nomLocal, repre.get(i).sessio.name(), n);
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
