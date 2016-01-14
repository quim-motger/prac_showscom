package edu.upc.as.presentation;

import edu.upc.as.domain.utils.InfoOcupacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpuig on 13/01/2016.
 */
public class ShowOcupacions extends JFrame {
    private JPanel rootPanel;
    private JButton cancelButton;
    private JButton OKButton;
    private JLabel errorMessage;
    private JList ocupacioList;
    private ComprarEntradaController c;

    public ShowOcupacions(ComprarEntradaController ctrl, List<InfoOcupacio> ocup) {
        this.c = ctrl;
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultListModel resultList = new DefaultListModel();
        ocupacioList.setModel(resultList);

        setMinimumSize(new Dimension(600,300));

        for (InfoOcupacio infoOcupacio : ocup) resultList.addElement(infoOcupacio.fila + " - " + infoOcupacio.columna);

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.prCancel();
            }
        });
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<String> l =  ocupacioList.getSelectedValuesList();
                List<InfoOcupacio> ocup = new ArrayList<InfoOcupacio>();
                if (l == null) {
                    errorMessage.setText("Falta informació");
                }
                else {
                    for (String s : l) {
                        String info[] = s.split(" - ");
                        InfoOcupacio i = new InfoOcupacio();
                        i.fila = Integer.parseInt(info[0]);
                        i.columna = Integer.parseInt(info[1]);
                        ocup.add(i);
                    }
                    c.prOkSeleccionaSeients(ocup);
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
