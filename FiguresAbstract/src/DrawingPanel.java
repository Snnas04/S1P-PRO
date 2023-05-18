import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DrawingPanel extends JPanel {
    int width, height, level;
    Graphics2D graphics2D;

    public DrawingPanel(int width, int height, int level) {
        this.width = width;
        this.height = height;
        this.level = level;

        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics2D = (Graphics2D) graphics;

        Map<RenderingHints.Key, Object> hints = new HashMap<>();
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        graphics2D.setRenderingHints(hints);

        setBackground(new Color(202, 15, 100, 255));

        setForeground(new Color(255, 196, 0));
    }
}
