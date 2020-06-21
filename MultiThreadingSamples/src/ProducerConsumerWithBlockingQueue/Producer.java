package ProducerConsumerWithBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{

	private String name;
	private BlockingQueue<Integer> queue;
	private int size;
	
	Producer(String name, BlockingQueue<Integer> queue, int size){
		this.name  = name;
		this.queue = queue;
		this.size = size;
	}
	
	public void run() {
		
		System.out.println(name + "  is up and running");		
		int  count =  0;
		while(count < size) {
			Random random = new Random();
			int input = random.nextInt(100);
			try {
				Thread.sleep(input);
				queue.put(input);
				System.out.println(name + " wrote "+ input + " on the queue ");
				count++;
			} catch (InterruptedException e) {
				System.out.println(name + " interrupted");
			}
					
		}

	}
}
