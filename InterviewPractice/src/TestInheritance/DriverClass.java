package TestInheritance;

public class DriverClass {

	public static void main(String[] args) {
 
//		SuperClass super = new SuperClass();
		SuperClass superObj = new SubClass();
		SubClass subObj = new SubClass();

		System.out.println("super count value is : " + superObj.count + " name is : " + superObj.name);
		System.out.println("sub count value is : " + subObj.count + " name is : " + subObj.name);
		

		
	}

}
