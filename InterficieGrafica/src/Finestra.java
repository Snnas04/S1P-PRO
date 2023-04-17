import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Finestra extends JFrame {
    int WIDTH = 200;
    int HEIGHT = 500;

    public Finestra() {
        this.setTitle("Finestra");
        this.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Image imagen = Toolkit.getDefaultToolkit().getImage("./img/Smile-Icon-PNG-Picture.png");
        this.setIconImage(imagen);

        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Finestra();
    }
}
