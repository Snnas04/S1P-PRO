import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

public class Spiro {
    final int midaImatge = 1080;
    final int mostres = 720;
    int factor;
    boolean color;

    final double radi = 8.0;

    PrintWriter pw;

    public Spiro(int factor, boolean color) {
        this.factor = factor;
        this.color = color;

        try {
            pw = new PrintWriter(String.format("spiro%03d.svg", factor));
            svg();
            pw.close();
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private void svg() {
        pw.print("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
        pw.print("xmlns:xlink=\"http://www.w3.org/1999/xlink\" ");
        pw.format("viewBox=\"%f %f %f %f\" ", -1.1 * radi, -1.1 * radi, 2.2 * radi, 2.2 * radi);
        pw.format("width=\"%d\" height=\"%d\">\n", midaImatge, midaImatge);
        geometria();
        pw.print("</svg>");
    }

    private void geometria() {
        double delta = 2.0 * Math.PI / mostres;

        pw.println("<rect x=\"-50%\" y=\"-50%\" width=\"100%\" height=\"100%\" fill=\"black\"/>");
        pw.println("<g fill=\"none\" stroke-width=\"0.02\" transform=\"rotate(-90)\">");

        for (int p = 0; p < mostres; p++) {
            double alfa = p * delta;
            double x1 = radi * Math.cos(alfa);
            double y1 = radi * Math.sin(alfa);
            double beta = ((p * factor) % mostres) * delta;
            double x2 = radi * Math.cos(beta);
            double y2 = radi * Math.sin(beta);

            if (color)
                pw.format("<path d=\"M %f %f L %f %f\" stroke=\"hsl(%g, 100%%, 50%%)\"/>\n", x1, y1, x2, y2, Math.toDegrees(alfa));
            else
                pw.format("<path d=\"M %f %f L %f %f\" stroke=\"white\"/>\n", x1, y1, x2, y2);
        }

        pw.format("<circle r=\"%f\" stroke=\"#666\"/>\n", radi);
        pw.println("</g>");
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        for (int factor = 2; factor <= 100; factor++)
            new Spiro(factor, true);
    }
}
