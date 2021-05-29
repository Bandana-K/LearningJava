package TestInheritanceWithDefaultInterfacemethods;

public class ImplementingClass1 implements Interface1, Interface2{

//	As soon as we say that class implements both the interfaces, the compiler gives an error as below
//	Duplicate default methods named defaultMethod with the parameters () and () are inherited from the types Interface2 and Interface1
	
	@Override
	public void abstractMethod() {
		System.out.println("Insdie abstractMethod, implemented in ImplementingClass1");		
	}

	@Override
	public void defaultMethod() {
		System.out.println("Insdie defaultMethod, implemented in ImplementingClass1");		
		Interface1.super.defaultMethod();
	}
	
	void pritnStaticMethod() {
		System.out.println("Inside ImplementingClass1 : pritnStaticMethod");
		Interface1.staticMethod();
		Interface2.staticMethod();
	}
}
