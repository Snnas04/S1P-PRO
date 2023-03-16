package Activitats;

public class Stringonacci {
    static String num1 = "0";
    static String num2 = "1";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Insert a number");
            System.exit(-1);
        }

        int numInserted = Integer.parseInt(args[0]);

        if (numInserted < 2) {
            System.out.println(numInserted);
            return;
        }

        long start = System.nanoTime();

        for (int i = 0; i < numInserted - 1; i++) {
            String result = "";
            int dur1 = 0;

            for (int j = 0; j < num1.length(); j++) {
                int first = Integer.parseInt(num1.substring(j, j + 1));
                int second = Integer.parseInt(num2.substring(j, j + 1));

                int individualResult = first + second + dur1;

                if (individualResult >= 10) {
                    individualResult -= 10;
                    dur1 = 1;
                }
                else {
                    dur1 = 0;
                }

                result += individualResult;
            }
            
            num1 = num2;
            num2 = result;

            if (dur1 != 0) {
                num1 += "0";
                num2 += "1";
            }
        }
        reverso(num2);

        System.out.println((System.nanoTime() - start) / 1000000000F);
    }

    private static void reverso(String cadena) {
        for (int i = cadena.length() -  1; i >= 0; i--) {
            System.out.print(cadena.charAt(i));
        }
        System.out.println("");
    }
}
