package TestClone;
import java.util.Arrays;
import java.util.List;

public class TestCloneDefaultBehaviour implements Cloneable{
	
	String name;
	List<String> testListObj;
	
	TestCloneDefaultBehaviour(String name, List<String>  testListObj){
		this.name = name;
		this.testListObj = testListObj;
	}
	
	public static void main(String args[]) {
		
		String array[] = {"WHEN", "HOW"};		
		List<String> testList = Arrays.asList(array);
		
		TestCloneDefaultBehaviour obj1 = new TestCloneDefaultBehaviour("Bandana", testList);
		TestCloneDefaultBehaviour obj2 = null;		
		
		try {
			obj2 =  (TestCloneDefaultBehaviour) obj1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		//both the string name and the list testListObj from both the objects are pointing to the same memory location
		//However the hashCode of obj1 and obj2 are different which means a different memory location has been given to the obj2

		System.out.println( "Object 1 hashcode =  "  + obj1.hashCode() + " object2 hashcode = " + obj2.hashCode());
		System.out.println( "Object 1 name hashcode=  "  + obj1.name.hashCode() + " object2 name hashcode= " + obj2.name.hashCode());
		System.out.println( "Object 1 natestListObjme hashcode=  "  + obj1.testListObj.hashCode() + " object2 testListObj hashcode= " + obj2.testListObj.hashCode());
		
		System.out.println( "Object 1 name =  "  + obj1.name + " object2 name = " + obj2.name);
		System.out.println( "Object 1 testListObj =  "  + obj1.testListObj + " object2 testListObj = " + obj2.testListObj);

	}


}
