package Fibonacci;

// posam long en lloc de int perque accepta més numeros

public class Fibonacci_Ramon {
    public static void main(String[] args) {
        int limit = 10;

        long a = 0;
        long b = 1;

        for (int i = 0; i < limit; i++) {
            // System.out.println(a);
            long t = a;
            a = b;
            // b = b + t;
            b += t;
            System.out.println(b);
        }
        //System.out.println(b);
    }
}
