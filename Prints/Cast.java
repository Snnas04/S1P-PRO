package Prints;

public class Cast {
    public static void main(String[] args) {

        // Exemple de Casting

        float a;
        int b, c;

        a = (float) 7;
        b = 8;
        c = 5;

        c = (int) a * b;
        c = (int) (c / (a + b));

        System.out.println(c);
    }
}
