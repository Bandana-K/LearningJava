package TestOverloadingWithInheritance;

public class Driver {

	public static void main(String[] args) {
		
		Driver d = new Driver();
		Animal animal = new Animal();
		Cat cat = new Cat();
		Animal dontKnow = new Cat();
		var varAnimal = new Cat();

		
		d.print(animal);
		d.print(cat);
		d.print(dontKnow);
		d.print(varAnimal);

	}
	
//  This is Overloading, hence the compiler checks the reference type to resolve for the method calls, and goes for the closest match
//	In case of line 10, reference is Animal, so the method accepting Animal is called
//  However in line 11, we declared it as var, so the compiler cann't rely in left side reference, 
//	and will look out for  right side, which is Cat, hence the method accepting Cat will be called
	
	
	void print(Animal a) {
		System.out.println("Inside Animal");
	}
	
	void print(Cat c) {
		System.out.println("Inside Cat");
	}

}

class Animal{
	
}

class Cat extends Animal{
	
}