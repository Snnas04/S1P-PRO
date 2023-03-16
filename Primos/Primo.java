package Primos;

public class Primo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USO: Primo <numero>");
            System.exit(-1);
        }

        int numero = Integer.parseInt(args[0]);

        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                System.out.println(numero + " NO es primo");
                System.exit(1);
            }
        }
        System.out.println(numero + " SI es primo");
    }
}
