package TestInheritance2;

class Child extends  Parent{
	
	int value = 10;
	
	void printValue() {
		System.out.println("inside child : printValue, value =  "+ value);
		print();
	}
	
}