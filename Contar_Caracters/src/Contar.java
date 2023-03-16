public class Contar {
    int contador;

    public Contar() {
        contador = 0;
    }

    public Contar(int contador) {
        /* per dir que el contador nostro agafi el valor del contador que ens arriba, afegim el prefixe this */
        this.contador = contador;
        mostrar();
    }

    public static void main(String[] args) {
        /* no cridam les funcions, feim una copi d'aquetes, per aixo hem de posar new, pero es com si fos una cridada */
        new Contar(7);
    }

    private void mostrar() {
        System.out.println(contador);
    }
}
