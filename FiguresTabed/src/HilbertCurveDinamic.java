import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class HilbertCurveDinamic extends DrawingPanel
{
    final int level;
    double stepW;
    double stepH;

    public HilbertCurveDinamic(int level)
    {
        super("Hilbert curve");
        this.level = level;
//        this.stepW = (width - 2.0 * padding) / (Math.pow(2.0, level) - 1.0);
//        this.stepH = (height - 2.0 * padding) / (Math.pow(2.0, level) - 1.0);
    }

    public void draw()
    {
        stepW = (getWidth() - 2.0 * padding) / (Math.pow(2.0, level) - 1.0);
        stepH = (getHeight() - 2.0 * padding) / (Math.pow(2.0, level) - 1.0);

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
            double x = position.x + stepW * Math.cos(angle);
            double y = position.y + stepH * Math.sin(angle);

            gfx.setColor(coloring(padding, width - padding, x));

            Point2D.Double destiny = new Point2D.Double(x, y);

            gfx.draw(new Line2D.Double(position, destiny));
            position = destiny;
        }
    }
}
