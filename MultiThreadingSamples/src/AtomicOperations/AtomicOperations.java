package AtomicOperations;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperations {
	
  /*
  	The increment operation count++ is not an atomic operation.
	Its actually 3 steps :  read count, add 1 to it, write its value in memory again.
	So its quite possible that both the thread read the same value of it and then individually increment it
	In this case both the threads will be loosing the update done by the other thread. 
	That's the reason many a times the value for count will be less than 20000
	To fix it, either use the AtomicInteger where increments are atomic operations,
	Or go with synchronization, so that once a thread is writing the value, the other one doesn't read in between
	
	Also while we might think that making the variable volatile might help, but it won't.
	Volatile only ensures the value is not getting cached, and its getting read from memory everytime.
	So while it will always read the correct value, but wht about the simultaneous reads and loosing the write updates of other thread.
  */
	
	private int count = 0;
	private AtomicInteger atomicCount = new AtomicInteger(0);

	public static void main(String[] args) {
		AtomicOperations operation = new AtomicOperations();
		operation.startCountingThreads();
	}

	private void startCountingThreads() {
		
		Thread thread1= new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i<10000; i++) {
					count++;
//					increment();
					atomicCount.getAndIncrement();
				}
			}			
		});
		
		Thread thread2= new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i<10000; i++) {
					count++;
//					increment();
					atomicCount.getAndIncrement();
				}
			}			
		});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("Threads interrupted, exiting now");
		}
		
		System.out.println("count = " + count);
		System.out.println("atomicCount = " + atomicCount.get());

	}

	private synchronized void increment() {
		count++;
	}
}
