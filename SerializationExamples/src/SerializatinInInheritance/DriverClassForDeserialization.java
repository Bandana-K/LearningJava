package SerializatinInInheritance;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DriverClassForDeserialization {

	public static void main(String[] args) {
		
		Employee bandana = null ;

		try {
			
			FileInputStream fis = new FileInputStream("bandana.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			bandana = (Employee) ois.readObject();
			
			System.out.println("Done with reading the object from the file");
			ois.close();
			fis.close();
			
		} catch(Exception e) {
			System.err.println("Error occured in deSerializing the object" + e.getMessage());
		}
		
		//As the contact is static hence, that value has been derived. However s the id was transient hence it was not serialized ever
		System.out.println("Bandana object created with values " + bandana.getName() + " id = "+ bandana.getEmployeeId()  + "  contact  = "  +bandana.getContact());
		
	}
}
	
