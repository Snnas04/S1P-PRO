import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

public class DrawingPanel extends JPanel {
    private Drawing drawing;
    int width, height, level;
    Graphics2D graphics2D;

    public DrawingPanel(int width, int height, int level, Drawing drawing) {
        this.width = width;
        this.height = height;
        this.level = level;
        this.drawing = drawing;

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

        Point2D.Double top = new Point2D.Double(width >> 1, 10);
        Point2D.Double bottomRight = new Point2D.Double(width - 10, height - 10);
        Point2D.Double bottomLeft = new Point2D.Double(10, height - 10);

        setForeground(new Color(255, 196, 0));
        drawing.draw(width, height, level, graphics2D);
    }
}
