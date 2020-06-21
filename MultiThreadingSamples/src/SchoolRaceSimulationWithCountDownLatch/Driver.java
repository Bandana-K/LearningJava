package SchoolRaceSimulationWithCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Driver {
	
	public static void main(String[] args) throws InterruptedException {
		
		int noOfParticipants = 10;		
		CountDownLatch latch = new CountDownLatch(noOfParticipants);
		
		for(int i = 0; i< noOfParticipants ; i++) {
			RaceParticipant participant = new RaceParticipant("Thread "+ i, latch);
			participant.start();
			
			if(i != (noOfParticipants-1))
				latch.countDown();
		}
		
		Thread.sleep(1000);
		System.out.println("On your marks, \nGet... \nSet... \nGo !!!");
		latch.countDown();
	}
	
}
