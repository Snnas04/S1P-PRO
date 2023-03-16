package Bucles;

public class Arreglos {
    public static void main(String[] args) {
        int[] numeros = new int[16];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = 7 * (i + 1);
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(i + " " + numeros[i]);
        }

        System.out.println("***********");

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i - 8;
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(i + " " + numeros[i]);
        }

        numeros[9] = 6839;
        System.out.println("***********");

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(i + " " + numeros[i]);
        }
    }
}
