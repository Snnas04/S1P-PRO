package Activitats;

// mostrar tots els numeros excepte els que son multiples de dos i de tres

public class ActivitatArreglos {
    public static void main(String[] args) {
        int[] numeros = new int[17];

        int gap = 2;
        int value = 5;

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = value;
            value += gap;
            gap = 6 - gap;
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(i + "-" + numeros[i]);
        }
    }
}
