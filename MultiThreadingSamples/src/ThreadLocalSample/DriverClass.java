package ThreadLocalSample;

import java.util.*;

public class DriverClass {

	public static void main(String[] args) throws InterruptedException {
		
//		when  the list is passed as a shared object to the below 2 threads, the changes done within the each thread is also reflected to otehrs.
//		that can be seen printing the list  in the main thread itself
		
		List<String> countries = new ArrayList<>();		
		new Thread(new Continent("ASIA", countries)).start();
		new Thread(new Continent("EUROPE", countries)).start();
		
		Thread.sleep(2000);
		System.out.println("countries  : "  + countries);
		
//		when  the list is passed as a shared object to the below 2 threads, they make a threadlocal copy of the original object.
//		Hence  the changes don on them is not reflected to others
//		that can be seen printing the list  in the main thread itself
		
		List<String> threadLocalCountries = new ArrayList<>();
		new Thread(new ContinentWithThreadLocal("ASIA", threadLocalCountries)).start();
		new Thread(new ContinentWithThreadLocal("EUROPE", threadLocalCountries)).start();
		
		Thread.sleep(2000);
		System.out.println("threadLocalCountries : " + threadLocalCountries);
	}

}
