import javax.swing.*;

public class Frame extends JFrame {
    public Frame(String title, int level, Drawing drawing) {
        super(title);
        DrawingPanel dp = new DrawingPanel(900, 750, level, drawing);

        setContentPane(dp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
