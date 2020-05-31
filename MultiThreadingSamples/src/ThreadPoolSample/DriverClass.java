package ThreadPoolSample;

public class DriverClass {

	public static void main(String[] args) {
		
		ThreadPool pool = new ThreadPool(5);
		for(int i =0; i<5; i++) {
			RunnableTask task  = new RunnableTask("Thread - " +i);
			pool.execute(task);
		}	
	}

}
