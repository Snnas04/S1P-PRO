import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogIn extends JFrame implements ActionListener {
    private JLabel titleLabel, userLabel, passLabel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton, resetButton, singupButton;

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

        add(passText);
        add(userText);

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
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actionPerformed(new ActionEvent(loginButton, ActionEvent.ACTION_PERFORMED, null));
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = userText.getText();
            String pass = String.valueOf(passText.getPassword());

            if ((user.equals("admin") && pass.equals("admin"))) {
                JOptionPane.showMessageDialog(this, "Login successful");
                dispose();
                new Window();
            } else if (user.equals("") && pass.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a username and password");
            } else if (user.equals("") && !pass.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a username");
            } else if (!user.equals("") && pass.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a password");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } else if (e.getSource() == resetButton) {
            userText.setText("");
            passText.setText("");
        }
    }
}
