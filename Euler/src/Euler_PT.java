import java.io.PrintWriter;
import java.util.Arrays;

public class Euler_PT {
    final int BASE = 10000;
    final int LOGBASE = 4;
    final int DIGITS = 1000;
    final int MIDA = 1 + DIGITS / LOGBASE;
    int[] euler = new int[MIDA];
    int[] terme = new int[MIDA];

    PrintWriter pw;

    private void initializeArray() {
        Arrays.fill(euler, 0);
        euler[0] = 1;
        Arrays.fill(terme, 0);
        terme[0] = 1;
    }

    public Euler_PT() {
        initializeArray();
        calculateEuler();
        printEuler();
    }

    private void calculateEuler() {
        int divisor = 1;
        int indexNotZero = 0;

        while (indexNotZero < MIDA) {
            dividir(divisor, indexNotZero);
            sumaArrays(indexNotZero);
            indexNotZero = skipZeros(indexNotZero);
            divisor++;
        }
    }

    private void dividir(int divisor, int indexNotZero) {
        int resto = 0;
        int coefficient;

        for (int i = indexNotZero; i < MIDA; i++) {
            coefficient = terme[i] + resto * BASE;
            terme[i] = coefficient / divisor;
            resto = coefficient % divisor;
        }
    }

    private void sumaArrays(int indexNotZero) {
        int excedent = 0;

        for (int i = MIDA - 1; (i >= indexNotZero) || (excedent != 0); i--) {
            euler[i] += terme[i] + excedent;
            if (euler[i] >= BASE) {
                euler[i] -= BASE;
                excedent = 1;
            }
            else {
                excedent = 0;
            }
        }
    }

    private int skipZeros(int indexNotZero) {
        while ((indexNotZero < MIDA) && (terme[indexNotZero] == 0))
            indexNotZero++;
        return indexNotZero;
    }

    private void printEuler() {
        int count = 0;

        try {
            pw = new PrintWriter("Euler.txt");
        }
        catch(Exception e) {
            e.getStackTrace();
        }

        pw.print("00002 ");

        for (int i = 1; i < MIDA; i++) {
            if (i % 20 == 0) {
                count += 100;
                pw.println(" - " + count);
            }
            pw.printf("%0" + LOGBASE + "d", euler[i]);
        }
        pw.close();
        System.out.println(count);
    }

    public static void main(String[] args) {
        new Euler_PT();
    }
}
