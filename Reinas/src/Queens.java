import java.io.PrintWriter;

public class Queens {
    private int[] q;
    int contador = 0;

    PrintWriter pw;

    public Queens() {
        new Queens(8);
    }

    public Queens(int n) {
        q = new int[n];

        try {
            pw = new PrintWriter("Queens_" + n + ".html");
            enumerate(0);
            pw.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }

    private boolean isConsistent(int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) return false;
            if ((q[i] - q[n]) == (n - i)) return false;
            if ((q[n] - q[i]) == (n - i)) return false;
        }
        return true;
    }

    public void printQueens(int[] q) {
        int n = q.length;
        System.out.println(++contador);
        pw.println("Sulució: " + contador);
        pw.println("<p>");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j)
                    pw.print("♛ ");
                else
                    pw.print("· ");
            }
            pw.println("<br>");
        }
        pw.println("</p>");
        pw.println();
    }

    public void enumerate(int k) {
        int n = q.length;
        if (k == n)
            printQueens(q);
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(k)) enumerate( k + 1);
            }
        }
    }

    public static void main(String[] args) {
        new Queens(11);
    }
}
