package TestOutPut;

public class TestScopedVaribale {

	int x = 5;
	int y = 10;
	
	public static void main(String args[]) {
		TestScopedVaribale obj = new TestScopedVaribale();
		obj.testVar(0);
	}

	private void testVar(int x) {
		System.out.println(x);		 //prints 0, As the scoped variable takes priority over the instance variable, if its not referenced explicitly as this....
	}

}
