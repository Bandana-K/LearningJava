import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.javacodegeeks.com/2018/01/deal-concurrentmodificationexception-java-beware-removing-elements-arraylist-loop.html
public class ArrayList_ConcModException {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("WHY");
		list.add("WHEN");
		list.add("WHERE");
		list.add("HOW");
		list.add("WHAT");

//		Sample1:
//		the below code will never throw any exception. The reason is we are iterating over the loop using normal variable i, We are not using iterator.next() anywhere, which is responsible
//		for checking concurrent modification and throwing it.
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			String word = list.get(i);
			if (word.equals("HOW"))
				list.remove(word);
		}
		System.out.println(list);


//		Sample2:
//		the below code will never throw any exception. The reason is we are iterating over the loop and modifying it both using the iterator's methods.
//		System.out.println(list);
//		Iterator<String> itr = list.iterator();
//		while (itr.hasNext()) {
//			String word = itr.next();
//			if (word.equals("WHERE"))
//				itr.remove();
//			else 
//				System.out.println(word);
//		}
//		System.out.println(list);
		

//		The reason why the below two samples throw exception is cause the array is being modified by calling ArrayList.remove method, while its being iterated by using iterator.next()
		
//		Sample3:
//		when we call the method remove, it removes the element from list, and adjusts the list to new size, ie, previousSize -1
//		when it tries to go to next element, itr.next() gets called and the very first line checks for the concurrentModification, which is true, so throws the exception
//		However in case of last-1 element deletion, when the list adjusts its size,for it hasNext() will return no other element, so next() never gets called hence, no exception
//		Also that's the reason in the below code when "HOW" is deleted, the for loop is not executed for the next element "WHAT"
//		System.out.println(list);
//		for (String word : list) {
//			if (word.equals("HOW"))
//				list.remove(word);
//			else 
//				System.out.println(word);
//		}

		
//		Sample4:
//		System.out.println(list);
//		Iterator<String> itr = list.iterator();
//		while (itr.hasNext()) {
//			String word = itr.next();
//			if (word.equals("WHERE"))
//				list.remove(word);
//			else 
//				System.out.println(word);
//		}
//		System.out.println(list);
			
	}
}
