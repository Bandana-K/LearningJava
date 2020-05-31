package DeadLockByTwoThreads;

public class DriverClass {
	
	public static void main(String[] args) {
		String resource1 = "ONE";
		String resource2 = "TWO";
		
		new Thread(new Thread1(resource1, resource2)).start();
		new Thread(new Thread2(resource1, resource2)).start();

		
	}
}
