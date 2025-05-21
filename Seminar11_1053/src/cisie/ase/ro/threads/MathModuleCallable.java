package cisie.ase.ro.threads;

import java.util.concurrent.Callable;

public class MathModuleCallable implements Callable<Long> {
	private int[] array;
	private int startIndex;
	private int stopIndex;

	public MathModuleCallable(int startIndex, int stopIndex, int[] array) {
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
		this.array = array;
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (int i = startIndex; i < stopIndex; i++) {
			sum += array[i];
		}
		return sum;
	}

}
