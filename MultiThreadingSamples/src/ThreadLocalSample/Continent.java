package ThreadLocalSample;

import java.util.*;

public class Continent implements Runnable{
	
	private List<String> countryList;
	private String continent;
	
	Continent(String continent, List<String> list){
		this.continent = continent;
		countryList = list;
	}

	@Override
	public void run() {
		if(continent.equals("EUROPE")) {
			countryList.add("ENGLAND");
			countryList.add("ITALY");
			countryList.add("SPAIN");
		} else {
			countryList.add("INDIA");
			countryList.add("PAKISTAN");
			countryList.add("BANGLADESH");
		}
		
	}

}
