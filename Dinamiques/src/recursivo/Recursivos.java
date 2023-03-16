package recursivo;

public class Recursivos {
    public Recursivos(int num) {
        System.out.println(factorial(num));
        System.out.println(fibonacci(num));
    }

    public int factorial(int n) {
        // if (n == 1)
        //     return n;
        
        // return n * factorial(n - 1);

        // fa lo mateix
        return (n == 1) ? n : n * factorial(n - 1 );
    }

    public int fibonacci(int n) {
        // if (n < 2)
        //     return n;
        
        // return fibonacci(n - 1) + fibonacci(n - 2);

        return (n < 2) ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        new Recursivos(5);
    }
}
