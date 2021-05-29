package TestInheritance3;

class Child extends Parent{
	
//	@Override 				//As the m1() method in parent is private, hence it not visible to child class, hence writing override notation, says, its not present
	private void m1() {
		System.out.println("Inside m1 of Child");
	}
	
	//This must be declared static, if the parent method  signature has static  in it. Else compile  time error
	static void m2() {
		System.out.println("Inside static m2 of Child");
	}
	
	void m3() {
		System.out.println("Inside m3 of Child");
	}
	
	//Cannot override the final method from Parent
//	void m4() {
//		System.out.println("Inside m4 of Child");
//	}
	
}