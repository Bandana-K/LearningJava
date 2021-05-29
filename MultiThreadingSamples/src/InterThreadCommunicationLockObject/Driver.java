package InterThreadCommunicationLockObject;


public class Driver {

	public static void main(String[] args) {

		ResourceLockProcessor resourceLockProcessor = new ResourceLockProcessor();
		
		Thread producer = new Thread( new Runnable() {			
			@Override
			public void run() {
				try {
					resourceLockProcessor.produce();
				} catch (InterruptedException e) {
					System.out.println("producer interrupted");
				}
			}
		});
		
		
		Thread consumer = new Thread( new Runnable() {			
			@Override
			public void run() {
				try {
					resourceLockProcessor.consume();
				} catch (InterruptedException e) {
					System.out.println("consumer interrupted");
				}
			}
		});
		
		consumer.start();
		producer.start();
	}

}
