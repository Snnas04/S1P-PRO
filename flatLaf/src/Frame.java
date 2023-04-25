import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    // components name
    JLabel label;
    JLabel button;
    JLabel checkBox;
    JLabel radioButton;
    JLabel comboBox;
    JLabel spinner;
    JLabel textField;
    JLabel formattedTextField;
    JLabel passwordField;
    JLabel textArea;
    JLabel editorPane;
    JLabel textPane;

    // labels
    JLabel enLabel;
    JLabel disLabel;

    // buttons
    JButton enButton;
    JButton disButton;
    JButton squButton;
    JButton rouButton;

    // checkbox
    JCheckBox enCheckBox;
    JCheckBox disCheckBox;
    JCheckBox selCheckBox;
    JCheckBox selDisCheckBox;

    // radioButton
    JRadioButton enRadioButton;
    JRadioButton disRadioButton;
    JRadioButton selRadioButton;
    JRadioButton selDisRadioButton;

    // comboBox
    JComboBox enComboBox;
    JComboBox disComboBox;
    JComboBox neComboBox;
    JComboBox neDisComboBox;
    JComboBox wideComboBox;

    // spinne
    JSpinner enSpinner;
    JSpinner disSpinner;

    // textField
    JTextField enTextField;
    JTextField disTextField;
    JTextField neTextField;
    JTextField neDisTextField;

    // formattedTextField
    JFormattedTextField enFormattedTextField;
    JFormattedTextField disFormattedTextField;
    JFormattedTextField neFormattedTextField;
    JFormattedTextField neDisFormattedTextField;

    // passwordField
    JPasswordField enPasswordField;
    JPasswordField disPasswordField;
    JPasswordField nePasswordField;
    JPasswordField neDisPasswordField;

    // textArea
    JTextArea enTextArea;
    JTextArea disTextArea;
    JTextArea neTextArea;
    JTextArea neDisTextArea;
    JTextArea nspTextArea;

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
        getContentPane().setPreferredSize(new Dimension(900, 600));
        setLayout(null);
        pack();

        //posicions
        int columna1 = 20;
        int columna2 = 150;
        int columna3 = 300;
        int columna4 = 450;
        int columna5 = 600;
        int columna6 = 750;

        int fila1 = 15;
        int fila2 = 40;
        int fila3 = 65;
        int fila4 = 90;
        int fila5 = 115;
        int fila6 = 140;
        int fila7 = 165;
        int fila8 = 190;
        int fila9 = 215;
        int fila10 = 240;

        int width = 120;
        int height = 25;

        // components names
        label = new JLabel("Label:");
        label.setBounds(columna1, fila1, width, height);

        button = new JLabel("Button:");
        button.setBounds(columna1, fila2, width, height);

        checkBox = new JLabel("CheckBox:");
        checkBox.setBounds(columna1, fila3, width, height);

        radioButton = new JLabel("RadioButton:");
        radioButton.setBounds(columna1, fila4, width, height);

        comboBox = new JLabel("ComboBox:");
        comboBox.setBounds(columna1, fila5, width, height);

        spinner = new JLabel("Spinner:");
        spinner.setBounds(columna1, fila6, width, height);

        textField = new JLabel("TextField:");
        textField.setBounds(columna1, fila7, width, height);

        formattedTextField = new JLabel("FormattedTextField:");
        formattedTextField.setBounds(columna1, fila8, width, height);

        passwordField = new JLabel("PasswordField:");
        passwordField.setBounds(columna1, fila9, width, height);

        textArea = new JLabel("TextArea:");
        textArea.setBounds(columna1, fila10, width, height);


        add(label);
        add(button);
        add(checkBox);
        add(radioButton);
        add(comboBox);
        add(spinner);
        add(textField);
        add(formattedTextField);
        add(passwordField);
        add(textArea);


        // lables
        enLabel = new JLabel("Enables");
        enLabel.setBounds(columna2, fila1, width, height);

        disLabel = new JLabel("Disabled");
        disLabel.setBounds(columna3, fila1, width, height);
        disLabel.setEnabled(false);

        add(enLabel);
        add(disLabel);

        // buttons
        enButton = new JButton("Enable");
        enButton.setBounds(columna2, fila2, width, height);

        disButton = new JButton("Disabled");
        disButton.setBounds(columna3, fila2, width, height);
        disButton.setEnabled(false);

        squButton = new JButton("Square");
        squButton.setBounds(columna4, fila2, width, height);
        squButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        rouButton = new JButton("Round");
        rouButton.setBounds(columna5, fila2, width, height);
        rouButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        add(enButton);
        add(disButton);
        add(squButton);
        add(rouButton);

        // checkBox
        enCheckBox = new JCheckBox("Enabled");
        enCheckBox.setBounds(columna2, fila3, width, height);

        disCheckBox = new JCheckBox("Disabled");
        disCheckBox.setBounds(columna3, fila3, width, height);
        disCheckBox.setEnabled(false);

        selCheckBox = new JCheckBox("Selected");
        selCheckBox.setBounds(columna4, fila3, width, height);
        selCheckBox.setSelected(true);

        selDisCheckBox = new JCheckBox("Selected disabled");
        selDisCheckBox.setBounds(columna5, fila3, width, height);
        selDisCheckBox.setSelected(true);
        selDisCheckBox.setEnabled(false);

        add(enCheckBox);
        add(disCheckBox);
        add(selCheckBox);
        add(selDisCheckBox);

        // radioButton
        enRadioButton = new JRadioButton("Enabled");
        enRadioButton.setBounds(columna2, fila4, width, height);

        disRadioButton = new JRadioButton("Disabled");
        disRadioButton.setBounds(columna3, fila4, width, height);
        disRadioButton.setEnabled(false);

        selRadioButton = new JRadioButton("Selected");
        selRadioButton.setBounds(columna4, fila4, width, height);
        selRadioButton.setSelected(true);

        selDisRadioButton = new JRadioButton("Selected disabled");
        selDisRadioButton.setBounds(columna5, fila4, width, height);
        selDisRadioButton.setSelected(true);
        selDisRadioButton.setEnabled(false);

        add(enRadioButton);
        add(disRadioButton);
        add(selRadioButton);
        add(selDisRadioButton);

        // comboBox
        String[] enOpciones = {"Enabled", "Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5"};
        String[] disOpciones = {"Disabled", "Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5"};
        String[] neOpciones = {"Not editable", "Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5"};
        String[] neDisOpciones = {"Not editable disabled", "Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5"};
        String[] wideOpciones = {"Wide Popup, for loger texts", "Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5"};

        enComboBox = new JComboBox(enOpciones);
        enComboBox.setBounds(columna2, fila5, width, height);

        disComboBox = new JComboBox(disOpciones);
        disComboBox.setBounds(columna3, fila5, width, height);
        disComboBox.setEnabled(false);

        neComboBox = new JComboBox(neOpciones);
        neComboBox.setBounds(columna4, fila5, width, height);
        neComboBox.setEditable(false);

        neDisComboBox = new JComboBox(neDisOpciones);
        neDisComboBox.setBounds(columna5, fila5, width, height);
        neDisComboBox.setEnabled(false);

        wideComboBox = new JComboBox(wideOpciones);
        wideComboBox.setBounds(columna6, fila5, width, height);
        wideComboBox.setLightWeightPopupEnabled(true);

        add(enComboBox);
        add(disComboBox);
        add(neComboBox);
        add(neDisComboBox);
        add(wideComboBox);


        // spinner
        SpinnerModel enModel = new SpinnerNumberModel(0, -25, 25, 1);
        SpinnerModel disModel = new SpinnerNumberModel(0, -10, 10, 1);

        enSpinner = new JSpinner(enModel);
        enSpinner.setBounds(columna2, fila6, width, height);

        disSpinner = new JSpinner(disModel);
        disSpinner.setBounds(columna3, fila6, width, height);
        disSpinner.setEnabled(false);

        add(enSpinner);
        add(disSpinner);

        // textField
        enTextField = new JTextField("Enabled");
        enTextField.setBounds(columna2, fila7, width, height);

        disTextField = new JTextField("Disabled");
        disTextField.setBounds(columna3, fila7, width, height);
        disTextField.setEnabled(false);

        neTextField = new JTextField("Not editable");
        neTextField.setBounds(columna4, fila7, width, height);
        neTextField.setEditable(false);

        neDisTextField = new JTextField("Not editable disabled");
        neDisTextField.setBounds(columna5, fila7, width, height);
        neDisTextField.setEnabled(false);
        neDisTextField.setEditable(false);

        add(enTextField);
        add(disTextField);
        add(neTextField);
        add(neDisTextField);

        // formatedTextField

        enFormattedTextField = new JFormattedTextField("Enabled");
        enFormattedTextField.setBounds(columna2, fila8, width, height);

        disFormattedTextField = new JFormattedTextField("Disabled");
        disFormattedTextField.setBounds(columna3, fila8, width, height);
        disFormattedTextField.setEnabled(false);

        neFormattedTextField = new JFormattedTextField("Not editable");
        neFormattedTextField.setBounds(columna4, fila8, width, height);
        neFormattedTextField.setEditable(false);

        neDisFormattedTextField = new JFormattedTextField("Not editable diabled");
        neDisFormattedTextField.setBounds(columna5, fila8, width, height);
        neDisFormattedTextField.setEditable(false);
        neDisFormattedTextField.setEnabled(false);

        add(enFormattedTextField);
        add(disFormattedTextField);
        add(neFormattedTextField);
        add(neDisFormattedTextField);

        // passwordField

        enPasswordField = new JPasswordField("Enable");
        enPasswordField.setBounds(columna2, fila9, width, height);

        disPasswordField = new JPasswordField("Disabled");
        disPasswordField.setBounds(columna3, fila9, width, height);
        disPasswordField.setEnabled(false);

        nePasswordField = new JPasswordField("Not enabled");
        nePasswordField.setBounds(columna4, fila9, width, height);
        nePasswordField.setEditable(false);

        neDisPasswordField = new JPasswordField("Not edabled disabled");
        neDisPasswordField.setBounds(columna5, fila9, width, height);
        neDisPasswordField.setEnabled(false);
        neDisPasswordField.setEditable(false);

        add(enPasswordField);
        add(disPasswordField);
        add(nePasswordField);
        add(neDisPasswordField);

        // textArea
        enTextArea = new JTextArea("Enable");
        enTextArea.setBounds(columna2, fila10, width, height);

        disTextArea = new JTextArea("Disabled");
        disTextArea.setBounds(columna3, fila10, width, height);
        disTextArea.setEnabled(false);

        neTextArea = new JTextArea("Not editable");
        neTextArea.setBounds(columna4, fila10, width, height);
        neTextArea.setEditable(false);

        neDisTextArea = new JTextArea("Not editable disable");
        neDisTextArea.setBounds(columna5, fila10, width, height);
        neDisTextArea.setEnabled(false);
        neDisTextArea.setEditable(false);

        add(enTextArea);
        add(disTextArea);
        add(neTextArea);
        add(neDisTextArea);


        // centrar i mostrar finestre
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
