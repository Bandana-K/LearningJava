package BasicSerialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class DriverClassForSerialization {

	public static void main(String[] args) {
		
		Student bandana = new Student("bandana", 620);

		try {
			
			FileOutputStream fos = new FileOutputStream("student.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(bandana);
			
			oos.close();
			fos.close();
			
		} catch(Exception e) {
			System.err.println("Error occured in serializing the object" + e.getMessage());
		}
		
		System.out.println("Done with writing the object to the file");

	}

}
