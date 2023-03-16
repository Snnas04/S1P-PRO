package Activitats;

// matricula = 0000 00 00 00
// convertir la lletra a numero
// GLP -> G*20² + L*20¹ + P*20⁰ == 4*400 + 8*20 + 11 = 1771

public class Matricula {

    static String lletres = "BCDFGHJKLMNPRSTVWXYZ";
    static String numeros = "0123456789";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Se esperaba una matrícula");
            System.exit(-1);
        }

        String matricula = args[0];
        // verificar la longitud de l'estrig introduit
        if (matricula.length() != 7) {
            System.out.println("Se esperaba una matricula, en formatao 0000BBB");
        }

        int resultNum = 0;
        // verificar els numeros
        for (int i = 0; i < 4; i++) {
            // amb el toUpperCase() convertim les minuscules a malluscules
            String cont = matricula.substring(i, i + 1).toUpperCase();
            // amb indexOf podem accedir a un caracter
            int index = numeros.indexOf(cont);
            if (index < 0) {
                System.out.println("Se esperaba una matricula, en formatao 0000BBB");
                // posam -2 per saber que ha sortit per una altra banda
                System.exit(-2);
            }

            resultNum = resultNum * 10 + index;
        }

        int resultLlet = 0;
        // verificar les lletres
        for (int i = 4; i < 7; i++) {
            String cont = matricula.substring(i, i + 1).toUpperCase();
            int index = lletres.indexOf(cont);
            if (lletres.indexOf(cont) < 0) {
                System.out.println("Se esperaba una matricula, en formatao 0000BBB");
                System.exit(-2);
            }
            resultLlet = resultLlet * 20 + index;
        }
        // agafam les lletres les multiplica per 10000, perque de cada lletra hi ha 10000 numeros
        System.out.println(10000 * resultLlet + resultNum);
    }
}
