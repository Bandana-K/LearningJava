package BasicSerialization;

import java.io.Serializable;

public class Student implements Serializable {
		
	String name;
	transient int id;
	static String contact = "No contact here";
	
	Student(String name, int id){		
		this.name= name;
		this.id = id;		
	}

}
