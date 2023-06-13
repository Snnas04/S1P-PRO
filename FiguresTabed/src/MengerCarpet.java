import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class MengerCarpet extends DrawingPanel
{
    public MengerCarpet(int level)
    {
        super("Menger carpet");
        this.level = level;
    }

    public void draw() {
        if (level == 4) {
            level = 4;
        }

        double minim = Math.min(width, height);

        double offsetX = (width - minim) / 2.0;
        double offsetY = (height - minim) / 2.0;

        Point2D.Double x = new Point2D.Double(padding + offsetX, padding + offsetY);
        Point2D.Double y = new Point2D.Double(minim - padding + offsetX, minim - padding + offsetY);

        menger(x, y, level);
    }

    public void menger(Point2D.Double a, Point2D.Double b, int level)
    {
        double x = b.x - a.x;
        double y = b.y - a.y;

        if (level == 0)
        {
            Rectangle2D.Double shape = new Rectangle2D.Double(a.x, a.y, x, y);

            gfx.setColor(coloring(padding, width - padding, a.x));

            gfx.fill(shape);
            return;
        }

        x /= 3.0;
        y /= 3.0;

        for (int yy = 0; yy < 3; yy++)
            for (int xx = 0; xx < 3; xx++)
                if (xx != 1 || yy != 1)
                {
                    Point2D.Double p = new Point2D.Double(a.x + xx * x, a.y + yy * y);
                    Point2D.Double q = new Point2D.Double(p.x + x, p.y + y);

                    menger(p, q, level - 1);
                }
    }
}
