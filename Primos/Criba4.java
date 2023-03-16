package Primos;

// criba + binari

public class Criba4 {
    private static byte[] numeros;
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Se esperaba un numero");
            System.exit(-1);
        }

        int maximo = Integer.parseInt(args[0]);

        numeros = new byte[maximo * 4];
        iniciar();
        System.out.println(2);
        //cribar();
        //mostrar();
        cribarBin();
    }

    private static void iniciar() {
        for (int i = 0; i < numeros.length; i++)
        // FF es tot uns, aixi en lloc de amb un bit emplenar un byte umplim es byte amb 8 bits
        // posam (byte) per fer un type casting
            numeros[i] = (byte) 0xFF;
    }

    private static void cribar() {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] != 0) {
                int k = i + i + 3;
                for (int j = i + k; j < numeros.length; j += k) {
                    numeros[j] = 0;
                }
            }
        }
    }

    private static void cribarBin() {
        // << 3: mou cap a l'esquerra 3 bits, *possicions*, es com si multiplicasim per 8
        for (int i = 0; i < numeros.length << 3; i++) {
            // aixi la *b* indica dins quin byte estam, divideix per 8
            int b = i >> 3;
            int mask = 128 >> (i & 7); // i & 7 == i % 8

            if ((numeros[b] & mask) != 0) {
                int k = i + i + 3;

                System.out.println(k);
                
                for (int j = i + k; j < numeros.length >> 3; j += k) {
                    b = j >> 3;
                    mask = ~(128 >> (j & 7)); // amb la ~ canbiam els 1 per 0 i els 0 per 1
                    numeros[b] &= mask;
                }
            }
        }
    }

    private static void mostrar() {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] != 0) {
                System.out.println(i + i + 3);
            }
        }
    }
}

