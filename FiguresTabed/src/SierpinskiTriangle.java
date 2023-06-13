import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class SierpinskiTriangle extends DrawingPanel {
//    final int level;

    public SierpinskiTriangle(int level) {
        super("Sierpinski triangle");
        this.level = level;
    }

    public void draw() {
        double minim = Math.min(width, height);

        double sideLength = minim * 0.866;

        double offsetX = (width - sideLength) / 2.0;
        double offsetY = (height - sideLength) / 2.0;

        Point2D.Double x = new Point2D.Double(offsetX + sideLength / 2, offsetY);
        Point2D.Double y = new Point2D.Double(offsetX + sideLength, offsetY + sideLength);
        Point2D.Double z = new Point2D.Double(offsetX, offsetY + sideLength);

        sierpinski(x, y, z, level);
    }

    private void sierpinski(Point2D.Double a, Point2D.Double b, Point2D.Double c, int level) {
        if (level == 0) {
            Path2D.Double path = new Path2D.Double();

            gfx.setColor(coloring(padding, width - padding, a.x));
            gfx.setColor(coloring(padding, width - padding, b.x));
            gfx.setColor(coloring(padding, width - padding, c.x));

            path.moveTo(a.x, a.y);
            path.lineTo(b.x, b.y);
            path.lineTo(c.x, c.y);

            path.closePath();
            gfx.fill(path);
            return;
        }

        Point2D.Double x = midPoint(a, b);
        Point2D.Double y = midPoint(b, c);
        Point2D.Double z = midPoint(c, a);

        sierpinski(a, x, z, level - 1);
        sierpinski(x, b, y, level - 1);
        sierpinski(z, y, c, level - 1);
    }

    private Point2D.Double midPoint(Point2D.Double a, Point2D.Double b) {
        return new Point2D.Double((a.x + b.x) / 2.0, (a.y + b.y) / 2.0);
    }
}
