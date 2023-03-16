import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Wallpaper {
    final int width = 1000;
    final int height = width;
    String nomImg = "Wallpaper";

    Wallpaper() {
        paint();
    }

    // array per les cordenades
    int[] topLeft = new int[]{0, 0};
    int[] topRight = new int[]{width, 0};
    int[] bottomLeft = new int[]{0, height};
    int[] bbottomRight = new int[]{width, height};

    // array pels colors
    int[] topLeftColor = new int[]{255, 0, 0};
    int[] topRightColor = new int[]{0, 0, 255};
    int[] bottomLeftColor = new int[]{220, 85, 200};
    int[] bottomRightColor = new int[]{0, 220, 75};
    
    void paint() {
        try(PrintWriter pw = new PrintWriter(nomImg + ".ppm")) {
            pw.println("P3");
            pw.format("%d %d\n", width, height);
            pw.println("255");

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int[] point = new int[]{x, y};
    
                    double topLeftDistance = distancie(topLeft, point);
                    double topRightDistance = distancie(topRight, point);
                    double bottomLeftDistance = distancie(bottomLeft, point);
                    double bottomRightDistance = distancie(bbottomRight, point);
    
                    double totalDistance = topLeftDistance + topRightDistance + bottomLeftDistance + bottomRightDistance;
    
                    topLeftDistance /= totalDistance;
                    topRightDistance /= totalDistance;
                    bottomLeftDistance /= totalDistance;
                    bottomRightDistance /= totalDistance;
    
                    double r = topLeftColor[0] * topLeftDistance + topRightColor[0] * topRightDistance + bottomLeftColor[0] * bottomLeftDistance + bottomRightColor[0] * bottomRightDistance;
                    double g = topLeftColor[1] * topLeftDistance + topRightColor[1] * topRightDistance + bottomLeftColor[1] * bottomLeftDistance + bottomRightColor[1] * bottomRightDistance;
                    double b = topLeftColor[2] * topLeftDistance + topRightColor[2] * topRightDistance + bottomLeftColor[2] * bottomLeftDistance + bottomRightColor[2] * bottomRightDistance;
                
                    pw.format("%4d", (int) (Math.floor(r + 0.5)));
                    pw.format("%4d", (int) (Math.floor(g + 0.5)));
                    pw.format("%4d", (int) (Math.floor(b + 0.5)));
                }
                pw.println();
            }
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());;
        }
    }

    double distancie(int[] pointOne, int[] pointTwo) {
        double result = 0.0;

        for (int i = 0; i < 2; i++)
            result += (pointOne[i] - pointTwo[i]) * (pointOne[i] - pointTwo[i]);

        return Math.sqrt(result);
    }
}
