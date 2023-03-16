package Primos;

public class Criba2 {
    private static int[] numeros;
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Se esperaba un numero");
            System.exit(-1);
        }

        int maximo = Integer.parseInt(args[0]);

        numeros = new int[maximo];
        iniciar();
        System.out.println(2);
        cribar();
        mostrar();
    }

    private static void iniciar() {
        for (int i = 0; i < numeros.length; i++)
        // i + i + 3 es lo mateix que 2 * i + 3
            numeros[i] = i + i + 3;
    }

    private static void cribar() {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] != 0) {
                int k = numeros[i];
                for (int j = i + k; j < numeros.length; j += k) {
                    numeros[j] = 0;
                }
            }
        }
    }

    private static void mostrar() {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] != 0) {
                System.out.println(numeros[i]);
            }
        }
    }
}

