package edu.upc.as.presentation;

import edu.upc.as.domain.utils.InfoRepresentacio;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by jmotger on 13/01/16.
 */
public class ShowRepresentacions extends JFrame {
    private JPanel rootPanel;
    private JButton cancelButton;
    private JButton OKButton;
    private JLabel errorMessage;
    private JTextField nEspectadorsField;
    private JList representacionsList;
    private JSpinner nEspectadors;
    private ComprarEntradaController ctrl;

    public ShowRepresentacions(ComprarEntradaController c, List<InfoRepresentacio> repre) {
        super("Comprar Entrada");
        this.ctrl = c;
        setContentPane(rootPanel);
        pack();

        final DefaultListModel resultList = new DefaultListModel();
        representacionsList.setModel(resultList);

        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
        spinnerNumberModel.setMinimum(1);
        nEspectadors.setModel(spinnerNumberModel);

        for (InfoRepresentacio r : repre) {
            String s;
            if (r.estrena) s = "Estrena";
            else s = "No estrena";
            resultList.addElement(r.nomLocal + " - " + r.sessio + " - " + r.nombreSeientsLliures + " - " + s + " - " + r.preu);
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrl.prCancel();
            }
        });
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = (String) representacionsList.getSelectedValue();
                String info[] = s.split(" - ");
                ctrl.prOkConsultaOcupacions(info[0],info[1], (Integer) nEspectadors.getValue());
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
