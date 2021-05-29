package TestStaticValueWithNullObject;

import java.util.ArrayList;
import java.util.List;

public class DriverClass {

	public static void main(String[] args) {
		Test objTest = null;
		var x = Test.nameList;
		
		x.add("POOJA");

		System.out.println("nameList = " + Test.nameList);		
		System.out.println("nameList = " + objTest.nameList);		
		//even though the objTest is null, static variables can be accessed by it. However its not good practice
		//Also any modification in the memory location of the static variable, done after the class loading, will also be reflected in it.

	}

}

class Test{
	
	static List<String> nameList = new ArrayList<>();
	
	static {
		nameList.add("BANDANA");
		nameList.add("PRAKASH");
	}
}