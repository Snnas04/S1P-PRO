public class Test {
    static final int maxVal = 100; 

    public static int obtenerHipotenusaValida(int a, int b) {
        double hypot = Math.hypot(a, b);

        if (hypot % 1 == 0) 
            return (int)hypot;

        return -1;
    }

    public static void iterar() {
        for (int i = 1; i < maxVal + 1; i++) {
            for (int j = 1; j < maxVal + 1; j++) {
                int hypo = obtenerHipotenusaValida(i, j);

                if(hypo > -1)
                    System.out.println("a = " + i + ", b = " + j + ", c = " + hypo);
            }
        }
    }

    public static void main(String[] args) {
        Test.iterar();
    }
}
