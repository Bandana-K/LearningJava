package SchoolRaceSimulationWithCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Driver {
	
	public static void main(String[] args) throws InterruptedException {
		
		int noOfParticipants = 10;		
		CountDownLatch latch = new CountDownLatch(noOfParticipants);
		
		for(int i = 1; i<= noOfParticipants ; i++) {
			RaceParticipant participant = new RaceParticipant("Thread "+ i, latch);
			participant.start();
			
			//we need to make sure that all the 10 threads are already in their position, before calling the last countDown.
			//To make sure that only, we are calling the last countDown outside after a sleep of 1000 secs
			
			if(i != (noOfParticipants-1))
				latch.countDown();
		}
		
		Thread.sleep(1000);
		System.out.println("On your marks, \nGet... \nSet... \nGo !!!");
		latch.countDown();
	}
	
}
