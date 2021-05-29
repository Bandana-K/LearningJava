package TestOverLoading;

public class TestOverLoading {
	
	public static void main(String args[]) {
		
		//test the output for line 9, by removing methods defined below in  increasing  sequence
		TestOverLoading obj = new TestOverLoading();
		obj.test('a');
	}
	
	void test(char a) {
		System.out.println("test(char a), value =" + a);
	}
	
	void test(int a) {
		System.out.println("test(int a), value =" + a);
	}
	
	void test(long a) {
		System.out.println("test(long a), value =" + a);
	}
	
	void test(float a) {
		System.out.println("test(float a), value =" + a);
	}
	
	void test(double a) {
		System.out.println("test(double a), value =" + a);
	}

	void test(char... args) {
	System.out.println("Inside test(String... args), value =" + args.length);
}
	
	//below code is not allowed , as variable args and array params are considered same internally
//	void test(char[] args) {
//	System.out.println("Inside test(String[] args)");
//	}
	
}
