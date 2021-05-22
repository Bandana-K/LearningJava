package NoClassDefFoundErrorSample;

public class DriverClass {

//	Exception in thread "main" java.lang.ExceptionInInitializerError
//	at NoClassDefFoundErrorSample.DriverClass.main(DriverClass.java:18)
//	Caused by: java.lang.ArithmeticException: / by zero
//	at NoClassDefFoundErrorSample.StaticTest.<clinit>(StaticTest.java:10)
//	... 1 more
	
	//At compile time there is no issue, however when we run the app
	//while class loading, the static block executes and throws an ArithmeticException exception
	//Hence the class StaticTest is not loaded, which leads  to issue of NoClassDefFoundErrorSample
	
	//Also the order in which you write the static block doesn't matter,
	//coz all the static blocks and  methods are ran/loaded at the time of classLoading

	public static void main(String[] args) {
		new StaticTest().print();
	}
}
