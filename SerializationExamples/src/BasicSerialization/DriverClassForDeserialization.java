package BasicSerialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DriverClassForDeserialization {

	public static void main(String[] args) {
		
		Student bandana = null ;

		try {
			
			FileInputStream fis = new FileInputStream("student.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			bandana = (Student) ois.readObject();
			
			System.out.println("Done with reading the object from the file");
			ois.close();
			fis.close();
			
		} catch(Exception e) {
			System.err.println("Error occured in deSerializing the object" + e.getMessage());
		}
		
		//As the contact is static hence, that value has been derived. However s the id was transient hence it was not serialized ever
		System.out.println("Bandana object created with values " + bandana.name + " id = "+ bandana.id  + "  contact  = "  +bandana.contact);
		
	}
}
	
