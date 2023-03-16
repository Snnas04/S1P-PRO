package Fibonacci;

public class Arrayonacci {
    static byte[] a = new byte[100];
    static byte[] b = new byte[100];
    static byte[] t = new byte[100];

    public static void main(String[] args) {
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i] = 0;
        }
        
        // a[0] = 1;
        b[0] = 1;

        for (int i = 0; i < 200; i++) {
            // mostrarA();

            byte carry = 0;

            for (int j = 0; j < t.length; j++) {
                t[j] = a[j];
                a[j] = b[j];
                b[j] += t[j] + carry;

                if (b[j] >= 10) {
                    b[j] -= 10;
                    carry = 1;
                }
                else {
                    carry = 0;
                }
            }
        }
        mostrarA();
    }

    private static void mostrarA() {
        int j = a.length - 1;

        while ((j != 0) && (a[j] == 0)) {
            j -= 1;
        }

        for (int i = j; i >= 0; i--) {
            System.out.print(a[i]);
        }
        System.out.println("");
    }
}
