package pool.myThPool;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * In example, we used notify() instead of notifyAll(). Because notify() has
 * more desirable performance characteristics than notifyAll(); in particular,
 * notify() causes many fewer context switches, which is important in a server
 * application. But it is important to make sure when using notify() in other
 * situation as there are subtle risks associated with using notify(), and it is
 * only appropriate to use it under certain specific conditions.
 * 
 * @author vandana
 *
 */
public class ThreadPool {
	private final int noOfThreads;
	private final PoolWorker[] threads;
	private final LinkedBlockingQueue<Runnable> queue;

	public ThreadPool(int noOfThreads) {
		this.noOfThreads = noOfThreads;
		queue = new LinkedBlockingQueue<Runnable>();
		threads = new PoolWorker[noOfThreads];

		for (int i = 0; i < noOfThreads; i++) {
			threads[i] = new PoolWorker();
			threads[i].start();
		}
	}

	public void execute(Runnable task) {
		synchronized (queue) {
			// add task to blocking Q
			queue.add(task);
			// using queue for wait and notify
			queue.notify();
		}
	}

	// extends Thread
	private class PoolWorker extends Thread {

		@Override
		public void run() {
			Runnable task;

			while (true) {
				// It is important to use synchronise block while working with the queue, to
				// control the access of threads to the queue.
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
							System.out.println("Waking up" + Thread.currentThread().getName());
						} catch (InterruptedException e) {
							System.out.println("An error occurred while queue is waiting: " + e.getMessage());
						}
					}
					task = queue.poll();
				}

				// If we don't catch RuntimeException,
				// the pool could leak threads
				try {
					// don't need to implement Runnable it just calls run() directly
					task.run();
				} catch (RuntimeException e) {
					System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
				}
			}
		}
	}
}
