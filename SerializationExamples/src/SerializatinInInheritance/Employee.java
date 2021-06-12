package SerializatinInInheritance;

import java.io.Serializable;

public class Employee extends Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String employerName; 
	private String employeeId;
	
	Employee(String name, String contact, String employer, String employeeId) {
		
		super(name, contact);
		System.out.println("Inside Employee constructor");
		this.employerName = employer;	
		this.employeeId = employeeId;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
