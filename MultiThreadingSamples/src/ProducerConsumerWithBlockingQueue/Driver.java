package ProducerConsumerWithBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		
		int noOfProducers = 3;
		int queueSize = 5;
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);
		
		Consumer consumer = new Consumer(queue);
		consumer.start();
		
		ExecutorService executor = Executors.newFixedThreadPool(noOfProducers);
		for(int i = 0; i< noOfProducers ; i++) {
			Producer prodcer = new Producer("Producer "+i, queue, queueSize);
			executor.submit(prodcer);
		}

		Thread.sleep(10);
		System.out.println("Producers and Consumers are up");
		executor.shutdown();
		
	}

}
