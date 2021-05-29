package ClassNotFoundException;

public class ErroringClass {
	
	public static void PrintMessage() {
		System.out.println("Hello, i am inside printMessages method");
	}
	
	ErroringClass(){
		System.out.println("Inside ErroringClass constructor");
	}
	
	static {
		int a = 10/0;
	}
	
	public void print() {
		System.out.println("Hello, i am inside print method");
	}

}
