import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class Mapping {
    final int width = 1600;
    final int height = 800;

    final double[] x;
    final double[] y;

    public Mapping(double xCenter, double yCenter, double radius) {
        double xRatio = width / radius;
        double yRatio = height / radius;

        double screenRatio = (double) width / height;

        double gap;

        if (xRatio < yRatio) {
            gap = 2.0 * radius / (width - 1);
            x = mapCoordinates(xCenter - radius, gap, width);
            y = mapCoordinates(yCenter + radius / screenRatio, -gap, height);
        }
        else {
            gap = 2.0 * radius / (height - 1);
            x = mapCoordinates(xCenter - radius * screenRatio, gap, width);
            y = mapCoordinates(yCenter + radius, -gap, height);
        }
    }

    public Mapping(double top, double left, double bottom, double right) {
        double xCenter = (left + right) / 2.0;
        double yCenter = (top + bottom) / 2.0;

        double realW = right - left;
        double realH = top - bottom;

        double xRatio = width / realW;
        double yRatio = height / realH;

        double gap = (xRatio < yRatio) ? realW / (width - 1) : realH / (height - 1);

        x = mapCoordinates(xCenter - gap * (width - 1) / 2.0, gap, width);
        y = mapCoordinates(yCenter + gap * (height - 1) / 2.0, -gap, height);
    }

    private double[] mapCoordinates(double start, double gap, int steps) {
        // intStream es parescut a fer un for
        return IntStream.range(0, steps).mapToDouble(i -> start + i * gap).toArray();
    }

    private void genImage(String nomImg) {

        try (PrintWriter pw = new PrintWriter("./img/" + nomImg + ".ppm")) {
            pw.println("P3");
            pw.format("%d %d\n", width, height);
            pw.println("255");

            Figura c = new Circle(-0.5, 0.5, 0.25);

            for (int yImg = 0; yImg < height; yImg++) {
                for (int xImg = 0; xImg < width; xImg++) {
                    int[] color = c.patternAndColor(x[xImg], y[yImg]);

                    for (int k : color) {
                        pw.format("%4d", k);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Cause\n");
            System.out.println(e.getCause());
            System.out.println("\nMessage\n");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Mapping m = new Mapping(0.0, 0.0, 1.5);
        m.genImage("cercleMogut");
    }
}
