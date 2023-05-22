import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class HilbertCurve extends DrawingPanel
{
    final int level;
    final double step;

    public HilbertCurve(int level)
    {
        super("Hilbert curve");
        this.level = level;
        this.step = (width - 2.0 * padding) / (Math.pow(2.0, level) - 1.0);
    }

    public void draw()
    {
        MiniTurtle miniTurtle = new MiniTurtle();

        drawHilbert(level, 1, miniTurtle);
    }

    private void drawHilbert(int level, int side, MiniTurtle miniTurtle)
    {
        if (level > 0)
        {
            miniTurtle.turn(side);
            drawHilbert(level - 1, -side, miniTurtle);
            miniTurtle.forward(gfx);
            miniTurtle.turn(-side);
            drawHilbert(level - 1, side, miniTurtle);
            miniTurtle.forward(gfx);
            drawHilbert(level - 1, side, miniTurtle);
            miniTurtle.turn(-side);
            miniTurtle.forward(gfx);
            drawHilbert(level - 1, -side, miniTurtle);
            miniTurtle.turn(side);
        }
    }

    private class MiniTurtle
    {
        private Point2D.Double position;
        private double angle;

        public MiniTurtle()
        {
            this.position = new Point2D.Double(padding, padding);
        }

        public void turn(int side)
        {
            this.angle += side * Math.PI / 2.0;
        }

        public void forward(Graphics2D gfx)
        {
            double x = position.x + step * Math.cos(angle);
            double y = position.y + step * Math.sin(angle);

            gfx.setColor(coloring(padding, width - padding, x));

            Point2D.Double destiny = new Point2D.Double(x, y);

            gfx.draw(new Line2D.Double(position, destiny));
            position = destiny;
        }
    }
}
