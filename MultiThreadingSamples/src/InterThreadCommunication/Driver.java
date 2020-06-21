package InterThreadCommunication;

public class Driver {

	public static void main(String[] args) {

		Processor processor = new Processor();
		
		Thread producer = new Thread( new Runnable() {			
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					System.out.println("producer interrupted");
				}
			}
		});
		
		
		Thread consumer = new Thread( new Runnable() {			
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					System.out.println("consumer interrupted");
				}
			}
		});
		
		consumer.start();
		producer.start();
		
	}

}
