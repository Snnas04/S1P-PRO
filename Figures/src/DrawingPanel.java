import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DrawingPanel extends JPanel {
    int width, height;
    Graphics2D graphics2D;

    public DrawingPanel(int width, int height) {
        this.width = width;
        this.height = height;

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
        sierpinski(top, bottomRight, bottomLeft, 7);
    }

    private void sierpinski(Point2D.Double topSierpinski, Point2D.Double bottomRightSierpinski, Point2D.Double bottomLeftSierpinski, int level) {
        if (level == 0) {
            Path2D.Double path = new Path2D.Double();
            path.moveTo(topSierpinski.x, topSierpinski.y);
            path.lineTo(bottomRightSierpinski.x, bottomRightSierpinski.y);
            path.lineTo(bottomLeftSierpinski.x, bottomLeftSierpinski.y);
            path.closePath();
            graphics2D.fill(path);
            return;
        }

        Point2D.Double top = midPoint(topSierpinski, bottomRightSierpinski);
        Point2D.Double bottomRight = midPoint(bottomRightSierpinski, bottomLeftSierpinski);
        Point2D.Double bottomLeft = midPoint(bottomLeftSierpinski, topSierpinski);

        sierpinski(topSierpinski, top, bottomLeft, level - 1);
        sierpinski(top, bottomRightSierpinski, bottomRight, level - 1);
        sierpinski(bottomLeft, bottomRight, bottomLeftSierpinski, level - 1);
    }

    public Point2D.Double midPoint(Point2D.Double a, Point2D.Double b) {
        return new Point2D.Double((a.x + b.x) / 2.0, (a.y + b.y) / 2.0);
    }
}
