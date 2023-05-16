import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class Sierpinski implements Drawing {
    Graphics2D graphics2D;

    private void sierpinski(Point2D.Double top, Point2D.Double bottomRight, Point2D.Double bottomLeft, int level, Graphics2D graphics2D) {
        if (level == 0) {
            Path2D.Double path = new Path2D.Double();
            path.moveTo(top.x, top.y);
            path.lineTo(bottomRight.x, bottomRight.y);
            path.lineTo(bottomLeft.x, bottomLeft.y);
            path.closePath();
            graphics2D.fill(path);
            return;
        }

        Point2D.Double leftThird = new Point2D.Double((top.x + bottomLeft.x) / 2, (top.y + bottomLeft.y) / 2);
        Point2D.Double rightThird = new Point2D.Double((top.x + bottomRight.x) / 2, (top.y + bottomRight.y) / 2);
        Point2D.Double bottomThird = new Point2D.Double((bottomLeft.x + bottomRight.x) / 2, (bottomLeft.y + bottomRight.y) / 2);

        sierpinski(top, rightThird, leftThird, level - 1, graphics2D);
        sierpinski(leftThird, bottomThird, top, level - 1, graphics2D);
        sierpinski(rightThird, bottomThird, bottomRight, level - 1, graphics2D);
    }

    @Override
    public void draw(int width, int height, int level, Graphics2D graphics2D) {
        Point2D.Double top = new Point2D.Double(width >> 1, 10);
        Point2D.Double bottomRight = new Point2D.Double(width - 10, height - 10);
        Point2D.Double bottomLeft = new Point2D.Double(10, height - 10);

        sierpinski(top, bottomRight, bottomLeft, level, graphics2D);
    }
}
