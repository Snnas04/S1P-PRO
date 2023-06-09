import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class Sierpinski extends Drawing {
    public Sierpinski() {
        super();
    }

    @Override
    public void drawShape(Graphics2D graphics2D) {
        int width = getWidth();
        int height = getHeight();
        int level = getLevel();

        Point2D.Double top = new Point2D.Double(width >> 1, 10);
        Point2D.Double bottomRight = new Point2D.Double(width - 10, height - 10);
        Point2D.Double bottomLeft = new Point2D.Double(10, height - 10);

        drawSierpinski(top, bottomRight, bottomLeft, level, graphics2D);
    }

    private void drawSierpinski(Point2D.Double top, Point2D.Double bottomRight, Point2D.Double bottomLeft, int level, Graphics2D graphics2D) {
        if (level == 0) {
            Shape shape = createTriangle(top, bottomRight, bottomLeft);
            graphics2D.fill(shape);
            return;
        }

        Point2D.Double leftThird = new Point2D.Double((top.x + bottomLeft.x) / 2, (top.y + bottomLeft.y) / 2);
        Point2D.Double rightThird = new Point2D.Double((top.x + bottomRight.x) / 2, (top.y + bottomRight.y) / 2);
        Point2D.Double bottomThird = new Point2D.Double((bottomLeft.x + bottomRight.x) / 2, (bottomLeft.y + bottomRight.y) / 2);

        drawSierpinski(top, rightThird, leftThird, level - 1, graphics2D);
        drawSierpinski(leftThird, bottomThird, bottomLeft, level - 1, graphics2D);
        drawSierpinski(rightThird, bottomRight, bottomThird, level - 1, graphics2D);
    }

    private Shape createTriangle(Point2D.Double top, Point2D.Double bottomRight, Point2D.Double bottomLeft) {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(top.x, top.y);
        path.lineTo(bottomRight.x, bottomRight.y);
        path.lineTo(bottomLeft.x, bottomLeft.y);
        path.closePath();
        return path;
    }
}
