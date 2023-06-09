import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogIn extends JFrame implements ActionListener {
    private JLabel titleLabel, userLabel, passLabel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton, resetButton, singupButton, showHideButton;

    public LogIn() {
        setTitle("Log In");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

// LABEL
        titleLabel = new JLabel("Login Form");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(180, 30, 200, 30);

        userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userLabel.setBounds(100, 100, 100, 30);

        add(titleLabel);
        add(userLabel);

// TEXTFIELD
        userText = new JTextField();
        userText.setFont(new Font("Arial", Font.PLAIN, 16));
        userText.setBounds(200, 100, 190, 30);

        passText = new JPasswordField();
        passText.setFont(new Font("Arial", Font.PLAIN, 16));
        passText.setBounds(200, 140, 190, 30);

        ImageIcon openIcon = new ImageIcon("./img/eye_open.png");
        ImageIcon closeIcon = new ImageIcon("./img/eye_close.png");

        showHideButton = new JButton(openIcon); // mostrar
        showHideButton.setBounds(390, 140, 40, 30);
        showHideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showHideButton.getIcon().equals(closeIcon)) {
                    passText.setEchoChar('·');
                    passText.setFont(new Font("Arial", Font.BOLD, 22));
                    showHideButton.setIcon(openIcon); // mostrar
                } else {
                    passText.setEchoChar('\u0000');
                    passText.setFont(new Font("Arial", Font.PLAIN, 16));
                    showHideButton.setIcon(closeIcon); // oclutar
                }
            }
        });

        add(passText);
        add(userText);
        add(showHideButton);

// PASSWORD
        passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passLabel.setBounds(100, 140, 100, 30);

        add(passLabel);

//BUTTONS
        singupButton = new JButton("Singup");
        singupButton.setFont(new Font("Arial", Font.PLAIN, 16));
        singupButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        singupButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                new SignUp();
            }
        });
        singupButton.setBounds(100, 200, 90, 30);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        loginButton.setBounds(200, 200, 90, 30);

        userText.addActionListener(textAction);
        passText.addActionListener(textAction);

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                validateLogin();
            }
        });

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 16));
        resetButton.setBounds(300, 200, 90, 30);
        resetButton.addActionListener(this);

        add(singupButton);
        add(loginButton);
        add(resetButton);

        setVisible(true);
    }

    private ActionListener loginAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            validateLogin();
        }
    };

    private ActionListener textAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            loginAction.actionPerformed(e);
        }
    };

    public void validateLogin() {
        actionPerformed(new ActionEvent(loginButton, ActionEvent.ACTION_PERFORMED, null));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = userText.getText();
            String pass = String.valueOf(passText.getPassword());
            if ((user.equals("admin") && pass.equals("admin"))) {
                dispose();
                new Window();
                JOptionPane.showMessageDialog(this, "Welcome " + user.toUpperCase() + "! I hope you enjoy!");
            }
            else {
                char[] passwordChars = pass.toCharArray();

                try {
                    Scanner scanner = new Scanner(new File("credenciales.txt"));
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] parts = line.split(":"); // separador es un colon

                        if (parts.length == 2 && parts[0].equals(user) && parts[1].equals(SignUp.hashPassword(passwordChars))) {
                            // Iniciar sesión
                            dispose();
                            new Window();
                            JOptionPane.showMessageDialog(this, "Welcome " + user + "!");
                        }
                        else {
                            JOptionPane.showMessageDialog(this, "Incorrect credentials");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al verificar las credenciales");
                }
            }
        } else if (e.getSource() == resetButton) {
            userText.setText("");
            passText.setText("");
        }
    }
}
