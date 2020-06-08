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
		
		list.add("CHECK");
		System.out.println(subList.size());
		
//		Exception in thread "main" java.util.ConcurrentModificationException
//		at java.base/java.util.ArrayList$SubList.checkForComodification(ArrayList.java:1411)
//		at java.base/java.util.ArrayList$SubList.size(ArrayList.java:1151)
//		at TestSubList.main(TestSubList.java:17)

	}
}
