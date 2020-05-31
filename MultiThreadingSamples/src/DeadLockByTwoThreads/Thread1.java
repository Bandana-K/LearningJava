package DeadLockByTwoThreads;

public class Thread1 implements Runnable{

	String resource1;
	String resource2;
	
	public Thread1(String string1, String string2) {
		resource1 = string1;
		resource2 = string2;
	}

	@Override
	public void run() {
		synchronized (resource1) {
			System.out.println("Have got lock on resource1");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (resource2) {
				System.out.println("got lock on both");
			}
			
		}
	}
	
}
