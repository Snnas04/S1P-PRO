public class HeapSort implements Algorithm {
	public void sorting(int[] array) {
		int N = array.length;

		for (int i = N / 2 - 1; i >= 0; i--)
			heapify(array, N, i);

		for (int i = N - 1; i > 0; i--) {
			// Move current root to end
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			heapify(array, i, 0);
		}
	}

	void heapify(int[] array, int N, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < N && array[left] > array[largest])
			largest = left;

		if (right < N && array[right] > array[largest])
			largest = right;

		if (largest != i) {
			int swap = array[i];
			array[i] = array[largest];
			array[largest] = swap;

			heapify(array, N, largest);
		}
	}
}
