package Primos;

public class Primo3 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USO: Primo <numero>");
            System.exit(-1);
        }

        int numero = Integer.parseInt(args[0]);

        for (int j = 2; j <= numero; j++) {
            int limit = (int) Math.sqrt(j);
            Boolean sortir = false;

            for (int i = 2; i <= limit && !sortir; i++) {
                if (j % i == 0) {
                    //System.out.println(j + " NO es primo");
                    sortir = true;
                }
            }

            // !sortir es com si posam sortir == false
            // inverteix el el valor que te
            if (!sortir) {
                //System.out.println(j + " SI es primo");
                System.out.println(j);
            }
        }
    }
}
