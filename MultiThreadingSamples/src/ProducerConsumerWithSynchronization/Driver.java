package ProducerConsumerWithSynchronization;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		
		int noOfProducers = 2;
		int size = 3;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		Consumer consumer = new Consumer(queue);
		consumer.start();
		
		ExecutorService executor = Executors.newFixedThreadPool(noOfProducers);
		for(int i = 0; i< noOfProducers ; i++) {
			Producer prodcer = new Producer("Producer "+i, queue, size);
			executor.submit(prodcer);
		}

		executor.shutdown();
		
	}

}
