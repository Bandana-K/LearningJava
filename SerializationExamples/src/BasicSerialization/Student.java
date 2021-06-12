package BasicSerialization;

import java.io.Serializable;

public class Student implements Serializable {
		
    private static final long SerialVersionUID = 20l;

	String name;
	transient int id;
	static String contact = "No contact here";
	
	Student(String name, int id){	
		
		System.out.println("Inside Student constructor");
		this.name= name;
		this.id = id;		
	}

}
