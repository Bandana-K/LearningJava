package ForkAndJoinPoolSample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class DriverClass {
	
	//this sample project creates a list of 1000 numbers and calculates its square by using  forkAndJoin  pool
	//test the performance with various size of list and various values for threshHold limit in recurrsiveTask

	public static void main(String[] args) {

		List<Integer> list = new  ArrayList<>();
		for(int i=1; i<=1000; i++) {
			list.add(i);
		}
		
		System.out.println("list : " + list);
		
		long startTime = System.currentTimeMillis();
		
		IntegerToSquareTransformer reccursiveTask = new IntegerToSquareTransformer(list);
        ForkJoinPool pool = new ForkJoinPool();
        List<Integer> result = pool.invoke(reccursiveTask);
 
        long endTime = System.currentTimeMillis();
 
        System.out.println("Result list: " + result);
        System.out.println("Time taken for computation is " + (endTime - startTime) + " milliseconds");

	}

}
