public class Quick implements Algorithm {
    public void sorting(int[] array) {
        quick(0, array.length - 1, array);
    }

    private void quick(int menor, int mayor, int[] array) {
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
            quick(menor, j, array);

        if (i < mayor) 
            quick(i, mayor, array);
    }
}
