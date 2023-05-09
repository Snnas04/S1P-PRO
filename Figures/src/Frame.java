import javax.swing.*;

public class Frame extends JFrame {
    SierpinskiPanel dp = new SierpinskiPanel(1000, 950);

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
