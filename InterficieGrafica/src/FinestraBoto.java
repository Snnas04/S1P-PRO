import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FinestraBoto extends JFrame {
    int WIDTH = 200;
    int HEIGHT = 500;

    public FinestraBoto() {
        this.setTitle("Finestra amb Botó");
        this.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Image imagen = Toolkit.getDefaultToolkit().getImage("./img/Smile-Icon-PNG-Picture.png");
        this.setIconImage(imagen);
        this.setLayout(null);

        JButton button = new JButton("Button");
        button.setBounds(WIDTH/2-120,HEIGHT/4*3+50,200,25);
        // button.addActionListener();
        
        this.add(button);
        
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Finestra();
    }
}
