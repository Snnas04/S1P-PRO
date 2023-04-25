import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    // components name
    JLabel label;
    JLabel button;

    // labels
    JLabel enLabel;
    JLabel disLabel;

    // buttons
    JButton enButton;
    JButton disButton;
    JButton squButton;
    JButton rouButton;

    public Frame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            FlatMacDarkLaf.updateUI();
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setPreferredSize(new Dimension(800, 600));
        setLayout(null);
        pack();

        //posicions
        int columna1 = 15;
        int columna2 = 150;
        int columna3 = 300;
        int columna4 = 450;
        int columna5 = 600;

        int fila1 = 15;
        int fila2 = 35;

        int labWidth = 70;
        int labHeight = 25;

        int butWidth = 100;
        int butHeigth = 25;

        // components names
        label = new JLabel("JLabel:");
        label.setBounds(columna1, fila1, labWidth, labHeight);

        button = new JLabel("JButton");
        button.setBounds(columna1, fila2, labWidth, labHeight);

        add(label);
        add(button);

        // lables
        enLabel = new JLabel("Enables");
        enLabel.setBounds(columna2, fila1, labWidth, labHeight);
        enLabel.setEnabled(true);

        disLabel = new JLabel("Disabled");
        disLabel.setBounds(columna3, fila1, labWidth, labHeight);
        disLabel.setEnabled(false);

        add(enLabel);
        add(disLabel);

        // buttons
        enButton = new JButton("Enable");
        enButton.setBounds(columna2, fila2, butWidth, butHeigth);
        enButton.setEnabled(true);

        disButton = new JButton("Disabled");
        disButton.setBounds(columna3, fila2, butWidth, butHeigth);
        disButton.setEnabled(false);

        squButton = new JButton("Square");
        squButton.setBounds(columna4, fila2, butWidth, butHeigth);
        squButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        rouButton = new JButton("Round");
        rouButton.setBounds(columna5, fila2, butWidth, butHeigth);
        rouButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        add(enButton);
        add(disButton);
        add(squButton);
        add(rouButton);


        setLocationRelativeTo(null);
        setVisible(true);
    }
}
