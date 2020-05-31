package DeadlockBySingleThread;

public class DeadLockBySingleThread {
	
	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().join();
	}	
}
