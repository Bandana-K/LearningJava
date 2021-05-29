package InterThreadCommunicationLockThis;


public class Driver {

	public static void main(String[] args) {

		SelfLockProcessor processor = new SelfLockProcessor();
		
		Thread thisProducer = new Thread( new Runnable() {			
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					System.out.println("producer interrupted");
				}
			}
		});
		
		
		Thread thisConsumer = new Thread( new Runnable() {			
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					System.out.println("consumer interrupted");
				}
			}
		});
		
		thisConsumer.start();
		thisProducer.start();
	}
}
