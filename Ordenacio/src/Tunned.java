public class Tunned implements Algorithm {
    public void sorting(int[] array) {
        tunnet(array, array.length - 1, 0);
    }

    private void tunnet(int[] array, int mayor, int menor) {
        if ((mayor - menor) < 200) {
            for (int i = menor + 1; i <= mayor; i++) {
                int key = array[i];
                int j = i - 1;

                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
            return;
        }
        int i = menor;
        int j = mayor;
        int pivote = array[(menor + mayor) >> 1];

        while (i <= j) {
            while (array[i] < pivote) i++;
            while (pivote < array[j]) j--;
            if (i <= j) {
                int z = array[j];
                array[j] = array[j + 1];
                array[j + 1] = z;
                i++;
                j--;
            }
        }
        if (menor < j) 
            tunnet(array, menor, j);
        if (i < mayor) 
            tunnet(array, i, mayor);
    }
}
