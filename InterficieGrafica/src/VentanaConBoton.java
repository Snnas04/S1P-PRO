import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaConBoton extends JFrame {
    int width = 900;
    int height = 600;
    public VentanaConBoton(){
        //SIMPLE DE HACER, SOLAMENTE UNA VENTANA SIN NADA
        this.setTitle("Eso es mi ventana"); //add title
        this.setSize(width, height); //set size of the window
        //this.getContentPane().setPreferredSize(new Dimension(width, height)); //PENDENT
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Close the window when exit
        Image imagen = Toolkit.getDefaultToolkit().getImage("./Images/130188.png"); //Load an image
        this.setIconImage(imagen); //Change the icon image
        this.setLayout(null);

        //BOTÓN, TODAVIA NO HACE NADA
        JButton boton = new JButton("Canvia el color del fons");
        boton.setBounds(width/2-120,height/4*3+50,200,25);
        //Register listener for button
        boton.addActionListener(e -> { //Lambda expression
            //Generate random RGB values
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            // Set background color of frame
            getContentPane().setBackground(new Color(r, g, b));
        });

        //ADD A LABEL TO SHOW COORDINATES
        JLabel label2 = new JLabel("X and Y coordinates");
        label2.setBounds(0,0,120,20);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label2.setText("X = "+ e.getX()+" ; Y = "+ e.getY());
            }
        });

        this.add(label2);
        this.add(boton);
        this.setVisible(true); //Mandatory to show the window
    }

    public static void main(String[] args) {
        new VentanaConBoton();
    }

}

