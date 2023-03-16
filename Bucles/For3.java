package Bucles;

// mostrar els multriples de dos i de tres
public class For3 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            int resultat = i / 2;
            int prova = resultat * 2;

            if (prova == i) {
                System.out.println(i);
            }

            // podem emprar les meteixes variables perque ja les hem empleat i no les necessitam
            resultat = i / 3;
            prova = resultat * 3;

            if (prova == i) {
                System.out.println(i);
            }
        }
    }
}
