package Sorting;
import java.util.Random;

public class Sorting {
    private final int quants;
    private final int[] datos;

    public Sorting(int quants) {
        this.quants = Math.abs(quants);
        this.datos = new int[this.quants];
    }

    private void tiempo(long milisegundos) {
        long segundos = milisegundos / 1000;
        milisegundos %= 1000;
        long minutos = segundos / 60;
        segundos %= 60;

        System.out.format("  %02d:%02d.%03d", minutos, segundos, milisegundos);
    }

    private void swap(int x, int y) {
        int z = datos[x];
        datos[x] = datos[y];
        datos[y] = z;
    }

    private void aleatorio() {
        Random r = new Random(2022);

        for (int i = 0; i < quants; i++) 
            datos[i] = r.nextInt(quants);
    }

    private void ascendente() {
        for (int i = 0; i < quants; i++) 
            datos[i] = i;
    }

    private void descendente() {
        for (int i = 0; i < quants; i++) 
            datos[i] = quants - i - 1;
    }


    private void bubble() {
        for (int i = 0; i < quants - 1; i++)
            for (int j = 0; j < quants - i - 1; j++)
                if (datos[j] > datos[j + 1]) swap(j, j + 1);
    }

    private void selection() {
        for (int i = 0; i < quants - 1; i++) {
            int k = i;
            for (int j = i + 1; j < quants; j++) if (datos[j] < datos[k]) k = j;
            swap(i, k);
        }
    }

    private void insertion() {
        for (int i = 1; i < quants; ++i) {
            int key = datos[i];
            int j = i - 1;

            while (j >= 0 && datos[j] > key) {
                datos[j + 1] = datos[j];
                j = j - 1;
            }
            datos[j + 1] = key;
        }
    }

    private void shell() {
        for (int gap = quants >> 1; gap > 0; gap >>= 1) {
            for (int i = gap; i < quants; i++) {
                int temp = datos[i];
                int j;
                for (j = i; j >= gap && datos[j - gap] > temp; j -= gap) {
                    datos[j] = datos[j - gap];
                }
                datos[j] = temp;
            }
        }
    }

    private void countSort(int exp) {
        int[] output = new int[quants];
        int i;
        int[] count = new int[10];

        for (i = 0; i < 10; i++) 
            count[i] = 0;
        for (i = 0; i < quants; i++) 
            count[(datos[i] / exp) % 10]++;
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1];
        for (i = quants - 1; i >= 0; i--) {
            int k = (datos[i] / exp) % 10;
            output[count[k] - 1] = datos[i];
            count[k]--;
        }
        for (i = 0; i < quants; i++)
            datos[i] = output[i];
    }

    private void radix() {
        int m = datos[0];
        for (int i = 1; i < quants; i++) 
            if (datos[i] > m) 
                m = datos[i];

        for (int exp = 1; m / exp > 0; exp *= 10) 
            countSort(exp);
    }

    private void tunned(int menor, int mayor) {
        if ((mayor - menor) < 200) {
            for (int i = menor + 1; i <= mayor; i++) {
                int key = datos[i];
                int j = i - 1;

                while (j >= 0 && datos[j] > key) {
                    datos[j + 1] = datos[j];
                    j = j - 1;
                }
                datos[j + 1] = key;
            }
            return;
        }
        int i = menor;
        int j = mayor;
        int pivote = datos[(menor + mayor) >> 1];

        while (i <= j) {
            while (datos[i] < pivote) i++;
            while (pivote < datos[j]) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (menor < j) 
            tunned(menor, j);
        if (i < mayor) 
            tunned(i, mayor);
    }

    private void quick(int menor, int mayor) {
        int i = menor;
        int j = mayor;
        int pivote = datos[(menor + mayor) >> 1];

        while (i <= j) {
            while (datos[i] < pivote) i++;
            while (pivote < datos[j]) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (menor < j) 
            quick(menor, j);
        if (i < mayor) 
            quick(i, mayor);
    }

    private void testing(int metodo) {
        long milisegundos = System.currentTimeMillis();
        switch (metodo) {
            case 0 -> bubble();
            case 1 -> selection();
            case 2 -> insertion();
            case 3 -> shell();
            case 4 -> radix();
            case 5 -> quick(0, quants - 1);
            case 6 -> tunned(0, quants - 1);
        }
        tiempo(System.currentTimeMillis() - milisegundos);
    }

    String[] metodos = {"Bubble", "Selection", "Insertion", "Shell", "Radix", "Quick", "Tunned"};

    private void test() {
        System.out.print("\nQuantitat  " + quants);
        System.out.print("\nOrganitzat Aleatori   Ascendent  Descendent");
        for (int m = 3; m < metodos.length; m++) {
            System.out.format("\n%-9s", metodos[m]);
            aleatorio();
            // testing(m);
            // ascendente();
            // testing(m);
            // descendente();
            // testing(m);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Sorting s = new Sorting(1_000);
        s.test();
    }
}
