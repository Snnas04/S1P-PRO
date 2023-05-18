import javax.swing.*;

public class Frame extends JFrame {
    public Frame(String title, int level, DrawingPanel drawingPanel) {
        super(title);

        setContentPane(drawingPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
