import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class Window extends JFrame {
    JButton logOutButton;
    Icon logOutIcon;
    JMenuBar menuBar;
    JMenu fileMenu, usMenu;
    JMenuItem menuEdit, menuFile, menuSave, menuLink, menuHelp, menuDonate;
    JTabbedPane tabbedPane;

    public Window() {
        setTitle("Main Window");
        setSize(1200, 800);
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

        logOutButton.setBounds(1070, 710, 120, 50);
        add(logOutButton);

        menuBar = new JMenuBar();

        fileMenu = new JMenu("Archivo");
        usMenu = new JMenu("Help");

        menuEdit = new JMenuItem("Edit");
        menuFile = new JMenuItem("File");
        menuSave = new JMenuItem("Save");

        menuHelp = new JMenuItem("Help");
        menuLink = new JMenuItem("Our web");
        menuDonate = new JMenuItem("Donate");

        menuHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Intentar abrir la página web utilizando la clase Desktop
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(new URI("https://chat.openai.com/auth/login"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("Desktop is not supported");
                }
            }
        });

        menuLink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Intentar abrir la página web utilizando la clase Desktop
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(new URI("https://paucasesnovescifp.cat/"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("Desktop is not supported");
                }
            }
        });

        menuDonate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Intentar abrir la página web utilizando la clase Desktop
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(new URI("https://classroom.google.com/u/0/c/NTQzMzAyNzU4NTI1/a/NjA3NTU3MzE2OTI1/details"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("Desktop is not supported");
                }
            }
        });

        fileMenu.add(menuEdit);
        fileMenu.add(menuFile);
        fileMenu.add(menuSave);

        usMenu.add(menuHelp);
        usMenu.add(menuLink);
        usMenu.add(menuDonate);

        menuBar.add(fileMenu);
        menuBar.add(usMenu);

        setJMenuBar(menuBar);

        ImageIcon imgBGArch = new ImageIcon("./img/arch.jpg");
        ImageIcon imgBGWindows = new ImageIcon("./img/windows.jpg");
        ImageIcon imgBGApple = new ImageIcon("./img/apple.jpg");
        ImageIcon imgBGNum = new ImageIcon("./img/numbers.jpg");

        Image img1 = imgBGArch.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        Image img2 = imgBGWindows.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        Image img3 = imgBGApple.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        Image img4 = imgBGNum.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);

        JLabel bgLabelP1 = new JLabel(new ImageIcon(img1));
        JLabel bgLabelP2 = new JLabel(new ImageIcon(img2));
        JLabel bgLabelP3 = new JLabel(new ImageIcon(img3));
        JLabel bgLabelP4 = new JLabel(new ImageIcon(img4));

        tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        tabbedPane.add("Arch", panel1);
        panel1.add(bgLabelP1);
        tabbedPane.add("Windows", panel2);
        panel2.add(bgLabelP2);
        tabbedPane.add("Apple", panel3);
        panel3.add(bgLabelP3);
        panel4.add(new GuessGamePanel());
        panel4.add(bgLabelP4);
        tabbedPane.add("Adivina el número", panel4);


        add(tabbedPane);

        setVisible(true);
    }
}
