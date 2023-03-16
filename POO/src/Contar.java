public class Contar {
    int contador;

    public Contar() {
        contador = 0;
    }

    public Contar(int contador) {
        /* per dir que el contador nostro agafi el valor del contador que ens arriba, afegim el prefixe this */
        this.contador = contador;
        /* -1- posant el mostrar aqui nomes mostrara el contador si podam algun numero a main */
        // mostrar();
    }

    public static void main(String[] args) {
        /* no cridam les funcions, feim una copi d'aquetes, per aixo hem de posar new, pero es com si fos una cridada */
        // new Contar(7);
        /* si posam un argument a contar cridara al segon contar, sino cridara al primer contar */
        Contar c1 = new Contar();
        c1.mostrar();
        Contar c2 = new Contar(3);
        System.out.println(c2);
    }

    private void mostrar() {
        System.out.println(contador);
    }

    /* amb aquets segona manera pots elaborar més les respostes */
    /* Per indicar que la rutina ja exiteix pero tu fas una altre verció, no passa res per no posar-ho */
    @Override
    public String toString(){
        /* amb \n feim un salt de linea */
        return String.format("Counter value: %d\n", contador);
    }
}
