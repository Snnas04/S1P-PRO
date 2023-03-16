package Operadors;

public class Operadors {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("necessit 2 valors");
            System.exit(-1);
        }

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        System.out.println("suma ->" + suma(x, y));
        System.out.println("resta ->" + resta(x, y));
        System.out.println("mutiplicacio ->" + mutiplicacio(x,y));
        System.out.println("divisio ->" + divisio(x, y));
    }

    private static int suma(int a, int b) {
        return a + b;
    }

    private static int resta(int a, int b) {
        return a - b;
    }

    private static int mutiplicacio(int a, int b) {
        return a * b;
    }

    private static int divisio(int a, int b) {
        return a / b;
    }
}
