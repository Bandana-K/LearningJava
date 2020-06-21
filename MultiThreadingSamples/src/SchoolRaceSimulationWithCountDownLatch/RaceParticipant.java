package SchoolRaceSimulationWithCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class RaceParticipant extends Thread {
	
	private String name;
	private CountDownLatch latch;
	
	RaceParticipant(String name, CountDownLatch latch){
		this.name = name;
		this.latch = latch;
	}
	
	public void run() {
		
		System.out.println("participant "+ name + " in position");
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			System.out.println();
		}
		
		for(int i = 0 ; i< 100 ; i++) {
			
		}
		
		System.out.println("Task completed for participant "+ name);
			
	}

}
