package edu.upc.as.presentation;

import edu.upc.as.domain.utils.InfoOcupacio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cpuig on 13/01/2016.
 */
public class ShowOcupacions extends JFrame {
    private JPanel rootPanel;
    private JButton cancelButton;
    private JButton OKButton;
    private JLabel errorMessage;
    private JTable ocupacions;
    private ComprarEntradaController c;
    private final List<InfoOcupacio> ocupacios;

    public ShowOcupacions(ComprarEntradaController ctrl, List<InfoOcupacio> ocup) {
        this.c = ctrl;
        this.ocupacios = ocup;
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        List<String> headers = Arrays.asList("Fila", "Columna");

        final DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers.toArray());
        ocupacions.setModel(tableModel);

        setMinimumSize(new Dimension(600,300));

        for (InfoOcupacio io : ocup) {
            tableModel.addRow(Arrays.asList(io.fila, io.columna).toArray());
        }

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.prCancel();
            }
        });
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRows[] = ocupacions.getSelectedRows();
                List<InfoOcupacio> ocup = new ArrayList<InfoOcupacio>();
                for (int i  : selectedRows) {
                    InfoOcupacio inf = new InfoOcupacio();
                    inf.fila = ocupacios.get(i).fila;
                    inf.columna = ocupacios.get(i).columna;
                    ocup.add(inf);
                }
                c.prOkSeleccionaSeients(ocup);
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
