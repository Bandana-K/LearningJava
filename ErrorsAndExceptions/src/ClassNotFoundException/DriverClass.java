package ClassNotFoundException;

public class DriverClass {

//	java.lang.ClassNotFoundException: ErroringClass
//	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:602)
//	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
//	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
//	at java.base/java.lang.Class.forName0(Native Method)
//	at java.base/java.lang.Class.forName(Class.java:333)
//	at ClassNotFoundException.DriverClass.main(DriverClass.java:20)
	
	//At compile time there is no issue, however when we run the app
	//while class loading, the static block executes and throws an ArithmeticException exception
	//Hence the class StaticTest is not loaded, which leads  to issue of ClassNotFoundException
	
	//Also the order in which you write the static block doesn't matter,
	//coz all the static blocks and  methods are ran/loaded at the time of classLoading

	public static void main(String[] args) {
		try {
			Class className = Class.forName("ErroringClass");
			ErroringClass obj = (ErroringClass) className.newInstance();
			obj.print();
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} 
	}
}
