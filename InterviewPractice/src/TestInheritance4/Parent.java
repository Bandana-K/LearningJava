package TestInheritance4;

public class Parent {
	
	public void walk() {
		System.out.println("I am Parent walking");
	}
	
	public void run() {
		walk();
		System.out.println("I am Parent running");
	}
}
