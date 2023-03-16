package Primos;

public class Criba3 {
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
        cribar();
        mostrar();
    }

    private static void iniciar() {
        for (int i = 0; i < numeros.length; i++)
            numeros[i] = 1;
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

    private static void mostrar() {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] != 0) {
                System.out.println(i + i + 3);
            }
        }
    }
}

