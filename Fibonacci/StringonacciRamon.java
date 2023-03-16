package Fibonacci;

public class StringonacciRamon {
    static String x = "0";
    static String y = "1";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Què no m'has de donar un numero, eh?");
            System.exit(-1);
        }

        int termes = Integer.parseInt(args[0]);

        if (termes < 2) {
            System.out.println(termes);
            return;
        }

        long start = System.nanoTime();

        for (int t = 0; t < termes - 1; t++) {
            String z = "";
            int carry = 0;
            for (int i = 0; i < y.length(); i++) {
                int p = x.charAt(i) - '0';
                int q = y.charAt(i) - '0';

                int r = p + q + carry;

                if (r >= 10) {
                    r -= 10;
                    carry = 1;
                }
                else {
                    carry = 0;
                }
                z += r;
            }
            x = y;
            y = z;
            if (carry != 0) {
                x += "0";
                y += "1";
            }
        }
        reverso(y);

        System.out.println((System.nanoTime() - start) / 1000000000.0);
    }

    private static void reverso(String cadena) {
        for (int i = cadena.length() - 1; i >= 0; i--) {
            System.out.print(cadena.charAt(i));
        }
        System.out.println("");
    }
}
