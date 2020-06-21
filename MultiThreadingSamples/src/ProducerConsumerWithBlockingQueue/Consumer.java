package ProducerConsumerWithBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{

	private BlockingQueue<Integer> queue;
	
	Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	public void run(){
		
		System.out.println("Consumer is up and running");
		while(true) {
			Random random = new Random();
			int sleepTime = random.nextInt(100);
			try {
				Thread.sleep(sleepTime);
				Integer output = queue.take();
				System.out.println("Consumer consumed the message : " + output);
			} catch (InterruptedException e) {
				System.out.println("Consumer interrupted");
			}
		}
		
	}
}
