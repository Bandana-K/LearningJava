import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestUnmodifiableList {
	
	public static void main(String args[]) {
		
		String array[] = {"WHEN", "HOW"};
		
		List<String> testList = Arrays.asList(array);	
        List<String> immutablelist = Collections.unmodifiableList(testList);
        
//      Below code gives an exception,
//      Exception in thread "main" java.lang.UnsupportedOperationException
//    	at java.base/java.util.AbstractList.add(AbstractList.java:153)
//    	at java.base/java.util.AbstractList.add(AbstractList.java:111)
//    	at RingCentral.TestUnmodifiableList.main(TestUnmodifiableList.java:21)
		testList.add("WHY");
        
        
//      Below code gives exception, as its an unmodifiable list
//      Exception in thread "main" java.lang.UnsupportedOperationException
//    	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1060)
//    	at RingCentral.TestUnmodifiableList.main(TestUnmodifiableList.java:28)
        immutablelist.add("WHAT");
		
		System.out.println(testList);
		System.out.println(immutablelist);
		
		
	}

}
