import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PPM {
    int width, height, r, g, b, r2, g2, b2;
    String nomImatge = "degradat2";

    public PPM(){
        this.width = 4096;
        this.height = 4096;
        image(1);
    }

    public PPM(int width, int height, int r, int g, int b) {
        this.width = width;
        this.height = height;
        this.r = r;
        this.g = g;
        this.b = b;
        image(2);
    }

    public PPM(int width, int height, int r, int g, int b, int r2, int g2, int b2) {
        this.width = width;
        this.height = height;
        this.r = r;
        this.g = g;
        this.b = b;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
        image(3);
    }


    private void image(int mode) {
        int r3 = r;
        int g3 = g;
        int b3 = b;

        try(PrintWriter pw = new PrintWriter(nomImatge + ".ppm")) {
            pw.println("P3");
            pw.format("%d %d\n", width, height);
            pw.println("255");

            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    switch (mode) {
                        case 1 -> {
                            r = w % 256;
                            g = h % 256;
                            b = (h / 256) * 16 + (w / 256);
                        }
                        case 3 -> {
                            double aprox = (double) w / width;

                            double rr = r2 + aprox * (r3 - r2);
                            double gg = g2 + aprox * (g3 - g2);
                            double bb = b2 + aprox * (b3 - b2);

                            r = (int) Math.floor(rr + 0.5);
                            g = (int) Math.floor(gg + 0.5);
                            b = (int) Math.floor(bb + 0.5);
                        }
                    }
                    pw.format("%4d%4d%4d", r, g, b);
                }
                pw.println();
            }
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());;
        }
    }
}
