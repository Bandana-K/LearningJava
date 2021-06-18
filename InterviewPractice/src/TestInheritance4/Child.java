package TestInheritance4;

public class Child extends Parent{

	public void walk() {
		super.walk();
		System.out.println("I am child walking");
	}
	
	public void run() {
		super.run();
		System.out.println("I am child running");
	}
}
