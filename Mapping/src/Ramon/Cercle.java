package Ramon;

public class Cercle implements Figure
{
    double cx, cy, radius;

    public Cercle(double cx, double cy, double radius)
    {
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
    }

    public int[] function(double x, double y)
    {
        if (inside(x, y))
            return new int[]{200, 200, 200};
        else
            return new int[]{0, 0, 200};
    }

    public boolean inside(double x, double y)
    {
        double dx = cx - x;
        double dy = cy - y;

        return Math.sqrt(dx * dx + dy * dy) < radius;
    }
}

