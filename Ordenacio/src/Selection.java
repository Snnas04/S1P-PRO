public class Selection implements Algorithm {
    public void sorting(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int k = i;

            for (int j = i + 1; j < array.length; j++) 
                if (array[j] < array[k]) k = j;

            int z = array[i];
            array[i] = array[k];
            array[k] = z;
        }
    }
}
