package Activitats;

public class Fibonacci {
    public static void main(String[] args) {
        int limit = 100;

        int primer = 0;
        int segon = 1;
        int resultat = 0;

        for (int i = 0; i < limit; i++) {
            if (i <= 1) {
                resultat = i;
            }
            System.out.println(primer);
            resultat = primer + segon;
            primer = segon;
            segon = resultat;
            System.out.println(resultat);
        }
        //System.out.println(resultat);
    }
}
