package ProducerConsumerWithSynchronization;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {

	private String name;
	private Queue<Integer> queue;
	private int size;

	Producer(String name, Queue<Integer> queue, int size) {
		this.name = name;
		this.queue = queue;
		this.size = size;
	}

	public void run() {

		try {
			System.out.println(name + "  is up and running");
			int count = 0;
			Thread.sleep(1000);

			while (count < size) {
				synchronized (queue) {

					while (queue.size() == size) {
						System.out.println("queue is full, waiting for consumer to consume some data");
						queue.wait();
					}

					Random random = new Random();
					int i = random.nextInt(100);
					System.out.println(name + " has produced the data : " + i);
					queue.add(i);
					count++;

					queue.notifyAll();
				}
				
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(name + "is interrupted");
		}

	}

}
