import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class PolynskiDinamic extends DrawingPanel
{
    final int level, sides;

    double xCenter, yCenter, radio;

    public PolynskiDinamic(int level, int sides)
    {
        super("PolynskiDinamic");
        this.level = level;
        this.sides = sides;
    }

    public void draw() {
        double alfa = Math.PI / 2.0;
        double beta = 2.0 * Math.PI / sides;

        xCenter = getWidth() / 2D;
        yCenter = getHeight() / 2D;

        var radioY = yCenter - padding;
        var radioX = xCenter - padding;
        radio = Math.max(radioX, radioY);

        for (int i = 0; i < sides; i++) {
            Point2D.Double x = new Point2D.Double(xCenter, yCenter);

            Point2D.Double y = new Point2D.Double(
                    xCenter + radioX * Math.cos(alfa),
                    yCenter + radioY * Math.sin(alfa));

            Point2D.Double z = new Point2D.Double(
                    xCenter + radioX * Math.cos(alfa + beta),
                    yCenter + radioY * Math.sin(alfa + beta));

            sierpinski(x, y, z, level);

            alfa += beta;
        }
    }

    private void sierpinski(Point2D.Double a, Point2D.Double b, Point2D.Double c, int level)
    {
        if (level == 0)
        {
            gfx.setColor(coloring(0.0, radio + padding, a.distance(xCenter, yCenter)));

            Path2D.Double path = new Path2D.Double();
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

    private Point2D.Double midPoint(Point2D.Double a, Point2D.Double b)
    {
        return new Point2D.Double((a.x + b.x) / 2.0, (a.y + b.y) / 2.0);
    }
}
