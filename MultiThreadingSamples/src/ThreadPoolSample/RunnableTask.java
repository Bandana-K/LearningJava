package ThreadPoolSample;

public class RunnableTask implements Runnable{
	
	private String taskName;
	
	public RunnableTask(String name) {
		taskName = name;
	}

	@Override
	public void run() {
		System.out.println("Running the task with name : " + taskName);
	}

}
