package cisie.ase.ro.classes;

public class MathModule {
	public final static int NO_ELEMENTS = 300_000_000;
	int[] array = new int[NO_ELEMENTS];

	public MathModule(int[] array) {
		this.array = array;
	}

	public void populateArray() {
		for (int i = 0; i < NO_ELEMENTS; i++) {
			array[i] = i + 1;
		}
	}

	public long computeSum(int[] array) {
		long sum = 0;
		for (int i = 0; i < NO_ELEMENTS; i++) {
			sum += array[i];
		}

		return sum;
	}

}
