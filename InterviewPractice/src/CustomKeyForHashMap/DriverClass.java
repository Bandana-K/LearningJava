package CustomKeyForHashMap;

import java.util.HashMap;
import java.util.Map;

public class DriverClass {

	public static void main(String[] args) {

// If hashCode always return same value, then size will increase, but all the nodes will be sitting on the same bucket index
		Map<Employee, Integer> map = new HashMap<>();
		map.put(new Employee(1, "Bandana"), 1200);
		map.put(new Employee(1, "Prakash"), 2400);
		map.put(new Employee(1, "Pooja"), 3600);
		
		System.out.println(map.size());
	}
}
