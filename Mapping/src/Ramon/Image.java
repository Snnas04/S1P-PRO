package Ramon;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class Image {
    final int width = 1920;
    final int height = 1080;

    final double[] x;
    final double[] y;

    final double[] xMini;
    final double[] yMini;

    final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    final WritableRaster raster = image.getRaster();

    final int[] foregroundColor = new int[]{0xff, 0x8c, 0x00};
    final int[] backgroundColor = new int[]{0x25, 0x00, 0x41};

    double gap, miniGap;

    int aaLevel = 3;

    public Image(double xCenter, double yCenter, double radius) {
        double screenRatio = (double) width / height;

        double startx, starty;

        if (width < height) {
            gap = 2.0 * radius / (width - 1);
            startx = xCenter - radius;
            starty = yCenter + radius / screenRatio;
        }
        else {
            gap = 2.0 * radius / (height - 1);
            startx = xCenter - radius * screenRatio;
            starty = yCenter + radius;
        }
        miniGap = gap / aaLevel;
        x = mapping(startx, gap, width);
        xMini = mapping(startx - aaLevel * miniGap / 2.0, miniGap, width * aaLevel);
        y = mapping(starty, -gap, height);
        yMini = mapping(starty + aaLevel * miniGap / 2.0, miniGap, height * aaLevel);

    }

    private double[] mapping(double start, double gap, int steps) {
        return IntStream.range(0, steps).mapToDouble(i -> start + i * gap).toArray();
    }

    public void background(int[] color) {
        int[] scanLine = new int[3 * width];

        int k = 0;
        for (int w = 0; w < width; w++) {
            scanLine[k++] = color[0];
            scanLine[k++] = color[1];
            scanLine[k++] = color[2];
        }

        IntStream.range(0, height).forEach(h -> raster.setPixels(0, h, width, 1, scanLine));
    }

    public void save() {
        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss_SSS"));

        try {
            ImageIO.write(image, "png", new File(filename + ".png"));
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void shape(Figure figure, int[] color) {
        for (int h = 0; h < height; h++)
            for (int w = 0; w < width; w++)
                if (figure.inside(x[w], y[h]))
                    raster.setPixel(w, h, color);
    }

    public void shapeAA(Figure figure, int[] color) {
        for (int h = 0; h < height; h++) {
            int starth = aaLevel * h;
            for (int w = 0; w < width; w++) {
                int startw = aaLevel * w;

                double r = 0.0;
                double g = 0.0;
                double b = 0.0;

                boolean modify = false;
                int[] result = raster.getPixel(w, h, (int[]) null);

                for (int hh = 0; hh < aaLevel; hh++) {
                    for (int ww = 0; ww < aaLevel; ww++) {
                        if (figure.inside(xMini[startw + ww], yMini[starth + hh])) {
                            r += color[0];
                            g += color[1];
                            b += color[2];
                            modify = true;
                        }
                        else {
                            r += result[0];
                            g += result[1];
                            b += result[2];
                        }
                    }
                }
                if (modify) {
                    r /= (aaLevel * aaLevel);
                    g /= (aaLevel * aaLevel);
                    b /= (aaLevel * aaLevel);

                    raster.setPixel(w, h, new double[]{r, g, b});
                }
            }
        }
    }

    public static void main(String[] args) {
        Image image = new Image(0.0, 0.0, 1.5);
        image.background(image.backgroundColor);
        image.shapeAA(new Quadrat(0.0, 0.0, 1.0, 1.0), image.foregroundColor);
        image.shapeAA(new Cercle(0.0, 0.0, 0.9), image.backgroundColor);
        image.shapeAA(new Poligon(0.0, 0.0, 0.8, 6), image.foregroundColor);
        image.shapeAA(new Poligon(0.0, 0.0, 0.6, 6), image.backgroundColor);
        image.shapeAA(new Poligon(0.0, 0.0, 0.4, 6), image.foregroundColor);
        image.shapeAA(new Poligon(0.0, 0.0, 0.2, 6), image.backgroundColor);
        image.save();
    }
}

