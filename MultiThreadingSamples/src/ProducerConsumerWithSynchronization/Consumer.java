package ProducerConsumerWithSynchronization;

import java.util.Queue;

public class Consumer extends Thread {

	private Queue<Integer> queue;

	Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		
		try {
			System.out.println("Consumer is up and running");
			Thread.sleep(5000);

			while (true) {
				synchronized (queue) {

					while (queue.size() == 0) {
						System.out.println("queue is empty,  Consumer thread is waiting for the data");
						queue.wait();
					}

					int i = queue.remove();
					System.out.println(" Consumer has consumed the message : " + i);
					
					queue.notifyAll();
					Thread.sleep(1000);

				}
			}
		} catch (InterruptedException e) {
			System.out.println("Consumer thread interrupted");
		}

	}
}
