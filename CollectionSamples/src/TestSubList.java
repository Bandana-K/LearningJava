import java.util.*;

public class TestSubList {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("HI");
		list.add("HELLO");
		list.add("BYE");
		
		List<String> subList = list.subList(0, 2);
		System.out.println(subList);
		System.out.println(subList.size());
		
		System.out.println( "SubList hashcode =  "  + subList.hashCode() + " list hashcode = " + list.hashCode());
		
		//below lines are fine to be executed

//		list.add("CHECK");
//		System.out.println(list.size());
//		
//		subList.add("CHECK");
//		System.out.println(subList.size());
		
		//However if we modify the list and then perform any operation on sublist, it throws exception, when the sublist's method is executed.
		
		list.add("CHECK");
		System.out.println(subList.size());		
		
//		Exception in thread "main" java.util.ConcurrentModificationException
//		at java.base/java.util.ArrayList$SubList.checkForComodification(ArrayList.java:1411)
//		at java.base/java.util.ArrayList$SubList.size(ArrayList.java:1151)
//		at TestSubList.main(TestSubList.java:29)

	}
}
