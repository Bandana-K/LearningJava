package ForkAndJoinPoolSample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class DriverClass {

	public static void main(String[] args) {

		List<Integer> list = new  ArrayList<>();
		for(int i=1; i<=1000; i++) {
			list.add(i-1, i);
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
