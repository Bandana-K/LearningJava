package InterThreadCommunication;

import java.util.Scanner;

public class Processor {
	
	public void produce() throws InterruptedException {
		
		System.out.println("Producer is up");
		System.out.println("Producer going to acquire the lock");

		synchronized(this) {
			
			System.out.println("Producer has got the lock, and is going  to sleep for 2 secs. \nAfter which it will call wait and give up all the locks");
			Thread.sleep(2000);
			
			wait();
			
			System.out.println("Producer got the lock again and is resuming");

		}
	}
	
	public void consume() throws InterruptedException {
		
		System.out.println("Consumer is up and is going to sleep for 1 sec");
		Thread.sleep(1000);
		System.out.println("Consumer going to acquire the lock");

		synchronized(this) {
			
			System.out.println("Consumer has got the lock, and is doing the processing. \n Enter any key to relinquish the lock");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			
			notify();
			
			System.out.println("Consumer has called the notify, but lock will be released only once the block is exited.");
			Thread.sleep(1000);
		}
	}

}
