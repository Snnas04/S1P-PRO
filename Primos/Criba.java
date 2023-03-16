package Primos;

public class Criba {
    private static int[] numeros;
    public static void main(String[] args) {
        if (args.length != 1) {
            // posam err en lloc de out per no mesclar els missatges que han anat be amb els dels errors
            // err nomes surt a la consola d'errors
            System.err.println("Se esperaba un numero");
            System.exit(-1);
        }

        int maximo = Integer.parseInt(args[0]);

        numeros = new int[maximo];
        iniciar();
        cribar();
        mostrar();
    }

    private static void iniciar() {
        for (int i = 0; i < numeros.length; i++)
            numeros[i] = i + 2;
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
