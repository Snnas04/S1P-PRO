public class Radix implements Algorithm {
    public void sorting(int[] array) {
        int[] array;   
    }

    public void radix(array, exp) {
        int m = array[0];
        for (int i = 1; i < array.length; i++) 
            if (array[i] > m) 
                m = array[i];

        for (int exp = 1; m / exp > 0; exp *= 10) 
            countSort(exp);
    }

    private void countSort(int exp) {
        int[] output = new int[array.length];
        int i;
        int[] count = new int[10];

        for (i = 0; i < 10; i++) 
            count[i] = 0;

        for (i = 0; i < array.length; i++) 
            count[(array[i] / exp) % 10]++;

        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1];

        for (i = array.length - 1; i >= 0; i--) {
            int k = (array[i] / exp) % 10;
            output[count[k] - 1] = array[i];
            count[k]--;
        }

        for (i = 0; i < array.length; i++)
            array[i] = output[i];
    }
}
