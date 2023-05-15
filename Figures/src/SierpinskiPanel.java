import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class SierpinskiPanel extends JPanel implements Drawing {
    Graphics2D graphics2D;

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
    }

    @Override
    public void draw(int width, int height, int level, Graphics2D graphics2D) {
        Point2D.Double top = new Point2D.Double(width >> 1, 10);
        Point2D.Double bottomRight = new Point2D.Double(width - 10, height - 10);
        Point2D.Double bottomLeft = new Point2D.Double(10, height - 10);
    }
}
