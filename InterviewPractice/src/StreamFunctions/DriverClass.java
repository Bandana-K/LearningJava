package StreamFunctions;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DriverClass {

	public static void main(String[] args) {
//2. Using Java streams write code to convert numbers to their squares
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(7);

		nums.stream().map(num -> num * num).forEach(num -> System.out.println(num));

//3. Get the minimum, maximum, average and total sum of all teh numbers

		DoubleSummaryStatistics statistics = nums.stream().mapToDouble(num -> num).summaryStatistics();

		System.out.println("Count : " + statistics.getCount());
		System.out.println("Sum : " + statistics.getSum());
		System.out.println("Minimum : " + statistics.getMin());
		System.out.println("Maximum : " + statistics.getMax());
		System.out.println("Average : " + statistics.getAverage());

//4. Find the numbers which are even and which are odd using java 8 features.

		Map<Boolean, List<Integer>> partition = nums.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));

		System.out.println("Even numbers : " + partition.get(true));
		System.out.println("Odd numbers : " + partition.get(false));

//5. Write a program to get all the nums comma seprated
		String allNums = nums.stream().map(num -> String.valueOf(num)).collect(Collectors.joining(" , "));
		System.out.println("Collectors.joining() : " + allNums);

//6. Using Java streams write code to number of times a character appears in a string
		String test = "IndiaIsMyCountry";
		int count = (int) test.chars().filter(current -> (current == 'I' || current == 'i')).count();
		System.out.println(count);

//7. sum of square of all the odd numbers from the list using java 8 features
		statistics =  nums.stream()
				.filter( num -> (num%2 == 1))
				.mapToDouble( num -> (num*num))
				.summaryStatistics();
		System.out.println("Odd numbers sum : " + statistics.getSum());

		

		// 7. If 2 overloaded methods accept Integer and String, and we call them by
		// passing null, which one will be called
//				testMethod(null);	//The method testMethod(Integer) is ambiguous for the type DriverClass

	}

	private static void testMethod(Integer object) {

	}

	private static void testMethod(String object) {

	}

}
