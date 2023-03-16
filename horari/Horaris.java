package horari;

import java.io.PrintWriter;

public class Horaris {
    static String[] moduls = {
        "Database<br>Management",
        "Entorns de<br>Desenvolupament",
        "Formació i<br>Orientació<br>Laboral",
        "Llenguatges<br>de Marques",
        "Programació",
        "Sistemes<br>Informàtics"
    };

    static String[][] colors = {
        {"#ffc72ccc", "#13111b"},
        {"#d83ef3cc", "#13111b"},
        {"#48f556cc", "#13111b"},
        {"#2bb7fdcc", "#13111b"},
        {"#ff50b6cc", "#13111b"},
        {"#ee4f43cc", "#13111b"}
    };

    static String[] dies = {
        "Dilluns",
        "Dimarts",
        "Dimecres",
        "Dijous",
        "Divendres"
    };

    static String[] hores = {
        "15:10<br>16:05",
        "16:05<br>17:00",
        "17:15<br>18:10",
        "18:10<br>19:05",
        "19:20<br>20:15",
        "20:15<br>21:10"
    };

    static String[] estructura = {
        "GGD1D2D3D4D5",
        "H15232214302",
        "H2    02    ",
        "H34242    22",
        "H4    1353  ",
        "H50202    32",
        "H6          ",
    };

    static PrintWriter pw;
    
    public static void main(String[] args) throws Exception {
        pw = new PrintWriter("horaris.html");
        html();
        pw.close();
    }

    static void html() {
        pw.println("<!DOCTIPE html>");
        pw.println("<html>");
        head();
        body();
        pw.println("</html>");
    }

    static void head() {
        pw.println("<head>");
        pw.println("<meta charset=\"utf-8\">");
        pw.println("<title>Horari S1P</title>");
        pw.println("<link rel=\"stylesheet\"herf=\"horari.css\">");
        pw.println("</head>");
    }

    static void body() {
        pw.println("<body>");
        horariTable();
        pw.println("</body>");
    }

    static void horariTable() {
        pw.println("<table border=\"1\">");

        for (int i = 0; i < estructura.length; i++) {
            pw.println("<tr align =\"center\">");

            for (int j = 0; j < estructura[i].length(); j += 2) {
                switch (estructura[i].charAt(j)) {
                    case 'G' -> 
                        pw.println("<td width=\"100\">S1P</td>");

                    case 'D' -> {
                        char c = estructura[i].charAt(j + 1);
                        pw.println("<td width=\"180\">" + dies[c - '0' - 1] + "</td>");
                    }

                    case 'H' -> {
                        char c = estructura[i].charAt(j + 1);
                        pw.println("<td height=\"100\">" + hores[c - '0' - 1] + "</td>");
                    }

                    case '0', '1', '2', '3', '4', '5' -> {
                        char c = estructura[i].charAt(j);
                        char d = estructura[i].charAt(j + 1);
                        pw.println("<td rowspan=\"" + d + "\">" + moduls[c - '0'] + "</td>");
                    }
                }
            }
            pw.println("</tr>");
        }
        pw.println("</table>");
    }
}
