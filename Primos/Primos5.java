package Primos;

public class Primos5 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USO: Primo <numero>");
            System.exit(-1);
        }

        int limit = Integer.parseInt(args[0]);

        System.out.println(2);

        for (int j = 3; j <= limit; j += 2)
            if (esPrimo(j)) 
                System.out.println(j);
    }

    private static boolean esPrimo(int numero) {
        int limit = (int) Math.sqrt(numero);

        if (numero % 2 == 0) 
            return false;

        for (int i = 3; i <= limit; i += 2) 
            if (numero % i == 0)
                return false;
        
        return true;
    }
}
