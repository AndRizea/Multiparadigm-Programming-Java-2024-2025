package cisie.ase.ro.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import cisie.ase.ro.classes.MathModule;
import cisie.ase.ro.threads.MathModuleCallable;
import cisie.ase.ro.threads.MathModuleThread;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[MathModule.NO_ELEMENTS];
		MathModule mathModule = new MathModule(array);

		mathModule.populateArray();

		long startTime = System.currentTimeMillis();
		long sum = mathModule.computeSum(array);
		long stopTime = System.currentTimeMillis();
		System.out.println(String.format("The sum computed on the main thread is %d computed in %dms.", sum,
				stopTime - startTime));

		final int NO_THREADS = 6;

		sum = 0;
		startTime = System.currentTimeMillis();

		MathModuleThread[] threads = new MathModuleThread[NO_THREADS];
		for (int i = 0; i < NO_THREADS; i++) {
			threads[i] = new MathModuleThread(i * (MathModule.NO_ELEMENTS / NO_THREADS),
					(i + 1) * (MathModule.NO_ELEMENTS / NO_THREADS), array);
			threads[i].start();
		}

		for (int i = 0; i < NO_THREADS; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < NO_THREADS; i++) {
			sum += threads[i].getSum();
		}

		stopTime = System.currentTimeMillis();
		System.out.println(
				String.format("The sum computed on another thread is %d computed in %dms.", sum, stopTime - startTime));

		// thread pool
		sum = 0;
		startTime = System.currentTimeMillis();
		ExecutorService threadPool = Executors.newFixedThreadPool(NO_THREADS);
		MathModuleThread[] threadPoolArray = new MathModuleThread[NO_THREADS];
		for (int i = 0; i < NO_THREADS; i++) {
			threadPoolArray[i] = new MathModuleThread(i * (MathModule.NO_ELEMENTS / NO_THREADS),
					(i + 1) * (MathModule.NO_ELEMENTS / NO_THREADS), array);
			threadPool.execute(threadPoolArray[i]);
		}

		threadPool.shutdown();
		try {
			threadPool.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < NO_THREADS; i++) {
			sum += threadPoolArray[i].getSum();
		}

		stopTime = System.currentTimeMillis();
		System.out.println(String.format("The sum computed on another thread (thread pool) is %d computed in %dms.",
				sum, stopTime - startTime));

		// callable
		sum = 0;
		startTime = System.currentTimeMillis();
		ExecutorService callablePool = Executors.newFixedThreadPool(NO_THREADS);
		List<Future<Long>> results = new ArrayList<Future<Long>>();
		for (int i = 0; i < NO_THREADS; i++) {
			MathModuleCallable callable = new MathModuleCallable(i * (MathModule.NO_ELEMENTS / NO_THREADS),
					(i + 1) * (MathModule.NO_ELEMENTS / NO_THREADS), array);
			Future<Long> promise = callablePool.submit(callable);
			results.add(promise);
		}
		callablePool.shutdown();

		for (Future<Long> f : results) {
			try {
				sum += f.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		stopTime = System.currentTimeMillis();
		System.out.println(String.format("The sum computed on another thread (callable) is %d computed in %dms.", sum,
				stopTime - startTime));

		// virtual threads
		sum = 0;
		startTime = System.currentTimeMillis();
		ExecutorService virtualThread = Executors.newVirtualThreadPerTaskExecutor();
		MathModuleCallable callable = new MathModuleCallable(0, MathModule.NO_ELEMENTS, array);
		Future<Long> futureVirtual = virtualThread.submit(callable);
		try {
			sum = futureVirtual.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		stopTime = System.currentTimeMillis();
		System.out.println(String.format("The sum computed on a virtual thread is %d computed in %dms.", sum,
				stopTime - startTime));

	}

}
