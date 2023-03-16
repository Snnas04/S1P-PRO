package Ordenar;

// ordena 3 numeros de forma descendent
// tecnica swap

public class Ordenar {
    public static void main(String[] args) {

        double a, b, c, t;

        if (args.length != 3) {
            System.out.println("Han de ser tres arguments, has posat (" + args.length + ")");
            System.exit(-1);
        }

        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);

        // en haver passat aquestes intruccions la b sera mes gran que la a
        // perque la *a* passa el seu valor a la *t* la *b* el passa a la *a* i la *b* agafa le valor de *t*
        if (a < b) {
            t = a;
            a = b;
            b = t;
        }
        if (b < c) {
            t = b;
            b = c;
            c = t;
        }
        if (a < b) {
            t = a;
            a = b;
            b = t;
        }

        System.out.println(a + " " + b + " " + c);
    }
}
