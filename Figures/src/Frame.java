import javax.swing.*;

public class Frame extends JFrame {
    DrawingPanel dp = new DrawingPanel(1000, 950);

    public Frame(String title) {
        super(title);
        setContentPane(dp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
