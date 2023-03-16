package Fibonacci;

public class Arrayonacci2 {
    final static int base = 1_000_000_000;

    static int[] a = new int[12];
    static int[] b = new int[12];
    static int[] t = new int[12];

    public static void main(String[] args) {
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i] = 0;
        }

        // a[0] = 1;
        b[0] = 1;

        for (int i = 0; i < 500; i++) {
            mostrarA();

            int dur1 = 0;

            for (int j = 0; j < t.length; j++) {
                t[j] = a[j];
                a[j] = b[j];
                b[j] += t[j] + dur1;

                if (b[j] >= base) {
                    b[j] -= base;
                    dur1 = 1;
                }
                else {
                    dur1 = 0;
                }
            }
        }
        // mostrarA();
    }

    private static void mostrarA() {
        int j = a.length - 1;

        // while ((j != 0) && (a[j] == 0)) {
        //     j -= 1;
        // }

        for (int i = j; i >= 0; i--) {
            // amb aixo obliga a que la suma tengui dues xifres, per si el rsultat de la suma en donas un n'afageix un a l'esquerra
            // augmentam el numero per la cantitat de 0 que tengui la base, 
            // si la base es 1000 posam un 3, si es 10 posam un 1, si es 100000 posam un 5
            
            // si posasim %2d faria espas de 2
            System.out.format("%09d", a[i]);
        }
        System.out.println("");
    }
}
