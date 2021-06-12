package SerializatinInInheritance;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class DriverClassForSerialization {

	public static void main(String[] args) {
		
		Employee bandana = new Employee("Bandana", "Bellandur", "Wissen Technolohgy", "WT326");

		try {
			
			FileOutputStream fos = new FileOutputStream("bandana.txt");
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
