package Bucles;

public class For2 {
    public static void main(String[] args) {
        //nomes multiples de 7
        //podem crear la variable d'inicialitzacio defora del bucle for
        // fent aixo la variable es pot declerar defora del for, perque existeix tant dedins com defora del for
        // si esta dins el for nomes es i la cridam defora del for dona error de compilacio
        int i = 7;

        for (; i < 100; i += 7) {
            System.out.println(i);
        }
        //nomes mostrara el primer numero que no complesqui el bucle
        System.out.println("*****");
        System.out.println(i);
    }
}
