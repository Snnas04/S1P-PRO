package Fibonacci;

// se comença a sumar per la dreta

public class Cadenes {
    static String num1 = "7812912";
    static String num2 = "3534352";
    public static void main(String[] args) {
        reverso(num1);
        reverso(num2);

        String num3 = "";

        int dur1 = 0;

        for (int i = 0; i < num1.length(); i++) {
            // forma 1 d'anar numero a numero
            int j = Integer.parseInt(num1.substring(i, i + 1));
            int k = Integer.parseInt(num2.substring(i, i + 1));
            // forma 2 d'anar numero a numero
            // int j = num1.charAt(i) - '0';
            // int k = num2.charAt(i) - '0';

            int z = j + k + dur1;

            if (z >= 10) {
                z -= 10;
                dur1 = 1;
            }
            else {
                dur1 = 0;
            }

            num3 += z;
        }

        if (dur1 != 0) {
            num3 += 1;
        }
        reverso(num3);
        System.out.println(tenebroso("microsoft"));    
    }

    // gira el resultat perque surti aixi com el tocariem veure
    // el que fa es mostrar els caracters començant per es derrer(lenght - 1)
    private static void reverso(String cadena) {
        for (int i = cadena.length() -  1; i >= 0; i--) {
            System.out.print(cadena.charAt(i));
        }
        System.out.println("");
    }
    
    private static String tenebroso(String cadena) {
        String result = "";

        for (int i = cadena.length() - 1; i >= 0; i--) {
            result += cadena.charAt(i);
        }
        return result;
    }
}
