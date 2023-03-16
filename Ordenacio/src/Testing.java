import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Testing {
    int size;

	public Testing(int size) {
        this.size = Math.abs(size);
    }

	private int[] randomArray() {
		Random generator = new Random(666);

		return IntStream.range(0, size).map(i -> generator.nextInt(1000)).toArray();
	}

	private int[] ascendingArray() {
		return IntStream.range(0, size).toArray();
	}

	private int[] descendingArray() {
		return IntStream.range(0, size).map(i -> size - i - 1).toArray();
	}

	public void test(Algorithm algorithm) {
        System.out.format("%12s", algorithm.getClass().getName() + " ->");

		long ms = System.currentTimeMillis();
		
        algorithm.sorting(randomArray());
		System.out.print(toTime(System.currentTimeMillis() - ms));
		ms = System.currentTimeMillis();
		
        algorithm.sorting(ascendingArray());
		System.out.print(toTime(System.currentTimeMillis() - ms));
		ms = System.currentTimeMillis();
		
        algorithm.sorting(descendingArray());
		System.out.print(toTime(System.currentTimeMillis() - ms));
		System.out.println();
	}

	private String toTime(long ms) {
		long mm = TimeUnit.MILLISECONDS.toMinutes(ms) % 60;
		long ss = TimeUnit.MILLISECONDS.toSeconds(ms) % 60;

		return String.format("  %02d:%02d.%03d", mm, ss, ms % 1000);
	}

	// private void verArray(int[] array) {
	// 	for (int x : array)
    //         System.out.print(" " + x);
	// 	System.out.println();
	// }
}
