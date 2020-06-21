package PrintOddEvenInSequenceUsingTwoThreads;

public class Counter {
	
	private int end;
	private int currentCount;
	
	Counter(int start, int end){
		this.currentCount = start;
		this.end = end;
	}
	 
	public static void main(String args[]) {
		
		int start = 1;
		int end = 20;
		
		Counter count = new Counter(start, end);
		
		Thread odd = new Thread(new Runnable() {
			@Override
			public void run() {
				count.printOdd();				
			}
		});
		
		Thread even = new Thread(new Runnable() {

			@Override
			public void run() {
				count.printEven();				
			}
		});
		
		odd.start();
		even.start();
	}
	
	private void printOdd() {
		try {
			while(currentCount < end) {
				synchronized (this) {
					
					while(currentCount%2 == 0)
						wait();
					
					System.out.println(currentCount++);
					notify();
					
				}
			}		
		} catch(InterruptedException e) {
			System.out.println("printOdd interrupted");
		}
	}
	
	private void printEven() {
		try {
			while(currentCount < end) {
				synchronized (this) {
					
					while(currentCount%2 != 0)
						wait();
					
					System.out.println(currentCount++);
					notify();
					
				}
			}
		} catch(InterruptedException e) {
			System.out.println("printEven interrupted");
		}
	}

}
