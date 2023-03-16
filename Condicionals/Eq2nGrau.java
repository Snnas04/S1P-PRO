package Condicionals;

public class Eq2nGrau {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Han de ser tres arguments, has posat (" + args.length + ")");
            System.exit(-1);
        }

        //Posam el .0 per indicar que es double, ja que es un int *per defecte*
        //Si volguesim indicar que es float posam una f. ex: 1f
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double x, y;

        //per no arriscarmos a amb els valors que ens dona l'usuari, podem posar valors per defecte
        // pero hem de declara les variables defora de l'if
        // double a, b, c;

        //if (args.length !=3) {
        //    System.out.println("Han de ser tres arguments, has posat (" + args.length + ")");
        //    System.out.println("agafam valors per defecte");
        //    a = 1.0;
        //    b = 1.0;
        //    c = 1.0;
        //}
        //else {
            //a = Double.parseDouble(args[0]);
            //b = Double.parseDouble(args[1]);
            //c = Double.parseDouble(args[2]);
        //}

        double d = b * b - 4.0 * a *c;
        double e = 2 * a;

        if (d >= 0) {
            x = (-b + Math.sqrt(d)) / e;
            y = (-b - Math.sqrt(d)) / e;

            System.out.println("X1 = " + x);
            System.out.println("X2 = " + y);
        }
        else {
            d = Math.sqrt(-d);
            x = -b / e;
            y = d / e;

            // la *i* del final es per indicar que un numero es imaginari
            // la part real es la *x* i la imaginaria es la *y*
            System.out.println("X1 = " + x + " + " + y + "i");
            System.out.println("X2 = " + x + " - " + y + "i");
        }
    }
}
