package TestInheritance3;

public class DriverClass {

	public static void main(String[] args) {
 		
		Child childObj = new Child();
		Parent childObjWithParentRef =  new Child();
		
		childObj.m2();
		childObjWithParentRef.m2();
		
		childObj.m3();
		childObjWithParentRef.m3();

		
	}

}
