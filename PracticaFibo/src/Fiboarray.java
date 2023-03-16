import java.util.Arrays;

public class Fiboarray {
    int places = 1024;
    int termes;

    long[] num1 = new long[places];
    long[] num2 = new long[places];

    long base = 1_000_000_000_000_000_000L;

    int baseLog = 18;

    public Fiboarray(int termes) {
        this.termes = termes;

        num1[0] = 0L;
        num2[0] = 1L;
        
        // La variable limit conte la quantitat de xifres del long
        int limit = 1;

        for (int i = 2; i <= termes; i++) {

            long dur = 0L;

            for (int j = 0; j < limit; j++) {
                long tempResult = num1[j] + num2[j] + dur;

                dur = 0L;

                if (tempResult >= base){
                    tempResult -= base;
                    dur = 1L;
                }

                num1[j] = num2[j];
                num2[j] = tempResult;
            }

            // amb aquest if augmentam la quantitat de xifres de 1 amb 1 en cas de que sigui necessari
            if (dur != 0)
                num2[limit++] = 1;

            // aquest if serveix per augmentar 1024 si es necessari a place
            // aixi no importa el numero que es vulgui calcular que no donara error de temany
            if (limit >= places) {
                places = places + 1024;
                num1 = Arrays.copyOf(num1, places);
                num2 = Arrays.copyOf(num2, places);
            }
        }
    
        int k = places - 1;

        while (num2[k--] == 0L);

        System.out.print(num2[k + 1]);

        for (int j = k; j >= 0; j--)
            System.out.format("%0" + baseLog + "d", num2[j]);
            
        System.out.println();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Test(1_000_000);
        System.out.println(System.currentTimeMillis() - start);
    }
}
