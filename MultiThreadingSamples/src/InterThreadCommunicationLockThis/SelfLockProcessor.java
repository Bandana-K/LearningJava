package InterThreadCommunicationLockThis;

import java.util.Scanner;

public class SelfLockProcessor {
		
	public void produce() throws InterruptedException {
		
		System.out.println("Producer is up and going to acquire the lock");

		synchronized(this) {
			
			System.out.println("Producer has got the lock, and is going  to sleep for 5 secs.");
			Thread.sleep(5000);
			
			System.out.println("Producer is awake now, and is going to release the locks.");
			wait();
			
			System.out.println("Producer got the lock again and is resuming");

		}
	}
	
	public void consume() throws InterruptedException {
		
		System.out.println("Consumer is up and is going to sleep for 1 sec");
		Thread.sleep(1000);
		System.out.println("Consumer going to acquire the lock");

		synchronized(this) {
			
			System.out.println("Consumer has got the lock, and is doing the processing. Enter any key to relinquish the lock");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			
			notify();
			
			System.out.println("Consumer has called the notify, but lock will be released only once the block is exited.");
			Thread.sleep(1000);
		}
	}

}
