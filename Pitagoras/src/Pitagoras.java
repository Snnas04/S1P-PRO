public class Pitagoras {
    public Pitagoras(int limit) {
        for (int i = 0; i <= limit; i++)
            tripleta(i + i);
    }

    private void tripleta(int r) {
        // comprobam que el numero sigui "perfecre"
        int factor = r * r / 2;

        // feim l'arrel quadrada de "factor"
        int arrel = (int) Math.sqrt(factor);

        for (int s = 1; s <= arrel; s++) {
            if (factor % s == 0) {
                int t = factor / s;

                // per imprimir les tripletes
                if (esCoprimo(s, t))
                    System.out.format("(%d, %d, %d) ", r + s, r + t, r + s + t);
            }

        }
        // a la terminal indicam de quins dos coprimos venen les tripletes
        System.out.format(" tripleta/s de %d & %d", r, factor);

        System.out.println();        
    }

    // aquets es una funcio recursiva per poder retornar numeros coprimos
    static int coprimo(int a, int b)
    {
        if (a == 0 || b == 0)
            return 0;

        if (a == b)
            return a;

        if (a > b)
            return coprimo(a - b, b);

        return coprimo(a, b - a);
    }

    // indicam si el dos numeros son co-primos o no
    // si els resultat s de "cprimo" son iguals a 1 significa que es coprimo, sino no
    private boolean esCoprimo(int a, int b) {
        if ( coprimo(a, b) == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        new Pitagoras(25);
    }
}


// FONTS
// https://www.disfrutalasmatematicas.com/numeros/pitagoricas-ternas.html
// https://en.wikipedia.org/wiki/Formulas_for_generating_Pythagorean_triples
