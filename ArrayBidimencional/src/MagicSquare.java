import java.io.PrintWriter;

public class MagicSquare {
    int[][] quadrat;

    public MagicSquare(int quantitat) {
        if (quantitat % 2 == 1) {
            quadrat = new int[quantitat][quantitat];
            omplir(quantitat);
            html();
        }
    }

    private void omplir(int quantitat) {
        // int fila = 0;
        // int columna = (quantitat - 1) / 2;

        // for (int k = 1; k <= quantitat * quantitat; k++) {
        //     quadrat[fila][columna] = k;

        //     if (k % quantitat == 0) {
        //         fila = (fila + 1) % quantitat;
        //     }            
        //     else {
        //         fila = (fila - 1 + quantitat) % quantitat;
        //         columna = (columna - 1 + quantitat) % quantitat;
        //     }
        // }

        int fila = (quantitat - 1) / 2;
        int columna = 0;

        for (int k = 1; k <= quantitat * quantitat; k++) {
            quadrat[fila][columna] = k;

            if (k % quantitat == 0) {
                columna = (columna + 1) % quantitat;
            }            
            else {
                fila = (fila - 1 + quantitat) % quantitat;
                columna = (columna - 1 + quantitat) % quantitat;
            }
        }
    }

    // private void mostrar() {
    //     for (int fila = 0; fila < quadrat.length; fila++) {
    //         for  (int columna = 0; columna < quadrat[fila].length; columna++)
    //             System.out.format("%4d", quadrat[fila][columna]);
            
    //         System.out.println();
    //     }
    // }

    private void html() {
        try (PrintWriter pw = new PrintWriter("MagicSquare_"+ quadrat.length + ".html")) {
            pw.println("<html>");
            pw.println("<style>");
            pw.println("body { background-color: #141229;}");
            pw.println("td { background-color: #eeff07; text-align: center;}");
            pw.println("</style>");
            pw.println("<body>");
            pw.println("<table>");
            for (int fila = 0; fila < quadrat.length; fila++) {
                pw.println("<tr>");
                for (int columna = 0; columna < quadrat[fila].length; columna++) {
                    pw.println("<td>" + quadrat[fila][columna] + "</td>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</body>");
            pw.println("</body>");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
