package DeadLockByTwoThreads;

public class DriverClass {
	
	public static void main(String[] args) {
		
		String resource1 = "ONE";
		String resource2 = "TWO";
		
//		Output for the below code is as follows
//		Thread1 has got lock on resource1
//		Thread1 has got lock on both
//		Thread1 Done with the processing
//		Thread2 has got lock on resource1
//		Thread2 has got lock on both
//		Thread2 Done with the processing
		
//		new Thread(new MyThread("Thread1", resource1, resource2)).start();
//		new Thread(new MyThread("Thread2", resource1, resource2)).start();
		
//		However the belo code is stuck in deadlock as both the threads will be waiting for the other one to release one of the waiting resource
	
		new Thread(new MyThread("Thread1", resource1, resource2)).start();
		new Thread(new MyThread("Thread2", resource2, resource1)).start();

		
	}
}
