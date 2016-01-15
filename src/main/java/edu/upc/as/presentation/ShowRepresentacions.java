package edu.upc.as.presentation;

import edu.upc.as.domain.utils.InfoRepresentacio;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
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
    private int selectedItem;

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
        representacions.getColumnModel().getColumn(0).setMinWidth(180);
        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
        spinnerNumberModel.setValue(1);
        nEspectadors.setModel(spinnerNumberModel);

        for (InfoRepresentacio r : repre) {
            String s;
            if (r.estrena) s = "Sí";
            else s = "No";
            tableModel.addRow(Arrays.asList(r.nomLocal, r.sessio, r.nombreSeientsLliures, s, r.preu).toArray());
        }

        representacions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        representacions.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                selectedItem = representacions.getSelectedRow();
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prCancel();
            }
        });
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = selectedItem;
                if (i <0) {
                    errorMessage.setText("No s'ha seleccionat la representació");
                } else {
                    int n = (Integer) nEspectadors.getValue();

                    ctrl.prOkConsultaOcupacions(repre.get(i).nomLocal, repre.get(i).sessio.name(), n);
                }
            }
        });
        setVisible(true);
        representacions.addMouseListener(new MouseAdapter() {
        });
        representacions.addMouseListener(new MouseAdapter() {
        });
        representacions.addMouseListener(new MouseAdapter() {
        });
        representacions.addMouseListener(new MouseAdapter() {
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setErrorMessage(String message) {
        errorMessage.setText(message);
    }

}
