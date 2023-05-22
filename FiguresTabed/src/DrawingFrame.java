import javax.swing.*;

public class DrawingFrame extends JFrame
{
    public DrawingFrame(DrawingPanel drawingPanel)
    {
        super(drawingPanel.title);
        setContentPane(drawingPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
