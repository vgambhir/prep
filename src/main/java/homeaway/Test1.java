package homeaway;
/**
 * Locks and ordering
 * @author vandana
 *
 */
public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		Object obj1 = new Object();
		Object obj2 = new Object();

		Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
		//fix to remove deadlock
		//Thread t2 = new Thread(new SyncThread(obj1, obj2), "t2");
		Thread t2 = new Thread(new SyncThread(obj2, obj1), "t2");

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}

class SyncThread implements Runnable {

	private Object obj1;
	private Object obj2;

	public SyncThread(Object o1, Object o2) {
		this.obj1 = o1;
		this.obj2 = o2;
	}

	@Override
	public void run() {

		// acquire lock on obj1
		synchronized (obj1) {

			work();

			synchronized (obj2) {

				work();
			}

		}

		System.out.println(Thread.currentThread().getName() + " finished execution.");
	}

	private void work() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
