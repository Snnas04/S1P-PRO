import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(String title, int width, int height, int level, Drawing drawing) {
        super(title);

        DrawingPanel drawingPanel = new DrawingPanel(width, height, level, drawing);
        setContentPane(drawingPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
