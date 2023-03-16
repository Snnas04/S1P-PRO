public class Square implements Figura {
    double cx, cy, ejeX, ejeY;

    public Square(double cx, double cy, double ejeX, double ejeY) {
        this.cx = cx;
        this.cy = cy;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    }

    public int[] patternAndColor(double x, double y) {
        if ((Math.abs(x - cx) < ejeX) && (Math.abs(y - cy) < ejeY))
            return new int[]{255, 0, 150}; // color de la figura
        else
            return new int[]{255, 235, 0}; // color de fondo
    }
}
