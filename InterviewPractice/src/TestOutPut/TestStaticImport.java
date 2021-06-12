package TestOutPut;

import static java.lang.Integer.*;
import static TestOutPut.TestStaticValue.*;


public class TestStaticImport {

	public static void main(String args[]) {
	
//	This line gives compile time error as there are 2 fields imported statically
//	The field MAX_VALUE is ambiguous
//	System.out.println(MAX_VALUE);  
	}
	
}

class TestStaticValue {
	static int MAX_VALUE = 50;

}