package cisie.ase.ro.threads;

public class MathModuleThread extends Thread {
	private int[] array;
	private int startIndex;
	private int stopIndex;
	private long sum;

	public MathModuleThread(int startIndex, int stopIndex, int[] array) {
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
		this.array = array;
	}

	public long getSum() {
		return sum;
	}

	@Override
	public void run() {
		super.run();
		for (int i = startIndex; i < stopIndex; i++) {
			sum += array[i];
		}
	}

}
