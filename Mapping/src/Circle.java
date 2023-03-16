public class Circle implements Figura {
    double cx, cy, radius;

    public Circle(double cx, double cy, double radius) {
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
    }

    public int[] patternAndColor(double x, double y) {
        double distance = Math.sqrt((x - cx) * (x - cx) + (y - cy) * (y - cy));

        if (distance < radius)
            return new int[]{200, 200, 200}; // color de la figura
        else
            return new int[]{0, 0, 200}; // color de fondo
    }
}
