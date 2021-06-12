package TestInheritance2;

public class DriverClass {

	public static void main(String[] args) {
 		
		Child childObj = new Child();
		System.out.println("childObj value =  "  + childObj.value  + "  testInheritance in childObj  = "  + childObj.testInheritance);
		childObj.printValue();

		Parent childObjWithParentRef =  new Child();
		
		//to this object, as it has refernce to Parent class, it has no visibility of printValue. Hence only method  left to call is print()
		childObjWithParentRef.print(); 
		
		System.out.println(childObj.value);
		System.out.println(childObjWithParentRef.value);

		
	}

}
