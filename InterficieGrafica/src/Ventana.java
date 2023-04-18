import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    int width = 900;
    int height = 600;
    JComboBox combowombo;
    JTextField campoTexto;
    JLabel sortida;
    JButton boton;
    public Ventana(){
        this.setTitle("Eso es mi ventana"); //add title
        this.setSize(width, height); //set size of the window
        //this.getContentPane().setPreferredSize(new Dimension(width, height)); //PENDENT
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Close the window when exit
        Image imagen = Toolkit.getDefaultToolkit().getImage("./Images/130188.png"); //Load an image
        this.setIconImage(imagen); //Change the icon image
        this.setLayout(null);

        //PANEL
        JPanel panel1 = new JPanel();
        panel1.setBounds(50,30,500, 500);
        panel1.setBackground(Color.ORANGE);

        JLabel intro = new JLabel("Escribeme algo:");
        intro.setBounds(280,300,150,20);
        campoTexto = new JTextField();
        campoTexto.setBounds(400,300,150,20);
        sortida = new JLabel("");
        sortida.setBounds(400,500,150,20);

        //COMBOBOX
        String[] llista = {"", "Inca","Campanet","Lloseta"};
        combowombo = new JComboBox(llista);
        combowombo.setBounds(400,350,150,20);


        boton =new JButton("Calcular");
        boton.setBounds(400,400,150,20);
        boton.addActionListener(e -> { //Lambda expression
            sortida.setText(campoTexto.getText());
        });


        panel1.add(boton);
        this.add(combowombo);
        this.add(sortida);
        this.add(intro);
        this.add(campoTexto);
        this.add(panel1);
        this.setVisible(true); //Mandatory to show the window
    }

    public static void main(String[] args) {
        new Ventana();
    }

}

