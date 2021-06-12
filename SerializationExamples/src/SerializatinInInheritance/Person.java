package SerializatinInInheritance;

public class Person {
		
    private String name;
    private String contact;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	Person(String name, String contact){	
		
		System.out.println("Inside Person constructor");
		
		this.name= name;
		this.contact = contact;		
	}

}
