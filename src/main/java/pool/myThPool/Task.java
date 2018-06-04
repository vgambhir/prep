package pool.myThPool;
/**
 * Extends Thread
 * @author vandana
 *
 */
public class Task implements Runnable {

	private int num;

	public Task(int n) {
		num = n;
	}

	@Override
	public void run() {
		System.out.println("Task " + num + " is running.");
	}
}
