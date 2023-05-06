import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BackgroundPanel extends JPanel {

    private Image backgroundImage;
    private JButton button;
    private JLabel label;
    private JTextField textField;

    public BackgroundPanel(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();

        setLayout(null);

        // Agregar los componentes que deseas a este panel personalizado
        label = new JLabel("Este es un texto de prueba");
        label.setBounds(20, 20, 200, 30);
        add(label);

        textField = new JTextField();
        textField.setBounds(20, 60, 200, 30);
        add(textField);

        button = new JButton("Haz clic aquí");
        button.setBounds(20, 100, 200, 30);
        add(button);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana con fondo de pantalla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundPanel panel = new BackgroundPanel("./img/arch.jpg");
        panel.setLayout(null);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
