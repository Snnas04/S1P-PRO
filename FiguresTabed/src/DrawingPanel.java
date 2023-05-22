import javax.swing.*;
import java.awt.*;

public abstract class DrawingPanel extends JPanel
{
    final double padding = 10.0;
    final int width = 1200;
    final int height = 900;

    String title;
    Graphics2D gfx;

    public DrawingPanel(String title)
    {
        this.title = title;

        setPreferredSize(new Dimension(width, height));
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        gfx = (Graphics2D) g;

        gfx.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gfx.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        gfx.setStroke(new BasicStroke(3.0f));

        setBackground(new Color(0x161B27));
        setForeground(new Color(0xFFB700));
        draw();
    }

    public abstract void draw();

    public Color coloring(double from, double to, double intermediate)
    {
        Color origin = Color.red;
        Color destiny = Color.yellow;

        float t = (float) ((intermediate - from) / (to - from));

        float r = t * origin.getRed() + (1.0f - t) * destiny.getRed();
        float g = t * origin.getGreen() + (1.0f - t) * destiny.getGreen();
        float b = t * origin.getBlue() + (1.0f - t) * destiny.getBlue();

        r /= 256f;
        g /= 256f;
        b /= 256f;

        return new Color(r, g, b);
    }
}
