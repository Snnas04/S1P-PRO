package Primos;

// binari

// & = and
// | = or
// ~ = not
// << = volta amb la direccio que apunta un cap a l'esquerra, multiplicar
// >> = volta amb la diraccio que apunta un cap a la dreta, dvidir

public class Binari {
    // posant la *0b* indicam que es binari
    static byte uno = 0b00000101; // oboooo1o1o (exemple de <<)
    static byte dos = 0b00010001;

    public static void main(String[] args) {
        // equivalent a multiplicar per 2
        System.out.println(uno << 1 | dos);
    }
}
