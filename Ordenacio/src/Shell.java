public class Shell implements Algorithm {
    public void sorting(int[] array) {
        for (int gap = array.length >> 1; gap > 0; gap >>= 1) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j;
                
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
                    array[j] = array[j - gap];
                
                array[j] = temp;
            }
        }
    }
}
