package pool.myThPool;

public class MyTask {
	private int num;

	public MyTask(int n) {
		num = n;
	}

	
	public void execute() {
		System.out.println("MyTask " + num + " is running.");
	}
}
