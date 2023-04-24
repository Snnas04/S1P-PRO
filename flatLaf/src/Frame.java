import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    JLabel label;
    JLabel enLabel;
    JLabel disLabel;

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

        label = new JLabel("JLabel:");
        label.setBounds(15, 15, 50, 25);

        add(label);

        enLabel = new JLabel("Enables");
        enLabel.setBounds(100, 15, 50, 25);
        enLabel.setEnabled(true);

        add(enLabel);

        disLabel = new JLabel("Disabled");
        disLabel.setBounds(200, 15, 70, 25);
        disLabel.setEnabled(false);

        add(disLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
