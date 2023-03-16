package Ramon;

public class Poligon implements Figure
{
    int sides;
    double cx, cy, radius;

    public Poligon(double cx, double cy, double radius, int sides)
    {
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
        this.sides = sides;
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
        int pos = 0;
        int neg = 0;

        double alfa = Math.PI / 2.0;
        double beta = 2.0 * Math.PI / sides;

        for (int i = 0; i < sides; i++)
        {
            double x1 = cx + radius * Math.cos(alfa);
            double y1 = cy + radius * Math.sin(alfa);

            alfa += beta;

            double x2 = cx + radius * Math.cos(alfa);
            double y2 = cy + radius * Math.sin(alfa);

            double d = (x - x1) * (y2 - y1) - (y - y1) * (x2 - x1);

            if (d > 0) pos++;
            if (d < 0) neg++;

            if (pos > 0 && neg > 0)
                return false;
        }
        return true;
    }
}


