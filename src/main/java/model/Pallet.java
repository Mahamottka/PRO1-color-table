package model;

import tableModel.TableModel;
import utils.ColorBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Pallet {

    private JPanel panel, panel2, panel3;
    private JFrame frame;
    private JTable table;
    private String tempHexa;
    ColorBox colorBox = new ColorBox(tempHexa);
    private TableModel tableModel = new TableModel();

    public Pallet() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Barvomíchačka");

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.SOUTH);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 5)); // Set GridLayout with 1 row and 4 columns
        frame.add(panel2, BorderLayout.NORTH);




        JTextField textR = new JTextField("R");

        JTextField textG = new JTextField("G");

        JTextField textB = new JTextField("B");


        JButton submit = new JButton("Submit");
        submit.setBounds(100, 100, 100, 30);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = textR.getText();
                String userInput2 = textG.getText();
                String userInput3 = textB.getText();
                try {
                    int barvicka = Integer.parseInt(userInput);
                    int barvicka2 = Integer.parseInt(userInput2);
                    int barvicka3 = Integer.parseInt(userInput3);
                    Barva barva = new Barva(barvicka, barvicka2, barvicka3);
                    tableModel.addColor(barva);
                    colorBox.setHexCode(barva.getHexa());
                } catch (Exception exception){
                    System.out.println("Zadali jste nesprávnou hodnotu: " + exception);
                }
            }
        });

        JButton json = new JButton("Save");
        submit.setBounds(100, 100, 100, 30);
        json.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser dialog = new JFileChooser(".");
                if (dialog.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    String soubor = dialog.getSelectedFile().getPath();
                    try {
                        tableModel.saveToJson(soubor);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Při ukladání JSON nastala chyba");
                    }
                }
            }
        });


        System.out.println(tempHexa);
        table = new JTable();
        table.setModel(tableModel);
        table.setFillsViewportHeight(true);

        JScrollPane scPane = new JScrollPane(table);
        panel.add(scPane);
        panel2.add(textR);
        panel2.add(textG);
        panel2.add(textB);
        panel2.add(submit);
        panel2.add(colorBox);
        panel2.add(json);

        frame.pack();
        frame.setVisible(true);
    }
}
