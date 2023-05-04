import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Program extends JFrame {
    JButton logOutButton;
    Icon logOutIcon;


    public Program() {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            FlatMacDarkLaf.updateUI();
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Main Program");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        logOutIcon = new ImageIcon("./img/logoutIcon.png");

        logOutButton = new JButton("Log Out", logOutIcon);
        logOutButton.setBounds(865, 25, 110, 50);
        logOutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                new LogIn();
            }
        });

        add(logOutButton);

        setVisible(true);
    }
}
