package NoClassDefFoundErrorSample;

public class StaticTest {
	
	static {
		int a = 10/0;
	}
	
	public static void print() {
		System.out.println("Hello, i am inside print method");
	}

}
