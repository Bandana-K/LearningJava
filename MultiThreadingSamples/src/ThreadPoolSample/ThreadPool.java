package ThreadPoolSample;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool 
{
    private int size;	//size of the threadPool
    private final WorkerThread[] threads;	//array of threads which will be executing the tasks, they will be started as soon as the  ThreadPool object is created
    private final LinkedBlockingQueue<Runnable> taskList;	//List of tasks to be stored, if all the threads are already processing some tasks, the incoming  tasks will be  stored here
 
    public ThreadPool(int size) 
    {
        this.size = size;
        taskList = new LinkedBlockingQueue<Runnable>();
        threads = new WorkerThread[size];
 
        for (int i = 0; i < size; i++) {
        	threads[i] = new WorkerThread();
        	threads[i].start();
        }
    }
 
    //when  execute is called, add the taks to the taskList
    //which  will be  taken up by threads to be served
    public void execute(Runnable task) {
        synchronized (taskList) {
        	taskList.add(task);
        	taskList.notify();
        }
    }
 
    //get the task in FIFO manner from the queue and  execute it
    private class WorkerThread extends Thread {
    	
        public void run() {
            Runnable task;
 
            while (true) {
                synchronized (taskList) {
                    while (taskList.isEmpty()) {
                        try {
                        	taskList.wait();
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    task = (Runnable) taskList.poll();
                }
 
                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
 
    public void shutdown() {
        System.out.println("Shutting down thread pool");
        for (int i = 0; i < size; i++) {
        	threads[i] = null;
        }
    }
}