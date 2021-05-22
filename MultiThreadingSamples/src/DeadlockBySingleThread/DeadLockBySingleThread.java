package DeadlockBySingleThread;

public class DeadLockBySingleThread {
	
	public static void main(String[] args) throws InterruptedException {
		//Main thread is waiting for itself to finish so that it can close, hence is stuck
		Thread.currentThread().join();
		System.out.println("This line will never be printed");
	}	
}
