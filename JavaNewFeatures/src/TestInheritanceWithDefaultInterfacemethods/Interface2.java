package TestInheritanceWithDefaultInterfacemethods;

public interface Interface2 {
	
	//If method bodies are being given, compiler asks you mandatorily to declare the methods as default or  static
	
	void abstractMethod();
	
	default void defaultMethod() {
		System.out.println("Inside defaultMethod of Interface2");
	}
	
	static void staticMethod() {
		System.out.println("Inside staticMethod of Interface2");
	}

}
