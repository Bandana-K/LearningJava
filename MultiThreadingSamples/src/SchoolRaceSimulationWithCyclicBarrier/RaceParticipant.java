package SchoolRaceSimulationWithCyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RaceParticipant extends Thread {
	
	private String name;
	private CyclicBarrier barrier;
	
	RaceParticipant(String name, CyclicBarrier barrier){
		this.name = name;
		this.barrier = barrier;
	}
	
	public void run() {
		
		System.out.println("participant "+ name + " in position");
		
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			System.err.println("Exception occured  "  + e.getMessage());
		}
		
		for(int i = 0 ; i< 100 ; i++) {
			
		}
		
		System.out.println("Task completed for participant "+ name);
			
	}

}
