import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {
    JButton logOutButton;
    Icon logOutIcon;

    public Window() {
        setTitle("Main Window");
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
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to log out?",
                        "Log Out",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (confirmed == JOptionPane.YES_OPTION) {
                    dispose();
                    new LogIn();
                }
            }
        });

        add(logOutButton);

        setVisible(true);
    }
}
