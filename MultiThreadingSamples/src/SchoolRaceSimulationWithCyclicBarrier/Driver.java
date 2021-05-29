package SchoolRaceSimulationWithCyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Driver {
	
	public static void main(String[] args) throws InterruptedException {
		
		int noOfParticipants = 10;		
		CyclicBarrier barrier = new CyclicBarrier(noOfParticipants);
		
		for(int i = 1; i<= noOfParticipants ; i++) {
			RaceParticipant participant = new RaceParticipant("Thread "+ i, barrier);
			participant.start();
			
			//As soon as the last thread reaches and  calls for await method the barrier is broken, And  all the waiting threads are released. 
			//hence the race starts
			
		}
	}
	
}
