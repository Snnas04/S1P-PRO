import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.RecursiveTask;

/*In general, when you want to set a border on a standard Swing component other than JPanel or JLabel,
  we recommend that you put the component in a JPanel and set the border on the JPanel.*/
public class SignUp extends JFrame implements ActionListener {
    private JLabel titleLabel, userLabel, nameLabel, surnameLabel, passLabel, passRequiresLabel, repeatPassLabel, brithDateLabel, emailLabel, phoneLabel, genderLabel, countryLabel, provinceLabel, zipCodeLabel;
    private JTextField userText, nameText, surnameText, emailText, phoneText, zipCodeText;
    private JPasswordField passText, repeatPassText;
    private JComboBox<String> genderComboBox, countriesComboBox, provinceComboBox;
    private JScrollPane countriesScrollPane, provincesScrollPane;
    private JButton createAccountButton, loginButton, showHideButton;
    private JDateChooser dateChooser;

    public SignUp() {
        setTitle("Login App");
        setSize(600, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

//LABEL TITLE
        titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(150, 30, 200, 30);

        add(titleLabel);

//LABEL USERNAME
        userLabel = new JLabel("Username*");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userLabel.setBounds(30, 100, 100, 30);

        add(userLabel);

//USERNAME TEXTFIELD
        userText = new JTextField();
        userText.setToolTipText("ENTER YOUR USERNAME");
        userText.setFont(new Font("Arial", Font.PLAIN, 16));
        userText.setBounds(200, 100, 190, 30);

        add(userText);

//LABEL PASSWORD
        passLabel = new JLabel("Password*");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passLabel.setBounds(30, 140, 100, 30);

        add(passLabel);

//PASSWORD TEXTFIELD
        passText = new JPasswordField();
        passText.setFont(new Font("Arial", Font.PLAIN, 16));
        passText.setBounds(200, 140, 190, 30);

        add(passText);

//PASSWORD REQUIRES
        String requires = "<html>The password at least must contain:<br> · One Capital letter<br> · One lower letter<br> · One number<br> · One special character<br> · 8 characters minimum</html>";
        passRequiresLabel = new JLabel(requires);
        passRequiresLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passRequiresLabel.setBounds(400, 180, 190, 120);
        passRequiresLabel.setForeground(new Color(105,105,105));
        add(passRequiresLabel);

//LABEL REPEATPASSWORD
        repeatPassLabel = new JLabel("Confirm Password*");
        repeatPassLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        repeatPassLabel.setBounds(30, 180, 150, 30);

        add(repeatPassLabel);

//REPEATPASSWORD TEXTFIELD
        repeatPassText = new JPasswordField();
        repeatPassText.setFont(new Font("Arial", Font.PLAIN, 16));
        repeatPassText.setBounds(200, 180, 190, 30);

        add(repeatPassText);

        ImageIcon openIcon = new ImageIcon("./img/eye_open.png");
        ImageIcon closeIcon = new ImageIcon("./img/eye_close.png");

        showHideButton = new JButton(openIcon); // mostrar
        showHideButton.setBounds(390, 140, 40, 30);
        showHideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showHideButton.getIcon().equals(closeIcon)) {
                    passText.setEchoChar('·');
                    repeatPassText.setEchoChar('·');
                    passText.setFont(new Font("Arial", Font.BOLD, 22));
                    repeatPassText.setFont(new Font("Arial", Font.BOLD, 22));
                    showHideButton.setIcon(openIcon); // mostrar
                } else {
                    passText.setEchoChar('\u0000');
                    repeatPassText.setEchoChar('\u0000');
                    passText.setFont(new Font("Arial", Font.PLAIN, 16));
                    repeatPassText.setFont(new Font("Arial", Font.PLAIN, 16));
                    showHideButton.setIcon(closeIcon); // oclutar
                }
            }
        });

        add(showHideButton);

//LABEL NAME
        nameLabel = new JLabel("First Name*");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setBounds(30, 220, 100, 30);

        add(nameLabel);

//NAME TEXTFIELD
        nameText = new JTextField();
        nameText.setFont(new Font("Arial", Font.PLAIN, 16));
        nameText.setBounds(200, 220, 190, 30);

        add(nameText);

//LABEL SURNAME
        surnameLabel = new JLabel("Last Name*");
        surnameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        surnameLabel.setBounds(30, 260, 100, 30);

        add(surnameLabel);

//SURNAME TEXTFIELD
        surnameText = new JTextField();
        surnameText.setFont(new Font("Arial", Font.PLAIN, 16));
        surnameText.setBounds(200, 260, 190, 30);

        add(surnameText);

//LABEL BIRTHDATE
        brithDateLabel = new JLabel("Birth Date");
        brithDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        brithDateLabel.setBounds(30, 300, 150, 30);

        add(brithDateLabel);

//BIRTHDATE JCALENDAR
        dateChooser = new JDateChooser();
        dateChooser.setForeground(Color.WHITE);
        dateChooser.setBounds(200, 300, 190, 30);

        add(dateChooser);

//LABEL EMAIL
        emailLabel = new JLabel("Email*");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailLabel.setBounds(30, 340, 150, 30);

        add(emailLabel);

//EMAIL TEXTFIELD
        emailText = new JTextField();
        emailText.setFont(new Font("Arial", Font.PLAIN, 16));
        emailText.setBounds(200, 340, 190, 30);

        add(emailText);

//LABEL PHONENUMBER
        phoneLabel = new JLabel("Phone Number*");
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneLabel.setBounds(30, 380, 150, 30);

        add(phoneLabel);

//PHONENUMBER TEXTFIELD
        phoneText = new JTextField();
        phoneText.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneText.setBounds(200, 380, 190, 30);

        add(phoneText);

//LABEL GENDER
        genderLabel = new JLabel("Gender*");
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        genderLabel.setBounds(30, 420, 150, 30);

        add(genderLabel);

//GENDER JCOMBOBOX
        String genders[] = {"","Male","Female", "Other"};
        genderComboBox = new JComboBox(genders);
        genderComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        genderComboBox.setBounds(200, 420, 190, 30);

        add(genderComboBox);

//LABEL COUNTRY
        countryLabel = new JLabel("Country*");
        countryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        countryLabel.setBounds(30, 460, 150, 30);

        add(countryLabel);

//CONTRY COMBOBOX
        String countries[] = {"","Albania","Andorra", "Armenia", "Austria", "Azerbaijan", "Belarus", "Belgium","Bosnia and Herzegovina",
                "Bulgaria","Croatia", "Cyprus", "Czechia", "Denmark", "Estonia", "Finland", "France", "Georgia",
                "Germany", "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Kazakhstan", "Kosovo", "Latvia",
                "Liechtenstein", "Lithuania", "Luxembourg", "Malta", "Moldova", "Monaco", "Montenegro", "Netherlands",
                "North Macedonia", "Norway", "Poland", "Portugal", "Romania", "Russia", "San Marino", "Serbia",
                "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "United Kingdom",
                "Vatican City"};

        countriesComboBox = new JComboBox<>(countries);
        countriesScrollPane = new JScrollPane(countriesComboBox);
        countriesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        countriesComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        countriesComboBox.setBounds(200, 460, 190, 30);

        add(countriesComboBox);

//LABEL PROVINCE
        provinceLabel = new JLabel("Province*");
        provinceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        provinceLabel.setBounds(30, 500, 150, 30);
        provinceLabel.setVisible(false);

        add(provinceLabel);

//PROVINCE COMBOBOX
        String province[] = {"","Álava","Albacete","Alicante","Almería","Asturias","Ávila","Badajoz","Barcelona","Burgos",
                "Cáceres","Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","Cuenca","Gerona","Granada",
                "Guadalajara","Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","La Coruña","La Rioja","Las Palmas",
                "León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra","Orense","Palencia","Pontevedra",
                "Salamanca","Santa Cruz de Tenerife","Segovia","Sevilla","Soria","Tarragona","Teruel","Toledo",
                "Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};

        provinceComboBox = new JComboBox<>(province);
        provincesScrollPane = new JScrollPane(provinceComboBox);
        provincesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        provinceComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        provinceComboBox.setBounds(200, 500, 190, 30);
        provinceComboBox.setVisible(false);
        
        add(provinceComboBox);

//LABEL ZIPCODE
        zipCodeLabel = new JLabel("Zip Code*");
        zipCodeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        zipCodeLabel.setBounds(30, 540, 150, 30);
        zipCodeLabel.setVisible(false);

        add(zipCodeLabel);

//ZIPCODE TEXTFIELD
        zipCodeText = new JTextField();
        zipCodeText.setFont(new Font("Arial", Font.PLAIN, 16));
        zipCodeText.setBounds(200, 540, 190, 30);
        zipCodeText.setVisible(false);

        add(zipCodeText);

        countriesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) countriesComboBox.getSelectedItem();
                if (selectedCountry.equals("Spain")) {
                    provinceLabel.setVisible(true);
                    provinceComboBox.setVisible(true);

                    zipCodeLabel.setVisible(true);
                    zipCodeText.setVisible(true);
                } else if (!selectedCountry.equals("Spain")) {
                    provinceLabel.setVisible(false);
                    provinceComboBox.setVisible(false);

                    zipCodeLabel.setVisible(false);
                    zipCodeText.setVisible(false);
                }
            }
        });

//BUTTONS
        createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createAccountButton.setBounds(100, 600, 150, 30);

        userText.addActionListener(textAction);
        passText.addActionListener(textAction);
        repeatPassText.addActionListener(textAction);
        nameText.addActionListener(textAction);
        surnameText.addActionListener(textAction);
        emailText.addActionListener(textAction);
        phoneText.addActionListener(textAction);
        zipCodeText.addActionListener(textAction);

        createAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                validateAcount();
            }
        });
        
        add(createAccountButton);

        loginButton = new JButton("LogIn");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                new LogIn();
            }
        });
        loginButton.setBounds(250, 600, 90, 30);


        add(loginButton);

        setVisible(true);
    }

    public static String hashPassword(char[] password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(String.valueOf(password).getBytes("UTF-8"));
        byte[] digest = md.digest();
        return String.format("%064x", new java.math.BigInteger(1, digest));
    }

    public void guardarCredenciales(String username, char[] password) {
        try {
            // Convertir el password en un arreglo de caracteres
            char[] passwordChars = password;

            // Cifrar el password
            String passwordCifrado = hashPassword(passwordChars);

            // Crear un archivo y escribir el username y el password cifrado en él
            File archivo = new File("credenciales.txt");
            FileWriter writer = new FileWriter(archivo, true); // El segundo parámetro indica que se debe abrir en modo "append"
            writer.write(username + ":" + passwordCifrado + "\n"); // Añadir un salto de línea para separar las credenciales
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ActionListener createAcounteAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            validateAcount();
        }
    };

    private ActionListener textAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            createAcounteAction.actionPerformed(e);
        }
    };

    public void validateAcount() {
        actionPerformed(new ActionEvent(createAccountButton, ActionEvent.ACTION_PERFORMED, null));
    }

    public void actionPerformed(ActionEvent e) {
        String error = "";

        if (!Validar.validarUsername(userText.getText())) {
            error += "Incorrect Username\n";
        }

        if (!Validar.validarPass(passText.getText())) {
            error += "Incorrect Password\n";
        }

        if (!repeatPassText.getText().equals(passText.getText())) {
            error += "Password don't match\n";
        }

        if (!Validar.validarName(nameText.getText())) {
            error += "Incorrect Name\n";
        }

        if (!Validar.validarSurname(surnameText.getText())) {
            error += "Incorrect Surname\n";
        }

        if (!Validar.validarEmail(emailText.getText())) {
            error += "Incorrect Email\n";
        }

        if (!Validar.validarPhone(phoneText.getText())) {
            error += "Incorrect phone number\n";
        }

        if (genderComboBox.getSelectedIndex() <= 0) {
            error += "Select a gender option\n";
        }

        if (countriesComboBox.getSelectedIndex() <= 0) {
            error += "Select a country\n";
        }

        String selectedCountry = (String) countriesComboBox.getSelectedItem();
        if (selectedCountry.equals("Spain")) {
            if (provinceComboBox.getSelectedIndex() <= 0) {
                error += "Select a province\n";
            }

            if (!Validar.validarZipcode(zipCodeText.getText())) {
                error += "Incorrect zipcode\n";
            }
        }

        if (!error.equals("")) {
            JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String username = userText.getText();
            char[] password = passText.getPassword();

            guardarCredenciales(username, password);
            dispose();
            new Window();
            JOptionPane.showMessageDialog(this, "Acount created, Welcome " + username + "!");
        }
    }
}
