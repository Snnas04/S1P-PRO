import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*In general, when you want to set a border on a standard Swing component other than JPanel or JLabel,
  we recommend that you put the component in a JPanel and set the border on the JPanel.*/
public class SignUp extends JFrame implements ActionListener {
    private JLabel titleLabel, userLabel, nameLabel, surnameLabel, passLabel, repeatPassLabel, brithDateLabel, emailLabel, phoneLabel, genderLabel, countryLabel, provinceLabel, zipCodeLabel;
    private JTextField userText, nameText, surnameText, emailText, phoneText, zipCodeText;
    private JPasswordField passText, repeatPassText;
    private JComboBox<String> genderComboBox, countriesComboBox, provinceComboBox;
    private JScrollPane countriesScrollPane, provincesScrollPane;
    private JButton createAccountButton, loginButton;
    private JDateChooser dateChooser;

    public SignUp() {
        this.setTitle("Login App");
        this.setSize(450, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

//LABEL TITLE
        titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(150, 30, 200, 30);

        this.add(titleLabel);

//LABEL USERNAME
        userLabel = new JLabel("Username*");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userLabel.setBounds(30, 100, 100, 30);

        this.add(userLabel);

//USERNAME TEXTFIELD
        userText = new JTextField();
        userText.setToolTipText("ENTER YOUR USERNAME");
        userText.setFont(new Font("Arial", Font.PLAIN, 16));
        userText.setBounds(200, 100, 190, 30);

        this.add(userText);

//LABEL PASSWORD
        passLabel = new JLabel("Password*");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passLabel.setBounds(30, 140, 100, 30);

        this.add(passLabel);

//PASSWORD TEXTFIELD
        passText = new JPasswordField();
        passText.setFont(new Font("Arial", Font.PLAIN, 16));
        passText.setBounds(200, 140, 190, 30);

        this.add(passText);

//LABEL REPEATPASSWORD
        repeatPassLabel = new JLabel("Confirm Password*");
        repeatPassLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        repeatPassLabel.setBounds(30, 180, 150, 30);

        this.add(repeatPassLabel);

//REPEATPASSWORD TEXTFIELD
        repeatPassText = new JPasswordField();
        repeatPassText.setFont(new Font("Arial", Font.PLAIN, 16));
        repeatPassText.setBounds(200, 180, 190, 30);

        this.add(repeatPassText);

//LABEL NAME
        nameLabel = new JLabel("First Name*");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setBounds(30, 220, 100, 30);

        this.add(nameLabel);

//NAME TEXTFIELD
        nameText = new JTextField();
        nameText.setFont(new Font("Arial", Font.PLAIN, 16));
        nameText.setBounds(200, 220, 190, 30);

        this.add(nameText);

//LABEL SURNAME
        surnameLabel = new JLabel("Last Name*");
        surnameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        surnameLabel.setBounds(30, 260, 100, 30);

        this.add(surnameLabel);

//SURNAME TEXTFIELD
        surnameText = new JTextField();
        surnameText.setFont(new Font("Arial", Font.PLAIN, 16));
        surnameText.setBounds(200, 260, 190, 30);

        this.add(surnameText);

//LABEL BIRTHDATE
        brithDateLabel = new JLabel("Birth Date*");
        brithDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        brithDateLabel.setBounds(30, 300, 150, 30);

        this.add(brithDateLabel);

//BIRTHDATE JCALENDAR
        dateChooser = new JDateChooser();
        dateChooser.setForeground(Color.WHITE);
        dateChooser.setBounds(200, 300, 190, 30);

        add(dateChooser);

//LABEL EMAIL
        emailLabel = new JLabel("Email*");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailLabel.setBounds(30, 340, 150, 30);

        this.add(emailLabel);

//EMAIL TEXTFIELD
        emailText = new JTextField();
        emailText.setFont(new Font("Arial", Font.PLAIN, 16));
        emailText.setBounds(200, 340, 190, 30);

        this.add(emailText);

//LABEL PHONENUMBER
        phoneLabel = new JLabel("Phone Number*");
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneLabel.setBounds(30, 380, 150, 30);

        this.add(phoneLabel);

//PHONENUMBER TEXTFIELD
        phoneText = new JTextField();
        phoneText.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneText.setBounds(200, 380, 190, 30);

        this.add(phoneText);

//LABEL GENDER
        genderLabel = new JLabel("Gender*");
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        genderLabel.setBounds(30, 420, 150, 30);

        this.add(genderLabel);

//GENDER JCOMBOBOX
        String genders[] = {"","Male","Female", "Other"};
        genderComboBox = new JComboBox(genders);
        genderComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        genderComboBox.setBounds(200, 420, 190, 30);

        this.add(genderComboBox);

//LABEL COUNTRY
        countryLabel = new JLabel("Country*");
        countryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        countryLabel.setBounds(30, 460, 150, 30);

        this.add(countryLabel);

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

        this.add(countriesComboBox);

//LABEL PROVINCE
        provinceLabel = new JLabel("Province*");
        provinceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        provinceLabel.setBounds(30, 500, 150, 30);
        this.add(provinceLabel);

        provinceLabel.setVisible(true);

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
        provinceComboBox.setEnabled(false);
        
        add(provinceComboBox);

//LABEL ZIPCODE
        zipCodeLabel = new JLabel("Zip Code*");
        zipCodeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        zipCodeLabel.setBounds(30, 540, 150, 30);

        this.add(zipCodeLabel);

        zipCodeLabel.setVisible(true);

//ZIPCODE TEXTFIELD
        zipCodeText = new JTextField();
        zipCodeText.setFont(new Font("Arial", Font.PLAIN, 16));
        zipCodeText.setBounds(200, 540, 190, 30);
        zipCodeText.setEnabled(false);

        this.add(zipCodeText);

        countriesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) countriesComboBox.getSelectedItem();
                if (selectedCountry.equals("Spain")) {
                    provinceComboBox.setEnabled(true);
                    zipCodeText.setEnabled(true);
                }
            }
        });

//BUTTONS
        createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createAccountButton.setBounds(100, 600, 150, 30);
        createAccountButton.addActionListener(this);

        this.add(createAccountButton);

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

        this.add(loginButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createAccountButton) {
            String user = userText.getText();
            String pass = String.valueOf(passText.getPassword());
        }
    }
}
