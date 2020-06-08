package java10Features;
import java.util.ArrayList;

public class VarVariables {

	public static void main(String[] args) {
		
//		var variable was added as a part of java 10 release, but it can only be used for Local variables.
//		its based on Local variable Type Inference
//		var cannot be used for method params, as it doesn't help the compiler to decide what type to look for
//		and can lead issue with method over loading
		
		var name = "Bandana";
		System.out.println(name);
		
//		name = 10; gives compile time error, Type mismatch : cannot convert int to string
		
//		while creating a list the type is inferred based on the left side type, exp :
//		List<String> list = new ArrayList<>();
//		but if we don't define the  type and use var for it, then the arraylist is created for the superType :  OBJECT
		var objectList  = new ArrayList<>();
		objectList.add(1);
		objectList.add("Hello");
		objectList.add(false);
		
		System.out.println(objectList);
		
//		best use of var is to make sure when there are big variable names, we can reduce boilerPlate, by creating it as var
//		we should decide the tradesOffs between :
//		making code readable by keeping the variables as var and removing boilerPlate
//		OR
//		letting the customer guess whats the return type for the messages
	}
}
