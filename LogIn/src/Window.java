import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {
    JButton logOutButton;
    Icon logOutIcon;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem menuItem;
    JTabbedPane tabbedPane;

    public Window() {
        setTitle("Main Window");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        logOutIcon = new ImageIcon("./img/logoutIcon.png");

        logOutButton = new JButton("Log Out", logOutIcon);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        logOutButton.setBounds(840, 790, 150, 50);
        add(logOutButton);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("Archivo");
        menuItem = new JMenuItem("Edit");

        fileMenu.add(menuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Contenido del panel 1"));
        panel1.setBackground(Color.BLUE);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Contenido del panel 2"));
        panel2.setBackground(Color.RED);

        tabbedPane.add("Panel 1", panel1);
        tabbedPane.add("Panel 2", panel2);

        add(tabbedPane);

        setVisible(true);
    }
}
