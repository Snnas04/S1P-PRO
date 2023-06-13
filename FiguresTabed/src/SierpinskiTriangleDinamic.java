import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class SierpinskiTriangleDinamic extends DrawingPanel {
//    final int level;

    public SierpinskiTriangleDinamic(int level) {
        super("Sierpinski triangle");
        this.level = level;
    }

    public void draw() {
        Point2D.Double x = new Point2D.Double(width >> 1, padding);
        Point2D.Double y = new Point2D.Double(width - padding, height - padding);
        Point2D.Double z = new Point2D.Double(padding, height - padding);

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
