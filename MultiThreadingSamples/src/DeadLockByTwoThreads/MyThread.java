package DeadLockByTwoThreads;

public class MyThread implements Runnable{

	String threadName;
	String resource1;
	String resource2;
	
	public MyThread(String threadName, String string1, String string2) {
		this.threadName = threadName;
		resource1 = string1;
		resource2 = string2;
	}

	@Override
	public void run() {
		synchronized (resource1) {
			System.out.println(this.threadName +  " has got lock on resource1");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (resource2) {
				System.out.println(this.threadName +  " has got lock on both");
			}
			
		}		
		System.out.println(this.threadName +  " Done with the processing");
	}
	
}
