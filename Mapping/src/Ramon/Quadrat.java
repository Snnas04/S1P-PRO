package Ramon;

public class Quadrat implements Figure
{
    double cx, cy, ejex, ejey;

    public Quadrat(double cx, double cy, double ejex, double ejey)
    {
        this.cx = cx;
        this.cy = cy;
        this.ejex = ejex;
        this.ejey = ejey;
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
        return (Math.abs(x - cx) < ejex) && (Math.abs(y - cy) < ejey);
    }
}

