package Primos;

public class Primo4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USO: Primo <numero>");
            System.exit(-1);
        }

        int limit = Integer.parseInt(args[0]);

        for (int j = 2; j <= limit; j++) {
            if (esPrimo(j)) {
                System.out.println(j + " - TRUE");
            }
            else {
                System.out.println(j + " - false");
            }
        }
    }

    private static boolean esPrimo(int numero) {
        int limit = (int) Math.sqrt(numero);

        for (int i = 2; i <= limit; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
